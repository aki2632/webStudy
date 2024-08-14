package com.example.mini_05_marketmulti.review.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOimpl implements ReviewDAO {

    // 데이터베이스 연결 정보
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "HR";
    private static final String PASSWORD = "hi123456";

    // 데이터베이스 관련 변수
    private Connection conn;          // 데이터베이스 연결
    private PreparedStatement pstmt;  // SQL 쿼리 실행
    private ResultSet rs;             // SQL 쿼리 결과

    // JDBC 드라이버 로드
    public ReviewDAOimpl() {
        System.out.println("ReviewDAOimpl().....");
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver not found.", e);
        }
    }

    @Override
    public int insert(ReviewVO vo) {
        System.out.println("insert()....");
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established.");

            String sql = "INSERT INTO REVIEW (NUM, CONTENT, WRITER, RDATE, PNUM, IMG, RATE) " +
                    "VALUES (SEQ_REVIEW.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getContent());
            pstmt.setString(2, vo.getWriter());
            pstmt.setInt(3, vo.getPnum());
            pstmt.setString(4, vo.getImg());
            pstmt.setInt(5, vo.getRate());

            flag = pstmt.executeUpdate();
            System.out.println("Insert status: " + flag);

        } catch (SQLException e) {
            throw new RuntimeException("Error during insert operation.", e);
        } finally {
            closeResources();
        }

        return flag;
    }

    @Override
    public int update(ReviewVO vo) {
        System.out.println("update()....");
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established.");

            String sql = "UPDATE REVIEW SET CONTENT = ?, RATE = ?, IMG = ? WHERE NUM = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getContent());
            pstmt.setInt(2, vo.getRate());
            pstmt.setString(3, vo.getImg());
            pstmt.setInt(4, vo.getNum());

            flag = pstmt.executeUpdate();
            System.out.println("Update status: " + flag);

        } catch (SQLException e) {
            throw new RuntimeException("Error during update operation.", e);
        } finally {
            closeResources();
        }

        return flag;
    }

    @Override
    public int delete(ReviewVO vo) {
        System.out.println("delete()....");
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established.");

            String sql = "DELETE FROM REVIEW WHERE NUM = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());

            flag = pstmt.executeUpdate();
            System.out.println("Delete status: " + flag);

        } catch (SQLException e) {
            throw new RuntimeException("Error during delete operation.", e);
        } finally {
            closeResources();
        }

        return flag;
    }

    @Override
    public ReviewVO selectOne(ReviewVO vo) {
        System.out.println("selectOne()....");
        ReviewVO review = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established.");

            String sql = "SELECT * FROM REVIEW WHERE NUM = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());

            rs = pstmt.executeQuery();
            if (rs.next()) {
                review = new ReviewVO();
                review.setNum(rs.getInt("NUM"));
                review.setContent(rs.getString("CONTENT"));
                review.setWriter(rs.getString("WRITER"));
                review.setRdate(rs.getTimestamp("RDATE") != null ? rs.getTimestamp("RDATE").toString() : null);
                review.setPnum(rs.getInt("PNUM"));
                review.setImg(rs.getString("IMG"));
                review.setRate(rs.getInt("RATE"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error during selectOne operation.", e);
        } finally {
            closeResources();
        }

        return review;
    }

    @Override
    public List<ReviewVO> selectAll(int pnum) {
        System.out.println("selectAll()....pnum:" + pnum);
        List<ReviewVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established.");

            String sql = "SELECT * FROM REVIEW WHERE PNUM = ? ORDER BY NUM DESC";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pnum);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                ReviewVO vo = new ReviewVO();
                vo.setNum(rs.getInt("NUM"));
                vo.setContent(rs.getString("CONTENT"));
                vo.setWriter(rs.getString("WRITER"));
                vo.setRdate(rs.getTimestamp("RDATE") != null ? rs.getTimestamp("RDATE").toString() : null);
                vo.setPnum(rs.getInt("PNUM"));
                vo.setImg(rs.getString("IMG"));
                vo.setRate(rs.getInt("RATE"));
                list.add(vo);
            }

            System.out.println("Number of reviews retrieved: " + list.size());

        } catch (SQLException e) {
            throw new RuntimeException("Error during selectAll operation.", e);
        } finally {
            closeResources();
        }

        return list;
    }

    @Override
    public List<ReviewVO> searchList(String searchKey, String searchWord, int pnum) {
        System.out.println("searchList()....searchKey:" + searchKey);
        System.out.println("searchList()....searchWord:" + searchWord);
        List<ReviewVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established.");

            String sql;
            if ("content".equals(searchKey)) {
                sql = "SELECT * FROM REVIEW WHERE PNUM = ? AND CONTENT LIKE ? ORDER BY NUM DESC";
            } else if ("writer".equals(searchKey)) {
                sql = "SELECT * FROM REVIEW WHERE PNUM = ? AND WRITER LIKE ? ORDER BY NUM DESC";
            } else {
                throw new IllegalArgumentException("Invalid search key: " + searchKey);
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pnum);
            pstmt.setString(2, "%" + searchWord + "%");

            rs = pstmt.executeQuery();
            while (rs.next()) {
                ReviewVO vo = new ReviewVO();
                vo.setNum(rs.getInt("NUM"));
                vo.setContent(rs.getString("CONTENT"));
                vo.setWriter(rs.getString("WRITER"));
                vo.setRdate(rs.getTimestamp("RDATE") != null ? rs.getTimestamp("RDATE").toString() : null);
                vo.setPnum(rs.getInt("PNUM"));
                vo.setImg(rs.getString("IMG"));
                vo.setRate(rs.getInt("RATE"));
                list.add(vo);
            }

            System.out.println("Number of reviews found: " + list.size());

        } catch (SQLException e) {
            throw new RuntimeException("Error during searchList operation.", e);
        } finally {
            closeResources();
        }

        return list;
    }

    // 자원 해제
    private void closeResources() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close ResultSet.", e);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close PreparedStatement.", e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close Connection.", e);
            }
        }
    }
}
