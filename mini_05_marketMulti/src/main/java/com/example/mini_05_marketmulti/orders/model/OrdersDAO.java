package com.example.mini_05_marketmulti.orders.model;

import java.util.List;

public interface OrdersDAO {
    public int insert(OrdersVO vo);
    public int delete(OrdersVO vo);
    public OrdersVO selectOne(OrdersVO vo);
    public List<OrdersVO> selectAll();
}