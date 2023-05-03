package com.eweb.demo.service;

import com.eweb.demo.common.ApiResponse;
import com.eweb.demo.dto.ProductDto;
import com.eweb.demo.exceptions.AuthenticationFailed;
import com.eweb.demo.exceptions.CustomException;
import com.eweb.demo.model.Product;
import com.eweb.demo.model.User;
import com.eweb.demo.model.Wishlist;
import com.eweb.demo.repository.ProductRepo;
import com.eweb.demo.repository.WishlitsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WishlistService {
    @Autowired
    WishlitsRepo wishlitsRepo;
    @Autowired
    AuthenticationTokenService authenticationTokenService;
    @Autowired
    ProductService productService;
    //instead of product it can be product id, easier to use wth prioduct
    public ResponseEntity<ApiResponse> addToWishlist(Integer productId, String token) throws AuthenticationFailed, CustomException {
        authenticationTokenService.authenticate(token);//null check
        User user=authenticationTokenService.getUserFromToken(token);//find the user using the token
        Optional<Product> product=productService.getProduct(productId);

        //check if product already exists for that user accordingly add
        Wishlist list = wishlitsRepo.findByUserAndProduct(user, Optional.of(product.get()));
        if(Objects.isNull(list)){
            Wishlist wishlist=new Wishlist(user,product.get());
            wishlitsRepo.save(wishlist);
            return new ResponseEntity<>(new ApiResponse(true,"Added product to wishist"), HttpStatus.CREATED);
        }

       return new ResponseEntity<>(new ApiResponse(false,"Product already added"),HttpStatus.BAD_REQUEST);
    }

    public List<ProductDto> getWishlist(String token) {
        authenticationTokenService.authenticate(token);//null check
        User user=authenticationTokenService.getUserFromToken(token);
        final List<Wishlist> list=wishlitsRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDto> ans=new ArrayList<>();
        for(Wishlist wishlist : list){
            ans.add(productService.convertToDroductDto(wishlist.getProduct()));
        }
        return ans;
    }
}
