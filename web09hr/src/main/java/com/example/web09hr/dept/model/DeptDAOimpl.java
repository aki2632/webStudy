package com.example.web09hr.dept.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDAOimpl implements DeptDAO{

    //3-1 : 전역변수 설정
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hr";
    private static final String PASSWORD = "hi123456";
    private Connection conn;//커넥션객체
    private PreparedStatement pstmt;//쿼리(sql문-CRUD)실행객체
    private ResultSet rs;//select문 리턴 객체


    public DeptDAOimpl(){
        System.out.println("DeptDAOimpl()....");

        //1.jdbc라이브러리 세팅(경로설정)
        //C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib : ojdbc6.jar복사
        //내 프로젝트 >> lib폴더(없다면 생성)에 >> 복붙
        //상단 메뉴> File > Project Structure > Libraries > + : java 선택 > 복붙경로 > ojdbc6.jar선택


        //2.오라클 드라이버 클래스 찾아서 인식(연동)-객체 생성시 즉 생성자에서 구현
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(DeptVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");
            String sql = "insert into dept(department_id,department_name,manager_id,location_id) " +
                    " values(departments_seq.nextval,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getDepartment_name());
            pstmt.setInt(2,vo.getManager_id());
            pstmt.setInt(3,vo.getLocation_id());

            flag = pstmt.executeUpdate();
            System.out.println("flag:"+flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    @Override
    public int update(DeptVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");
            String sql = "update dept set " +
                    "department_name=?,manager_id=?,location_id=? " +
                    "where department_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getDepartment_name());
            pstmt.setInt(2,vo.getManager_id());
            pstmt.setInt(3,vo.getLocation_id());
            pstmt.setInt(4,vo.getDepartment_id());
            flag = pstmt.executeUpdate();
            System.out.println("flag:"+flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    @Override
    public int delete(DeptVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");
            String sql = "delete from dept where department_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getDepartment_id());
            flag = pstmt.executeUpdate();
            System.out.println("flag:"+flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    @Override
    public DeptVO selectOne(DeptVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);

        DeptVO vo2 = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");
            String sql = "select * from dept where department_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getDepartment_id());
            rs = pstmt.executeQuery();
            while(rs.next()){
                vo2 = new DeptVO();
                vo2.setDepartment_id(rs.getInt("department_id"));
                vo2.setDepartment_name(rs.getString("department_name"));
                vo2.setManager_id(rs.getInt("manager_id"));
                vo2.setLocation_id(rs.getInt("location_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return vo2;
    }

    @Override
    public List<DeptVO> selectAll() {
        System.out.println("selectAll()...");
        List<DeptVO> list = new ArrayList<>();

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "select * from dept order by department_id desc";
            pstmt = conn.prepareStatement(sql);

            //5. 반환(응답)
            rs = pstmt.executeQuery();//select문에서 만 사용하는 함수

            //6. rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                DeptVO vo = new DeptVO();
                vo.setDepartment_id(rs.getInt("department_id"));
                vo.setDepartment_name(rs.getString("department_name"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setLocation_id(rs.getInt("location_id"));
                list.add(vo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return list;
    }

    @Override
    public List<DeptVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);
        List<DeptVO> list = new ArrayList<>();

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "";

            if(searchKey.equals("department_name")){
                sql = "select * from dept where department_name like ? order by department_id asc";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+searchWord+"%");
            }else{
                sql = "select * from dept where manager_id=? order by department_id asc";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,Integer.parseInt(searchWord));
            }

            //5. 반환(응답)
            rs = pstmt.executeQuery();//select문에서 만 사용하는 함수

            //6. rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                DeptVO vo = new DeptVO();
                vo.setDepartment_id(rs.getInt("department_id"));
                vo.setDepartment_name(rs.getString("department_name"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setLocation_id(rs.getInt("location_id"));
                list.add(vo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return list;
    }
}
