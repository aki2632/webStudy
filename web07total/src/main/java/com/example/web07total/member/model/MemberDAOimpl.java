package com.example.web07total.member.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO{

    //3-1 : 전역변수 설정
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "JAVA";
    private static final String PASSWORD = "hi123456";
    private Connection conn;//커넥션객체
    private PreparedStatement pstmt;//쿼리(sql문-CRUD)실행객체
    private ResultSet rs;//select문 리턴 객체

    public MemberDAOimpl(){
        System.out.println("MemberDAOimpl()....");
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(MemberVO vo) {
        System.out.println("insert()....");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into member(num,id,pw,name,tel) " +
                    "values(seq_member.nextval,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getPw());
            pstmt.setString(3,vo.getName());
            pstmt.setString(4,vo.getTel());

            flag = pstmt.executeUpdate();//DML
            System.out.println("flag : "+ flag);
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
    public int update(MemberVO vo) {
        System.out.println("update()....");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update member set id=?,pw=?,name=?,tel=? " +
                    " where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getPw());
            pstmt.setString(3,vo.getName());
            pstmt.setString(4,vo.getTel());
            pstmt.setInt(5,vo.getNum());

            flag = pstmt.executeUpdate();//DML
            System.out.println("flag : "+ flag);

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
    public int delete(MemberVO vo) {
        System.out.println("delete()....");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from member " +
                    " where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            flag = pstmt.executeUpdate();//DML
            System.out.println("flag : "+ flag);

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
    public MemberVO selectOne(MemberVO vo) {
        System.out.println("selectOne()....");
        System.out.println(vo);
        MemberVO vo2 = null;
        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from member where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            rs = pstmt.executeQuery();

            while (rs.next()){
                vo2 = new MemberVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setId(rs.getString("id"));
                vo2.setPw(rs.getString("pw"));
                vo2.setName(rs.getString("name"));
                vo2.setTel(rs.getString("tel"));
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
    public List<MemberVO> selectAll() {
        System.out.println("selectAll()....");

        List<MemberVO> list = new ArrayList<>();

        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            //4. 쿼리문 전달(요청)
            String sql = "select * from member order by num desc";
            pstmt = conn.prepareStatement(sql);

            //5. 반환(응답)
            rs = pstmt.executeQuery();//select문에서 만 사용하는 함수

            //6. rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                MemberVO vo = new MemberVO();
                vo.setNum(rs.getInt("num"));
                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));
                vo.setTel(rs.getString("tel"));
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
    public List<MemberVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()....");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<MemberVO> list  = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");
            String sql = "";
            if(searchKey.equals("name")){
                sql = "select * from member where name like ? order by num desc";
            }else if(searchKey.equals("id")){
                sql = "select * from member where id like ? order by num desc";
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            //5. 반환(응답)
            rs = pstmt.executeQuery();//select문에서 만 사용하는 함수

            //6. rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                MemberVO vo = new MemberVO();
                vo.setNum(rs.getInt("num"));
                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));
                vo.setTel(rs.getString("tel"));
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
    public MemberVO login(String id, String pw) {
        System.out.println("login()....");
        MemberVO vo = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conn successed...");

            String sql = "SELECT * FROM member WHERE id = ? AND pw = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                vo = new MemberVO();
                vo.setNum(rs.getInt("num"));
                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));
                vo.setTel(rs.getString("tel"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return vo;
    }
}
