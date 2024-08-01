package com.example.web03board;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements  BoardDAO{

    public BoardDAOimpl(){
        System.out.println("BoardDAOimpl().....");
    }


    @Override
    public int insert(BoardVO vo) {
        System.out.println("insert()....");
        System.out.println(vo);
        int flag = 0;

        return flag;
    }

    @Override
    public int update(BoardVO vo) {
        System.out.println("update()....");
        System.out.println(vo);
        int flag = 0;

        return flag;
    }

    @Override
    public int delete(BoardVO vo) {
        System.out.println("delete()....");
        System.out.println(vo);
        int flag = 0;

        return flag;
    }

    @Override
    public BoardVO selectOne(BoardVO vo) {
        System.out.println("selectOne()....");
        System.out.println(vo);

        BoardVO vo2 = new BoardVO();
        vo2.setNum(vo.getNum());
        vo2.setTitle("jsp...");
        vo2.setContent("servlet....");
        vo2.setWriter("admin1");
        vo2.setWdate(new Timestamp(System.currentTimeMillis()));

        return vo2;
    }

    @Override
    public List<BoardVO> selectAll() {
        System.out.println("selectAll()....");

        List<BoardVO> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            BoardVO vo2 = new BoardVO();
            vo2.setNum(10+i);
            vo2.setTitle("jsp..."+i);
            vo2.setContent("servlet...."+i);
            vo2.setWriter("admin"+i);
            vo2.setWdate(new Timestamp(System.currentTimeMillis()));
            list.add(vo2);
        }

        return list;
    }

    @Override
    public List<BoardVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()....");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<BoardVO> list = new ArrayList<>();
        for (int i = 10; i < 13; i++) {
            BoardVO vo2 = new BoardVO();
            vo2.setNum(10+i);
            vo2.setTitle("jsp..."+i);
            vo2.setContent("servlet...."+i);
            vo2.setWriter("admin"+i);
            vo2.setWdate(new Timestamp(System.currentTimeMillis()));
            list.add(vo2);
        }

        return list;
    }
}
