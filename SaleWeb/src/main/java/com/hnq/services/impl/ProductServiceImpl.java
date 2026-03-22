/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnq.services.impl;

import com.hnq.pojo.Product;
import com.hnq.repositories.ProductRepository;
import com.hnq.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository prodRepo;
    
    @Override
    public List<Product> getProducts(Map<String, String> params) {
       return this.prodRepo.getProducts(params);
    }
}
