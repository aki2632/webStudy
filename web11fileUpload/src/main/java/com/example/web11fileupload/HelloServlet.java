package com.example.web11fileupload;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

@WebServlet({"/home.do","/fileUpload.do"})
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if(sPath.equals("/home.do")){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if(sPath.equals("/fileUpload.do")){

            String name = "";
            int age = 0;
            String imgName = "default.png";

            if(JakartaServletFileUpload.isMultipartContent(request)){

                //업로드파일 객체 설정
                DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
                JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
                upload.setFileSizeMax(1024 * 1024 * 100);//파일 최대사이즈 제한

                //요청(request)으로부터 파일아이템들을 파싱
                List<FileItem> items = upload.parseRequest(request);

                //반복문을 통해 파일과 파라메터 정보획득
                for (FileItem item : items  ) {
                    System.out.println(item);
                    if(item.isFormField()){//name,age
                        if(item.getFieldName().equals("name")){
                            name = item.getString(Charset.forName("utf-8"));//"kim"한글처리
                        }
                        if(item.getFieldName().equals("age")){
                            age = Integer.parseInt(item.getString());//33
                        }

                    }else{
                        String originName = item.getName();//업로드 요청한 파일명(오리지널 파일명)

                        System.out.println("originName:"+originName);
                        System.out.println("originName.length():"+originName.length());

                        if(originName.length()>0){//파일정보가 있을때만 파일처리
                            //시스템시간을 이용한 유니크한 파일명으로 재생성해주기.
                            String temp = originName.substring(0,originName.lastIndexOf("."))+"_"+System.currentTimeMillis();
                            String type = originName.substring(originName.lastIndexOf("."));
                            System.out.println(temp);
                            System.out.println(type);
                            imgName = temp+type;//디비에 저장할 파일명

                            //이미지 저장
                            //이미지 저장할 폴더 찾기(리얼패스)
                            //프로젝트의 실경로가아님 배포경로를 의미한다.
                            String dir_path = request.getServletContext().getRealPath("/upload");
                            System.out.println(dir_path);

                            //프로젝트 경로 - C:\\MULTI_EDU_26\\web\\work\\web11fileUpload\\src\\main\\webapp\\upload
                            //배포경로 - C:\\MULTI_EDU_26\\web\\work\\web11fileUpload\\target\\web11fileUpload-1.0-SNAPSHOT\\upload

                            File f = new File(dir_path,imgName);

                            item.write(f.toPath());//지정한 경로에 업로드파일을 생성해줌.
                        }


                    }//end else
                }//end for...


            }//end if << Multipartfile검증


            System.out.println("name:"+name);
            System.out.println("age:"+age);
            System.out.println("imgName:"+imgName);

//            TestVO vo = new TestVO();
//            vo.setName(name);
//            vo.setAge(age);
//            vo.setImgName(imgName);
//            dao.insert(vo);

            response.sendRedirect("home.do?imgName="+imgName);
        }//end if...


    }//end doPost....

    public void destroy() {
    }
}