package com.eweb.demo.controller;

import com.eweb.demo.common.ApiResponse;
import com.eweb.demo.dto.ProductDto;
import com.eweb.demo.model.Category;
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
    public ResponseEntity<List<ProductDto>> listProducts(){
        return new ResponseEntity<>(productService.listProducts(),HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId,@RequestBody ProductDto productDto){
        Product prd=productService.updateProduct(productId,productDto);
        if(prd!=null){
            return new ResponseEntity<>(new ApiResponse(true,"updated successfully"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false,"no id found"), HttpStatus.NOT_FOUND);

    }
}
