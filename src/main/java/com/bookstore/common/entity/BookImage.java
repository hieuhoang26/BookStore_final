package com.bookstore.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK_IMAGE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_IMAGE_ID")
    private Integer bookImageId;

    @Column(name = "IMAGE",unique = true)
    private String image;

//    (n-1) book
    @ManyToOne
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
    private Book book;
}
