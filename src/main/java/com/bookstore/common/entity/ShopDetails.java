package com.bookstore.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "SHOP_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOP_DETAILS_ID")
    private Integer shopDetailsID;


    @Column(name = "OPERATING_HOURS")
    private Time operatingHours;

    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "SHIPPING_POLICY")
    private String shippingPolicy;
    @Column(name = "RETURN_POLICY")
    private String returnPolicy;


    //  (1-1)Shop
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "shopDetails")
    private Shop shop;

}
