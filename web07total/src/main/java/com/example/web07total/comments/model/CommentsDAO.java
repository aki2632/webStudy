package com.example.web07total.comments.model;

import java.util.List;

public interface CommentsDAO {

    public int insert(CommentsVO vo);
    public int update(CommentsVO vo);
    public int delete(CommentsVO vo);
    public CommentsVO selectOne(CommentsVO vo);
    public List<CommentsVO> selectAll(int bnum);
    public List<CommentsVO>  searchList(String searchKey,String searchWord,int bnum);

}
