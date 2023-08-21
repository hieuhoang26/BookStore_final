package com.bookstore.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "ORDER_ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Integer orderItemId;

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @NotBlank
    @Column(name = "QUANTITY")
    private Integer quantity;




}
