package com.example.mini_05_marketmulti.wish.model;

import java.util.List;

public interface WishDAO {
    public int insert(WishVO vo);
    public int delete(WishVO vo);
    public WishVO selectOne(WishVO vo);
    public List<WishVO> selectAll();
}