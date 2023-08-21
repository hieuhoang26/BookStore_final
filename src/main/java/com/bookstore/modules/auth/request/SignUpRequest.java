package com.bookstore.modules.auth.request;

import com.bookstore.common.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    String username;
    String password;
    String email;
    String  phoneNumber;

    private Set<String> role;


}

