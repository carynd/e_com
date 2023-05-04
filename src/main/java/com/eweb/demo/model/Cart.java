package com.eweb.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="created_at")
    private LocalDateTime createdDate;

    private Integer quantity;

    @OneToOne
    @JoinColumn(name="user_id")
    User user;

    @ManyToOne
    @JoinColumn(name="product_id")
    Product product;

    public Cart(Integer quantity, User user, Product product) {
        this.quantity = quantity;
        this.user = user;
        this.product = product;
        this.createdDate = LocalDateTime.now();
    }
}
