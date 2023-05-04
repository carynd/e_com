package com.eweb.demo.controller;

import com.eweb.demo.common.ApiResponse;
import com.eweb.demo.dto.CartDto.AddToCartDto;
import com.eweb.demo.dto.CartDto.CartDto;
import com.eweb.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token){
        cartService.addToCart(addToCartDto,token);
        return new ResponseEntity<>(new ApiResponse(true,"added to cart"), HttpStatus.CREATED);
    }

    @GetMapping("/{token}")
    public ResponseEntity<CartDto> getCartItems(@PathVariable("token") String token){
        CartDto cartDto=cartService.getCartItems(token);
        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@RequestParam("token") String token,@PathVariable("cartItemId") Integer cartItemId){
        cartService.deleteCartItem(token,cartItemId);
        return new ResponseEntity<>(new ApiResponse(true,"deleted from cart"),HttpStatus.OK);
    }
}
