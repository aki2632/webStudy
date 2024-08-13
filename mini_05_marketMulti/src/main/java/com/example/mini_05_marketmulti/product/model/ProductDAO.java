package com.example.mini_05_marketmulti.product.model;

import java.util.List;

public interface ProductDAO {
    public int insert(ProductVO vo);
    public int update(ProductVO vo);
    public int delete(ProductVO vo);
    public ProductVO selectOne(ProductVO vo);
    public List<ProductVO> selectAll();
    public List<ProductVO> searchList(String searchKey, String searchWord);
}
