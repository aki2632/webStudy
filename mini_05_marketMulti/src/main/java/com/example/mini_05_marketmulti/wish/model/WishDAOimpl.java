package com.example.mini_05_marketmulti.wish.model;

import com.example.mini_05_marketmulti.cart.model.CartVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WishDAOimpl implements WishDAO {

    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "HR";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public WishDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(WishVO vo) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "insert into wish(num, mnum, pnum) values(seq_wish.nextval, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getMnum());
            pstmt.setInt(2, vo.getPnum());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return flag;
    }

    @Override
    public int delete(WishVO vo) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "delete from wish where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return flag;
    }

    @Override
    public WishVO selectOne(WishVO vo) {
        WishVO result = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from wish where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = new WishVO();
                result.setNum(rs.getInt("num"));
                result.setPnum(rs.getInt("pnum"));
                result.setMnum(rs.getInt("mnum"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return result;
    }

    @Override
    public List<WishVO> selectAll() {
        List<WishVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from wish order by num desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                WishVO vo = new WishVO();
                vo.setNum(rs.getInt("num"));
                vo.setMnum(rs.getInt("mnum"));
                vo.setPnum(rs.getInt("pnum"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return list;
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
