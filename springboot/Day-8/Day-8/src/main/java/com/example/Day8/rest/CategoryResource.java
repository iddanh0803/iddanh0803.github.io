package com.example.Day8.rest;

import com.example.Day8.entity.Category;
import com.example.Day8.repository.CategoryRepository;
import com.example.Day8.request.UpsertCategoryRequest;
import com.example.Day8.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/categories")
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody UpsertCategoryRequest request ){
        return new ResponseEntity<>( categoryService.createCategory(request), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody UpsertCategoryRequest request, @PathVariable Integer id){
        return ResponseEntity.ok(categoryService.updateCategory(request,id));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.deletCategory(id);
    }
}
