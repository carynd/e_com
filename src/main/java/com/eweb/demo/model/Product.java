package com.eweb.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private @NonNull String name;
    private @NonNull String imageUrl;
    private @NonNull String description;
    private @NonNull double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
