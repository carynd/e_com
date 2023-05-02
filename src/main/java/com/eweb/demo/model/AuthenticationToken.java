package com.eweb.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="created_at")
    private Date createdDate;

    private String token;

    @OneToOne
    @JoinColumn(name="user_id")
    User user;

    public AuthenticationToken(User user) {
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
        this.user = user;
    }
}
