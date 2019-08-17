package com.xxx.travel.mapper;



import com.xxx.travel.domain.Member;
import com.xxx.travel.domain.Order;
import com.xxx.travel.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersMapper {

    //查询所有订单
    @Select("select * from orders")
    @Results({
            @Result( id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",
                    column = "productId",
                    one = @One(select = "com.xxx.travel.mapper.ProductMapper.findOneProduct")),
    })
    public List<Order> findAllOrders();

    //查询订单详情，包含产品、会员、旅客信息
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result( id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.xxx.travel.mapper.ProductMapper.findOneProduct")),
            @Result(property = "member" ,column = "memberId",
                    javaType = Member.class,
                    one = @One(select = "com.xxx.travel.mapper.MemberMapper.findMemberById")),
            @Result(property = "travellers",column ="id" ,
                    javaType =java.util.List.class,
                    many = @Many(select = "com.xxx.travel.mapper.TravellerMapper.findTravellerById"))
    })
    public Order  findOrderById(String orderId) throws Exception;
}
