package com.example.mini_05_marketmulti.review.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOimpl implements ReviewDAO {

    //3-1 : 전역변수 설정
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "HR";
    private static final String PASSWORD = "hi123456";
    private Connection conn;//커넥션객체
    private PreparedStatement pstmt;//쿼리(sql문-CRUD)실행객체
    private ResultSet rs;//select문 리턴 객체

    public ReviewDAOimpl(){
        System.out.println("CommentsDAOimpl().....");

        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int insert(ReviewVO vo) {
        System.out.println("insert()....");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into comments(review_id,product_id,content,writer) " +
                    " values(seq_comments.nextval,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getProductId());
            pstmt.setString(2,vo.getContent());
            pstmt.setString(3,vo.getWriter());

            flag = pstmt.executeUpdate();//DML
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
        }//finally


        return flag;
    }

    @Override
    public int update(ReviewVO vo) {
        System.out.println("update()....");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update comments set content=?,wdate=sysdate " +
                    " where review_id=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,vo.getContent());
            pstmt.setInt(2,vo.getReviewId());

            flag = pstmt.executeUpdate();//DML
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
        }//finally


        return flag;
    }

    @Override
    public int delete(ReviewVO vo) {
        System.out.println("delete()....");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from comments " +
                    " where review_id=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,vo.getReviewId());

            flag = pstmt.executeUpdate();//DML
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
        }//finally


        return flag;
    }

    @Override
    public ReviewVO selectOne(ReviewVO vo) {
        System.out.println("selectOne()....");
        System.out.println(vo);
        ReviewVO vo2 = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from comments where review_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getReviewId());

            rs = pstmt.executeQuery();
            while(rs.next()){
                vo2 = new ReviewVO();
                vo2.setReviewId(rs.getInt("review_id"));
                vo2.setProductId(rs.getInt("product_id"));
                vo2.setContent(rs.getString("content"));
                vo2.setWriter(rs.getString("writer"));
                vo2.setWdate(new Timestamp(rs.getTimestamp("wdate").getTime()).toString());
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
        }//finally

        return vo2;
    }

    @Override
    public List<ReviewVO> selectAll(int product_id) {
        System.out.println("selectAll()....product_id:"+product_id);
        List<ReviewVO> list = new ArrayList<>();


        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from comments where product_id=? " +
                    " order by review_id desc";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,product_id);

            rs = pstmt.executeQuery();
            while(rs.next()){
                ReviewVO vo = new ReviewVO();
                vo.setReviewId(rs.getInt("review_id"));
                vo.setProductId(rs.getInt("product_id"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(new Timestamp(rs.getTimestamp("wdate").getTime()).toString());
                list.add(vo);
            }
            System.out.println("list.size():"+list.size());
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
        }//finally

        return list;
    }

    @Override
    public List<ReviewVO> searchList(String searchKey, String searchWord, int product_id) {
        System.out.println("searchList()....product_id:"+product_id);
        System.out.println("searchList()....searchKey:"+searchKey);
        System.out.println("searchList()....searchWord:"+searchWord);
        List<ReviewVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "";
            if(searchKey.equals("content")){
                sql = "select * from comments where product_id=? and content like ? " +
                        " order by review_id desc";
            }else{
                sql = "select * from comments where product_id=?  and writer like ? " +
                        " order by review_id desc";
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,product_id);
            pstmt.setString(2,"%"+searchWord+"%");

            rs = pstmt.executeQuery();
            while(rs.next()){
                ReviewVO vo = new ReviewVO();
                vo.setReviewId(rs.getInt("review_id"));
                vo.setProductId(rs.getInt("product_id"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(new Timestamp(rs.getTimestamp("wdate").getTime()).toString());
                list.add(vo);
            }
            System.out.println("list.size():"+list.size());
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
        }//finally

        return list;
    }
}
