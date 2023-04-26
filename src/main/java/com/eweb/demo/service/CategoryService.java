package com.eweb.demo.service;

import com.eweb.demo.model.Category;
import com.eweb.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void saveCategory(Category category){
        categoryRepo.save(category);
    }

    public List<Category> listCategory() {
        return categoryRepo.findAll();
    }

    public Category updateCategory(int categoryId, Category category) {
        boolean avail=categoryRepo.findById(categoryId).isPresent();
        if(avail){
            Category cat=categoryRepo.findById(categoryId).get();
            cat.setCategoryName(category.getCategoryName());
            cat.setDescription(category.getDescription());
            cat.setUrl(category.getUrl());
            categoryRepo.save(cat);
            return cat;
        }
//        else {
//            return categoryRepo.save(category);
//        }
//        for checking failing condition (when no id of give id no exists)
        return null;
    }

    public boolean isThere(int categoryId) {
         return categoryRepo.findById(categoryId).isPresent();
    }
}
