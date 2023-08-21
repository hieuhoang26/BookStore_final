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
@Table(name = "AUTHOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Integer authorId;

    @NotBlank
    @Size(min = 5, max = 50)
    @Column(name = "AUTHOR_NAME", unique = true)
    private String authorName;

    @NotBlank
    @Email
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotBlank

    @Column(name = "PHONE_NUMBER",unique = true)
    private String phoneNumber;

//  (n-n)Book
    @ManyToMany(mappedBy = "authors")
    private List<Book> book_author;
}
