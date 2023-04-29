package com.eweb.demo.service;

import com.eweb.demo.dto.ProductDto;
import com.eweb.demo.model.Category;
import com.eweb.demo.model.Product;
import com.eweb.demo.repository.CategoryRepo;
import com.eweb.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.UserTransaction;
import java.util.ArrayList;
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

    public List<ProductDto> listProducts() {
        List<Product> prdList=productRepo.findAll();
        List<ProductDto> prdDto = new ArrayList<>();
        for(int i=0;i< prdList.size();i++){
            prdDto.add(convertToDroductDto(prdList.get(i)));
        }
        return prdDto;
    }

    private ProductDto convertToDroductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }

    public Product updateProduct(Integer productId, ProductDto productDto) {
        boolean avail=productRepo.findById(productId).isPresent();
        if(avail){
            Product prd=productRepo.findById(productId).get();
            prd.setName(productDto.getName());
            prd.setDescription(productDto.getDescription());
            prd.setPrice(productDto.getPrice());
            prd.setImageUrl(productDto.getImageUrl());

            //can add to update the category id as well(but haven't added here)
//            Optional<Category> cat=categoryRepo.findById(productDto.getCategoryId());
//            if(cat.isPresent()) prd.setCategory(cat.get());

            productRepo.save(prd);
            return prd;
        }
        return null;
    }
}
