package com.xxx.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxx.travel.domain.Order;
import com.xxx.travel.mapper.OrdersMapper;
import com.xxx.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Order> findAllOrders(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        List<Order> orders = ordersMapper.findAllOrders();
        return orders;
    }

    @Override
    public Order findOrderDetail(String orderId) throws Exception {
        Order order = ordersMapper.findOrderById(orderId);
        return order;
    }


}
