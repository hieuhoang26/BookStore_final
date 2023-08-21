package com.bookstore.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "BOOK_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_DETAILS_ID")
    private Integer bookDetailsID;

    @NotBlank
    @Column(name = "PUBLISHER")
    private String publisher;
    @NotNull
    @Column(name = "PUBLICATION_DATE")
    private LocalDate publicationDate;

    @Column(name = "DIMENSIONS")
    private String dimensions;

    @Column(name = "COVER_TYPE")
    private String coverType;

    @Column(name = "NUMBER_PAGES")
    private Integer numberPages;

    @Column(name = "PUBLISHING_HOUSE")
    private String publishingHouse;

    @Column(name = "DESCRIPTION")
    private String description;


    //  (1-1)Book
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookDetails")
    private Book book;

}
