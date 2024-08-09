package com.example.web07total.product.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOimpl implements ProductDAO {
    List<ProductVO> list = new ArrayList<>();

    //3-1 : 전역변수 설정
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "JAVA";
    private static final String PASSWORD = "hi123456";
    private Connection conn;//커넥션객체
    private PreparedStatement pstmt;//쿼리(sql문-CRUD)실행객체
    private ResultSet rs;//select문 리턴 객체

    public ProductDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int insert(ProductVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);

        int flag = 0;
        if (list.size() == 0) {
            vo.setNum(1);
        } else {
            vo.setNum(list.get(list.size() - 1).getNum() + 1);
        }
        list.add(vo);
        flag = 1;
        return flag;
    }


    @Override
    public int update(ProductVO vo) {
        System.out.println("update()...");
        System.out.println(vo);

        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNum() == vo.getNum()) {
                list.set(i, vo);
                flag = 1;
            }
        }
        return flag;
    }


    @Override
    public int delete(ProductVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNum() == vo.getNum()) {
                list.remove(i);
                flag = 1;
            }
        }
        return flag;
    }

    @Override
    public ProductVO selectOne(ProductVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);

        ProductVO vo2 = null;
        //3-2 : 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from product where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            rs = pstmt.executeQuery();

            while (rs.next()){
                vo2 = new ProductVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setPname(rs.getString("pname"));
                vo2.setModel(rs.getString("model"));
                vo2.setPrice(rs.getInt("price"));
                vo2.setCount(rs.getInt("count"));
                vo2.setUser_id(rs.getString("user_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vo2;
    }


    @Override
    public List<ProductVO> selectAll() {
        System.out.println("selectAll()...");

        List<ProductVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from product order by num desc";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();//DQL-select

            while(rs.next()){
                ProductVO vo = new ProductVO();
                vo.setNum(rs.getInt("num"));
                vo.setPname(rs.getString("pname"));
                vo.setModel(rs.getString("model"));
                vo.setPrice(rs.getInt("price"));
                vo.setCount(rs.getInt("count"));
                vo.setUser_id(rs.getString("user_id"));
                list.add(vo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


    @Override
    public List<ProductVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);
        List<ProductVO> vos = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "";

            if (searchKey.equals("pname")) {
                sql = "select * from product where pname like ? order by num desc";
            }
            else if(searchKey.equals("model")) {
                sql = "select * from product where model like ? order by num desc";
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            rs = pstmt.executeQuery();//DQL-select

            while(rs.next()){
                ProductVO vo = new ProductVO();
                vo.setNum(rs.getInt("num"));
                vo.setPname(rs.getString("pname"));
                vo.setModel(rs.getString("model"));
                vo.setPrice(rs.getInt("price"));
                vo.setCount(rs.getInt("count"));
                vo.setUser_id(rs.getString("user_id"));
                vos.add(vo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return vos;
    }
}

