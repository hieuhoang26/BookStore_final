package com.bookstore.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;


    @NotNull
    @PositiveOrZero
    //@Digits(integer = 10, fraction = 3)
    @Column(name = "TOTAL_PRICE", nullable = false)
    private Double totalPrice;

    @NotNull
    @Column(name = "ORDER_DATTE", nullable = false)
    private LocalDate orderDate;

    @NotBlank
    @Column(name = "SHOPPING_ADDRESS", nullable = false)
    private String shoppingAddress;
    @NotBlank
    @Column(name = "ORDER_STATUS", nullable = false)
    private String orderStatus;

    //    (n-1) user
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "USER_ID")
    private User user;
    //    (n-1) Shop
    @ManyToOne
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "SHOP_ID")
    private Shop shop;

}
