package com.eweb.demo.controller;

import com.eweb.demo.common.ApiResponse;
import com.eweb.demo.dto.ProductDto;
import com.eweb.demo.model.Wishlist;
import com.eweb.demo.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    WishlistService wishlistService;

    //one to see wishlist items for user
    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishlist(@PathVariable("token") String token){
        List<ProductDto> productDtos=wishlistService.getWishlist(token);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }


    //another to add products to wishlist
    @PostMapping("/add/product/{productId}")
    public ResponseEntity<ApiResponse> addToWishlist(@PathVariable("productId") Integer productId, @RequestParam("token") String token){
        return wishlistService.addToWishlist(productId,token);
    }

}
