/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnq.controllers;

import com.hnq.services.CategoryService;
import com.hnq.services.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService cateServ;
    @Autowired
    private ProductService prodServ;
    @RequestMapping("/")
    public String index(Model model,@RequestParam Map<String, String> params){
        model.addAttribute("categories", this.cateServ.getCates());
        model.addAttribute("products", this.prodServ.getProducts(params));
        return "index";
    }
}
