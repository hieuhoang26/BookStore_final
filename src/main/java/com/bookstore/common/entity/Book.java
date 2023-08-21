package com.bookstore.common.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Integer bookId;

    @NotBlank
    @Size(min = 5, max = 255)
    @Column(name = "TITLE", nullable = false)
    private String title;

    @NotNull
    @PositiveOrZero
    //@Digits(integer = 10, fraction = 3)
    @Column(name = "PRICE", nullable = false)
    private Double price;

    @NotNull
    @Column(name = "CURRENT_QUANTITY", nullable = false)
    private Integer currentQuantity;

    @NotNull
    @Column(name = "SOLD_QUANTITY", nullable = false)
    private Integer soldQuantity;

//    (1-n) iamge
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private Set<BookImage> images;

    //    (1-1)Book details
    @OneToOne
    @JoinColumn(name = "BOOK_DETAILS_ID", referencedColumnName = "BOOK_DETAILS_ID")
    private BookDetails bookDetails;

    //    (n-1) shop
    @ManyToOne
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "SHOP_ID")
    private Shop shop;

    //    (n-n) Category
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BOOK_CATEGORY" ,
            joinColumns = {@JoinColumn(referencedColumnName = "BOOK_ID")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "CATEGORY_ID")})
    private Set<Category> categories;

    //    (n-n) Author
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BOOK_AUTHOR" ,
            joinColumns = {@JoinColumn(referencedColumnName = "BOOK_ID")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "AUTHOR_ID")})
    private Set<Author> authors;


    // Constructors, getters, setters, and other methods...
}
