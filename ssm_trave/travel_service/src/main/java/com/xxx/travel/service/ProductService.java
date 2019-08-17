package com.xxx.travel.service;

import com.xxx.travel.domain.Product;

import java.util.List;

public interface ProductService {
  public List<Product> findAllProducts() throws Exception;

  public void addProduct(Product product) throws  Exception;
}
