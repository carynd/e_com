package com.eweb.demo.service;

import com.eweb.demo.dto.ProductDto;
import com.eweb.demo.model.Category;
import com.eweb.demo.model.Product;
import com.eweb.demo.repository.CategoryRepo;
import com.eweb.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.UserTransaction;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProductRepo productRepo;
    public boolean addProduct(ProductDto pDto) {
        Optional<Category> category=categoryRepo.findById(pDto.getCategoryId());
        if(!category.isPresent()){
           return false;
        }
        Product product = new Product();
//        product.setId(pDto.getId());
        product.setName(pDto.getName());
        product.setDescription(pDto.getDescription());
        product.setImageUrl(pDto.getImageUrl());
        product.setPrice(pDto.getPrice());
        product.setCategory(category.get());
        productRepo.save(product);
        return true;
    }

    public List<Product> listProducts() {
        return productRepo.findAll();
    }
}
