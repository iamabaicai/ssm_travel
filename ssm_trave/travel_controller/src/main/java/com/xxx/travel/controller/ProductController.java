package com.xxx.travel.controller;

import com.xxx.travel.domain.Product;
import com.xxx.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAllPros")
    public ModelAndView findAllPros(ModelAndView mv) throws Exception {
        List<Product> products = productService.findAllProducts();
        mv.setViewName("product-list");
        mv.addObject("productList", products);
        return mv;
    }

    @RequestMapping("/addPro")
    public String addProduct(Product product) throws Exception{
        productService.addProduct(product);
        //添加完成重定向到产品列表
        return "redirect:/product/findAllPros";
    }
}
