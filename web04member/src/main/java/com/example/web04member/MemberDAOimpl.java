package com.example.web04member;

import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO{

    public MemberDAOimpl(){
        System.out.println("MemberDAOimpl()....");
    }

    @Override
    public int insert(MemberVO vo) {
        System.out.println("insert()....");
        System.out.println(vo);
        int flag = 0;


        return flag;
    }

    @Override
    public int update(MemberVO vo) {
        System.out.println("update()....");
        System.out.println(vo);
        int flag = 0;


        return flag;
    }

    @Override
    public int delete(MemberVO vo) {
        System.out.println("delete()....");
        System.out.println(vo);
        int flag = 0;


        return flag;
    }

    @Override
    public MemberVO selectOne(MemberVO vo) {
        System.out.println("selectOne()....");
        System.out.println(vo);
        MemberVO vo2 = new MemberVO();
        vo2.setNum(vo.getNum());
        vo2.setId("admin");
        vo2.setPw("hi1111");
        vo2.setName("kim");
        vo2.setTel("010");

        return vo2;
    }

    @Override
    public List<MemberVO> selectAll() {
        System.out.println("selectAll()....");

        List<MemberVO> list  = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MemberVO vo2 = new MemberVO();
            vo2.setNum(10+i);
            vo2.setId("admin11"+i);
            vo2.setPw("hi1111"+i);
            vo2.setName("kim11"+i);
            vo2.setTel("011"+i);
            list.add(vo2);
        }
        return list;
    }

    @Override
    public List<MemberVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()....");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<MemberVO> list  = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MemberVO vo2 = new MemberVO();
            vo2.setNum(10+i);
            vo2.setId("admin11"+i);
            vo2.setPw("hi1111"+i);
            vo2.setName("kim11"+i);
            vo2.setTel("011"+i);
            list.add(vo2);
        }
        return list;
    }
}
