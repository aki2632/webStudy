package com.example.web07total.member.model;

import java.util.List;

public interface MemberDAO {

    public int insert(MemberVO vo);
    public int update(MemberVO vo);
    public int delete(MemberVO vo);
    public MemberVO selectOne(MemberVO vo);
    public List<MemberVO> selectAll();
    public List<MemberVO> searchList(String searchKey, String searchWord);
    public MemberVO login(String id, String pw);
}
