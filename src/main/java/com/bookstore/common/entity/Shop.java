package com.bookstore.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "SHOP")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOP_ID")
    private Integer shopId;

    @NotBlank
    @Column(name = "SHOP_NAME")
    private String shopName;

    @Column(name = "SHOP_LOGO")
    private String shopLogo;

    @Column(name = "SHOP_ADDRESS")
    private String shopAddress;

    @Email
    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;

    @Column(name = "CONTACT_PHONE")
    private String contactPhone;


    //    (1-1)shop details
    @OneToOne
    @JoinColumn(name = "SHOP_DETAILS_ID", referencedColumnName = "SHOP_DETAILS_ID")
    private ShopDetails shopDetails;

    //    (1-1) user
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "shop")
    private User user;

    //    (1-n) Book
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private List<Book> books;

    //    (1-n) Order
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private List<Order> orders;
}
