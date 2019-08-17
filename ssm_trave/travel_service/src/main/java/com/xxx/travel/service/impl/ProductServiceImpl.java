package com.xxx.travel.service.impl;

import com.xxx.travel.domain.Product;
import com.xxx.travel.mapper.ProductMapper;
import com.xxx.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAllProducts() throws Exception {
        return productMapper.findAllProducts();
    }

    @Override
    public void addProduct(Product product) throws Exception {
        productMapper.addProduct(product);
    }
}
