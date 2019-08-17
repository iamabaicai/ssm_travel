package com.xxx.travel.mapper;

import com.xxx.travel.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerMapper {

    @Select("select * from traveller where id in " +
            "(select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findTravellerById(String ordersId);
}
