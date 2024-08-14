package com.example.mini_05_marketmulti.cart.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAOimpl implements CartDAO {

    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "HR";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public CartDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(CartVO vo) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "insert into cart(num, pnum, mnum, amountCount, priceCount) values(seq_cart.nextval, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getPnum());
            pstmt.setInt(2, vo.getMnum());
            pstmt.setObject(3, vo.getAmountCount());
            pstmt.setObject(4, vo.getPriceCount());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return flag;
    }

    @Override
    public int update(CartVO vo) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "update cart set pnum=?, mnum=?, amountCount=?, priceCount=? where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getPnum());
            pstmt.setInt(2, vo.getMnum());
            pstmt.setObject(3, vo.getAmountCount());
            pstmt.setObject(4, vo.getPriceCount());
            pstmt.setInt(5, vo.getNum());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return flag;
    }

    @Override
    public int delete(CartVO vo) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "delete from cart where num=?";
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
    public CartVO selectOne(CartVO vo) {
        CartVO result = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from cart where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = new CartVO();
                result.setNum(rs.getInt("num"));
                result.setPnum(rs.getInt("pnum"));
                result.setMnum(rs.getInt("mnum"));
                result.setAmountCount(rs.getInt("amountCount"));
                result.setPriceCount(rs.getInt("priceCount"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return result;
    }

    @Override
    public List<CartVO> selectAll() {
        List<CartVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from cart order by num desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CartVO vo = new CartVO();
                vo.setNum(rs.getInt("num"));
                vo.setPnum(rs.getInt("pnum"));
                vo.setMnum(rs.getInt("mnum"));
                vo.setAmountCount(rs.getInt("amountCount"));
                vo.setPriceCount(rs.getInt("priceCount"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return list;
    }

    @Override
    public List<CartVO> selectByMember(int mnum) {
        List<CartVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from cart where mnum=? order by num desc";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mnum);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CartVO vo = new CartVO();
                vo.setNum(rs.getInt("num"));
                vo.setPnum(rs.getInt("pnum"));
                vo.setMnum(rs.getInt("mnum"));
                vo.setAmountCount(rs.getInt("amountCount"));
                vo.setPriceCount(rs.getInt("priceCount"));
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
