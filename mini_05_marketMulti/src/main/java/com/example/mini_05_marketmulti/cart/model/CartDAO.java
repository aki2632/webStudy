package com.example.mini_05_marketmulti.cart.model;

import java.util.List;

public interface CartDAO {
    public int insert(CartVO vo);
    public int update(CartVO vo);
    public int delete(CartVO vo);
    public CartVO selectOne(CartVO vo);
    public List<CartVO> selectAll();
    public List<CartVO> selectByMember(int mnum);  // 새로운 메서드 추가
}