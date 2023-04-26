package com.eweb.demo.controller;

import com.eweb.demo.common.ApiResponse;
import com.eweb.demo.model.Category;
import com.eweb.demo.service.CategoryService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return new ResponseEntity<>(new ApiResponse(true,"created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> listCategory(){
        return categoryService.listCategory();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@RequestBody Category category,@PathVariable int categoryId){
        Category cat=categoryService.updateCategory(categoryId,category);
        if(cat!=null){
            return new ResponseEntity<>(new ApiResponse(true,"updated successfully"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false,"no id found"), HttpStatus.NOT_FOUND);

    }
}
