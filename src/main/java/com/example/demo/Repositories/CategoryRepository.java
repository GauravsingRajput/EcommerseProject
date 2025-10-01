package com.example.demo.Repositories;

import com.example.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    //for adding the data first is to make a repository extend with jpa repository with entity
    //second is autowired with service implementation
}
