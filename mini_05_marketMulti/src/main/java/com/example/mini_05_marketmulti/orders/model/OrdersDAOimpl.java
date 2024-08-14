package com.example.mini_05_marketmulti.orders.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOimpl implements OrdersDAO {

    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "HR";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public OrdersDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(OrdersVO vo) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "insert into orders(num, pnum, mnum, odate, address) values(seq_orders.nextval, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getPnum());
            pstmt.setInt(2, vo.getMnum());
            pstmt.setDate(3, vo.getOdate());
            pstmt.setString(4, vo.getAddress());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return flag;
    }

    @Override
    public int delete(OrdersVO vo) {
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "delete from orders where num=?";
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
    public OrdersVO selectOne(OrdersVO vo) {
        OrdersVO result = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from orders where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = new OrdersVO();
                result.setNum(rs.getInt("num"));
                result.setPnum(rs.getInt("pnum"));
                result.setMnum(rs.getInt("mnum"));
                result.setOdate(rs.getDate("odate"));
                result.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return result;
    }

    @Override
    public List<OrdersVO> selectAll() {
        List<OrdersVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from orders order by num desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                OrdersVO vo = new OrdersVO();
                vo.setNum(rs.getInt("num"));
                vo.setPnum(rs.getInt("pnum"));
                vo.setMnum(rs.getInt("mnum"));
                vo.setOdate(rs.getDate("odate"));
                vo.setAddress(rs.getString("address"));
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
