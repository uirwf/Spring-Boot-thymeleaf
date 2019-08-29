package com.example.thymeleaf_demo.controller;

import com.example.thymeleaf_demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Product product;

    @RequestMapping("/test1")
    public String hello(Model model){
        model.addAttribute("name","thymeleaf");
        return "hello";
    }

    @RequestMapping("/test2")
    public String hello2(Model model){
        model.addAttribute("name","thymeleaf");
        return "hello2";
    }

    @RequestMapping("/test3")
    public String test(Model model){
        String htmlContent="<p style='color:red'> 红色文字</p>";
        boolean testBoolean = true;
        //Product product = new Product();
        product.setId(5);
        product.setName("Java核心技术卷I");
        product.setPrice(99);
        model.addAttribute("book",product);
        model.addAttribute("testBoolean",testBoolean);
        model.addAttribute("htmlContent",htmlContent);
        return "test";
    }

    @RequestMapping("/testEach")
    public String testEach(Model model){
        //String htmlContent="<p style='color:red'> 红色文字</p>";
        //boolean testBoolean = true;
        List<Product> productList = new ArrayList<>();

        product.setId(8);
        product.setName("Java核心技术卷I(英文版)");
        product.setPrice(99);

        productList.add(new Product(1,"伊藤润二恐怖漫画精选",33));
        productList.add(new Product(2,"白夜行",43));
        productList.add(new Product(3,"拉普拉斯的魔女",53));
        productList.add(new Product(4,"Java编程思想",63));
        productList.add(new Product(5,"Effective Java中文版",73));
        productList.add(new Product(6,"Java核心技术卷I",93));
        productList.add(new Product(7,"Java核心技术卷II",93));
        productList.add(product);

        model.addAttribute("productList",productList);
        //model.addAttribute("htmlContext",htmlContent);
        //model.addAttribute("testBoolean",testBoolean);
        model.addAttribute("book",product);
        return "test2";
    }
}
