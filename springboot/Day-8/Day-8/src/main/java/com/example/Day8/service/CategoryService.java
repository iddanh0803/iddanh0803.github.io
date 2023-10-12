package com.example.Day8.service;

import com.example.Day8.entity.Blog;
import com.example.Day8.entity.Category;
import com.example.Day8.repository.CategoryRepository;
import com.example.Day8.request.UpsertCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category createCategory(UpsertCategoryRequest request ) {

        List<Category> categoryList = categoryRepository.findAll();
        String newName = request.getName();
        for (int i = 0; i < categoryList.size(); i++) {
            if (newName.equals(categoryList.get(i).getName()) ){
                throw new RuntimeException("danh mục đã tồn tại.");
            }
        }
        Category category = new Category();
        category.setName(newName);
        return category;
    }

    public Category updateCategory(UpsertCategoryRequest request, Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Not found category"));
        List<Category> categoryList = categoryRepository.findAll();
        for (int i = 0; i < categoryList.size(); i++) {
            if (request.getName().equals(categoryList.get(i).getName()) ){
                throw new RuntimeException("danh mục đã tồn tại.");
            }
        }
        category.setName(request.getName());
        return category;
    }

    public void deletCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not found category"));
        if (!category.getBlogs().isEmpty()){
            throw new RuntimeException("Category không được xóa");
        }else categoryRepository.delete(category);
    }

    public Page<Category> getAllCategory(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return categoryRepository.findAll(pageable);
    }
}
