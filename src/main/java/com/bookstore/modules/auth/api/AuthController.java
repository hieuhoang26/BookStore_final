package com.bookstore.modules.auth.api;

import com.bookstore.common.entity.Role;
import com.bookstore.common.entity.User;
import com.bookstore.common.enums.RoleName;
import com.bookstore.common.exception.ApiExp;
import com.bookstore.common.repository.RoleRepository;
import com.bookstore.common.repository.UserRepository;
import com.bookstore.common.security.service.TokenAuthenticationService;
import com.bookstore.modules.auth.request.LoginRequest;
import com.bookstore.modules.auth.request.SignUpRequest;
import com.bookstore.modules.auth.response.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws IOException {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenAuthenticationService.generateToken(email);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
        String username = signUpRequest.getUsername().toLowerCase();
        String email = signUpRequest.getEmail().toLowerCase();
        String phoneNumber = signUpRequest.getPhoneNumber().toLowerCase();
        String password = passwordEncoder.encode(signUpRequest.getPassword());
        User user = new User(username,password,email,phoneNumber);

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByRoleName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if (role.equals("admin")) {
                    Role adminRole = roleRepository.findByRoleName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByRoleName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        User result = userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
