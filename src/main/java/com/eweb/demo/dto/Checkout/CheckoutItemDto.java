package com.eweb.demo.dto.Checkout;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutItemDto {
    private String productName;
    private double price;
    private int quantity;
    private int productId;
    private int userId;
}
