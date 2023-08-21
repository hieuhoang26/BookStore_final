package com.bookstore.common.repository;

import com.bookstore.common.entity.Role;
import com.bookstore.common.entity.User;
import com.bookstore.common.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRoleName(RoleName name);
}
