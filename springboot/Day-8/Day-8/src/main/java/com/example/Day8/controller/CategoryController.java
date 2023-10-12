package com.example.Day8.controller;

import com.example.Day8.entity.Blog;
import com.example.Day8.entity.Category;
import com.example.Day8.repository.CategoryRepository;
import com.example.Day8.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String getCategoryPage(@RequestParam(required = false, defaultValue = "1") Integer page,
                                  @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                  Model model){
        Page<Category> pageData = categoryService.getAllCategory(page, pageSize);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "/admin/category/index";
    }
}
