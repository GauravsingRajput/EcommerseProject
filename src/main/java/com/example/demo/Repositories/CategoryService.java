package com.example.demo.Repositories;

import com.example.demo.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCatagories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);


    String updateCategory(Category category, Long categoryId);
}
