package com.bookstore.common.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    @NotBlank
    @Size(min = 5, max = 30)
    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @NotBlank
//    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$")
    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;

    @NotBlank
    @Email
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotBlank
    @Size(min = 8)
    @Column(name = "PASSWORD", unique = true)
    private String password;



    //  (n-n)Role
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {@JoinColumn(referencedColumnName = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "ROLE_ID")})
    private Set<Role> roles;

    //   (1-n)Order
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orders;

    //    (1-1) shop
    @OneToOne
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "SHOP_ID")
    private Shop shop;



    public User(String userName, String phoneNumber, String email, String password) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
    public void setRoles(Set<Role> roles) {

        if (roles == null) {
            this.roles = null;
        } else {
            this.roles = Collections.unmodifiableSet(roles);
        }
    }
}
