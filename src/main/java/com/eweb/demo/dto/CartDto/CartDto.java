package com.eweb.demo.dto.CartDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private List<CartItemsDto> cartItems;
    private double total;
}
