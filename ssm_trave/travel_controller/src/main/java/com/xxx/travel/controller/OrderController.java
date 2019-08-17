package com.xxx.travel.controller;

import com.github.pagehelper.PageInfo;
import com.xxx.travel.domain.Order;
import com.xxx.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

//    @RequestMapping("/findAllOrders")
//    public ModelAndView findAllOrders(ModelAndView mv)throws Exception   {
//        List<Order> orders = orderService.findAllOrders();
//        mv.addObject("ordersList",orders);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    @RequestMapping("/findAllOrders")
    public ModelAndView findAllOrders(ModelAndView mv,
                                      @RequestParam(name = "page",defaultValue = "1") Integer page,
                                      @RequestParam(name = "size",defaultValue = "4") Integer size)throws Exception   {
        System.out.println(size);
        List<Order> orders = orderService.findAllOrders(page,size);
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findOrderDetail")
    public ModelAndView findOrderDetail(@RequestParam(name = "id", required = true)String orderId)throws Exception   {
        ModelAndView mv = new ModelAndView();
        Order orderDetail = orderService.findOrderDetail(orderId);
        mv.setViewName("orders-show");
        mv.addObject("orders",orderDetail);
        return mv;
    }

}
