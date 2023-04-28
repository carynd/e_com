package com.eweb.demo.controller;

import com.eweb.demo.common.ApiResponse;
import com.eweb.demo.dto.ProductDto;
import com.eweb.demo.model.Product;
import com.eweb.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto pDto){
        boolean response=productService.addProduct(pDto);
        if(!response) return new ResponseEntity<>(new ApiResponse(response,"Category of product doesn't exist"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new ApiResponse(response,"Added product"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Product> listProducts(){
        return productService.listProducts();
    }
}
