package com.xxx.travel.service;

import com.xxx.travel.domain.Order;

import java.util.List;

public interface OrderService {


    public List<Order> findAllOrders(int page,int size) throws Exception;

    //通过订单id查看订单详细信息
    public Order findOrderDetail(String orderId) throws Exception;
}
