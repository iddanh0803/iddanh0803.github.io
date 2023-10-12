package com.example.Day8.controller;

import com.example.Day8.entity.Blog;
import com.example.Day8.entity.Category;
import com.example.Day8.service.BlogService;
import com.example.Day8.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {
    private final BlogService blogService;
    private final CategoryService categoryService;
    @GetMapping("/")
    public String getHome(Model model) {
        Page<Blog> pageData = blogService.findAll(1, 10);
        model.addAttribute("currentPage", 1);
        model.addAttribute("pageData", pageData);
        return "web/main";
    }

    @GetMapping("/page/{pageNumber}")
    public String getPage(Model model, @PathVariable Integer pageNumber) {
        Page<Blog> pageData = blogService.findAll(pageNumber, 10);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("pageData", pageData);
        return "web/page";
    }

    @GetMapping("search")
    public List<Blog> searchBlog(String title) {
        return blogService.searchByTitle(title);
    }

    @GetMapping("categories")
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @GetMapping("categories/{categoryName}")
    public List<Blog> getBlogsOfCategory(String category) {
        return blogService.findByCategoryName(category);
    }

    @GetMapping("blogs/{blogId}/{blogSlug}")
    public Blog getBlogDetail(Integer id) {
        return blogService.getBlogById(id);
    }

}
