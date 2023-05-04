package com.eweb.demo.service;

import com.eweb.demo.dto.CartDto.AddToCartDto;
import com.eweb.demo.dto.CartDto.CartDto;
import com.eweb.demo.dto.CartDto.CartItemsDto;
import com.eweb.demo.dto.ProductDto;
import com.eweb.demo.exceptions.CustomException;
import com.eweb.demo.model.Cart;
import com.eweb.demo.model.Product;
import com.eweb.demo.model.User;
import com.eweb.demo.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    AuthenticationTokenService authenticationTokenService;

    @Autowired
    ProductService productService;
    public void addToCart(AddToCartDto addToCartDto, String token) {

        authenticationTokenService.authenticate(token);//null check
        User user=authenticationTokenService.getUserFromToken(token);//find the user using the token

        Optional<Product> product = productService.getProduct(addToCartDto.getProductId());
        Cart cart=new Cart(addToCartDto.getQuantity(), user,product.get());
        cartRepo.save(cart);
    }

    public CartDto getCartItems(String token) {
        authenticationTokenService.authenticate(token);//null check
        User user=authenticationTokenService.getUserFromToken(token);//find the user using the token

        CartDto cartDto = new CartDto();
        List<CartItemsDto> cartItems=new ArrayList<>();
        List<Cart> cartList=cartRepo.findAllByUserOrderByCreatedDateDesc(user);
        double total=0;
        for(Cart cart : cartList){
            ProductDto productDto=productService.convertToDroductDto(cart.getProduct());
            CartItemsDto cartItem=new CartItemsDto(cart.getId(),cart.getQuantity(),productDto);
            total+=(cart.getProduct().getPrice()*cart.getQuantity());
            cartItems.add(cartItem);
        }
        cartDto.setCartItems(cartItems);
        cartDto.setTotal(total);
        return cartDto;
    }

    public void deleteCartItem(String token, Integer cartItemId) {
        authenticationTokenService.authenticate(token);
        User user=authenticationTokenService.getUserFromToken(token);

        Optional<Cart> userCart=cartRepo.findById(cartItemId);
        if(ObjectUtils.isEmpty(userCart)){
           throw new CustomException("Cart item id doesn't exist");
        }
        Cart cart =userCart.get();
        if(cart.getUser()!=user){
            throw new CustomException("cart items are not of the user");
        }
        cartRepo.deleteById(cartItemId);
    }
}
