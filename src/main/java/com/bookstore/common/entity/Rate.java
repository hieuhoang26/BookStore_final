package com.bookstore.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "RATE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Integer  reviewId;

    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID",referencedColumnName = "USER_ID")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
    private Book book;

    @Column(name = "RATING")
    private String rating;
}
