package com.xxx.travel.mapper;

import com.xxx.travel.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    //通过产品id查询产品信息
    @Select("select * from product where id=#{id}")
    public Product findOneProduct(String id) throws  Exception;

    //查看所有产品列表
    @Select("select * from product")
    public List<Product> findAllProducts() throws Exception;

    //添加产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void addProduct(Product product) throws  Exception;
}
