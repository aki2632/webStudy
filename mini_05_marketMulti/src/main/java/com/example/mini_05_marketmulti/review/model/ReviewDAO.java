package com.example.mini_05_marketmulti.review.model;

import java.util.List;

public interface ReviewDAO {

    public int insert(ReviewVO vo);
    public int update(ReviewVO vo);
    public int delete(ReviewVO vo);
    public ReviewVO selectOne(ReviewVO vo);
    public List<ReviewVO> selectAll(int pnum);
    public List<ReviewVO>  searchList(String searchKey, String searchWord, int pnum);

}
