package com.eweb.demo.dto.CartDto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter

public class AddToCartDto {
    private Integer id;
    private @NonNull Integer productId;
    private @NonNull Integer quantity;
}
