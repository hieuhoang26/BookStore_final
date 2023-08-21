package com.bookstore.common.repository;

import com.bookstore.common.entity.Role;
import com.bookstore.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String Email);
    @Query("SELECT u.roles FROM User u WHERE u.email = :email")
    List<Role> findRolesByEmail(String email);
}
