package com.example.productservicettsevening.controller;

import com.example.productservicettsevening.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping()
    public String getAllCategories(){
        return "Getting All category";
    }

    @GetMapping("/{categoryId}")
    public String getProductsInCategory(@PathVariable ("categoryId")Long categoryId){
        return "Getting Product In Category";
    }
}
