package com.bookstore.common.entity;

import com.bookstore.common.enums.RoleName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer roleId;

    @NotBlank
    @Column(name = "ROLE_NAME")
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

//    (n-n) user
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
