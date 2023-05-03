package com.eweb.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private @NonNull String name;
    private @NonNull String imageUrl;
    private @NonNull String description;
    private @NonNull double price;

    private @NonNull Integer categoryId;

    public ProductDto(@NonNull String name, @NonNull String imageUrl, @NonNull String description, @NonNull double price, @NonNull Integer categoryId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }
}
