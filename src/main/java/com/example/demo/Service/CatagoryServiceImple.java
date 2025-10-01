package com.example.demo.Service;

import com.example.demo.Model.Category;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CatagoryServiceImple implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //private List<Category>categories=new ArrayList<>();
  //  private  Long nextId=1L;

    @Override
    public List<Category> getAllCatagories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryId(nextId++);
       Category category1=categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        List<Category> categories=categoryRepository.findAll();
//        Category category=categories.stream().filter(c->c.getCategoryId().
//                equals(categoryId)).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
//       // categories.remove(category);
       categoryRepository.delete(category);
        return "Category with category id : "+categoryId+" has been deleted";

    }

    @Override
    public String updateCategory(Category category, Long categoryId) {
        Optional<Category>savedCategoryOptional=categoryRepository.findById(categoryId);
        Category savedCategory=savedCategoryOptional.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));
        category.setCategoryId(categoryId);
        savedCategory=categoryRepository.save(category);
        return savedCategory.toString();


//        Optional<Category>optionalCategory=categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst();
//        if(optionalCategory.isPresent()){
//            Category existingCategory=optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedCategory=categoryRepository.save(existingCategory);
//            return  existingCategory.toString();
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Update Category not found");
//        }
    }
}
