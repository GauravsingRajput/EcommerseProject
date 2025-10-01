package com.example.demo.Service;

import com.example.demo.Model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCatagories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);


    String updateCategory(Category category, Long categoryId);
}
