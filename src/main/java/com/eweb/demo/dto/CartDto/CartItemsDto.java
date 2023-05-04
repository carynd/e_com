package com.eweb.demo.dto.CartDto;

import com.eweb.demo.dto.ProductDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartItemsDto {
    private Integer id;
    private @NotNull Integer quantity;
    private ProductDto productDto;
}
