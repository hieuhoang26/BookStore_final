package com.bookstore.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Integer tagId;

    @NotBlank
    @Column(name = "CATEGORY_NAME",unique = true)
    private String tagName;

//    (n-n)Book
    @ManyToMany(mappedBy = "categories")
    private List<Book> book_tag;

}
