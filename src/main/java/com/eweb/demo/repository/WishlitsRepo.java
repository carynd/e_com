package com.eweb.demo.repository;

import com.eweb.demo.model.Product;
import com.eweb.demo.model.User;
import com.eweb.demo.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlitsRepo extends JpaRepository<Wishlist,Integer> {

    List<Wishlist> findAllByUserOrderByCreatedDateDesc(User user);

    Wishlist findByUserAndProduct(User user, Optional<Product> product);
}
