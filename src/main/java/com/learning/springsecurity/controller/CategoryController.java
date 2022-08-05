package com.learning.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.springsecurity.model.User;
import com.learning.springsecurity.repository.UserRepo;


@Controller 
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    UserRepo categoryRepoImpl;

    @RequestMapping("/list")
    public String getCategoryList(Model m) {
        Iterable<User> iterator = categoryRepoImpl.findAll();
       
        List<User> lst =  new ArrayList<>();
        iterator.forEach(e->lst.add(e));

        m.addAttribute("categoryList", lst);
        // name of view 
        return "categoryList";
    }
}