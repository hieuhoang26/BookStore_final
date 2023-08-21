package com.bookstore.common.security.service;


import com.bookstore.common.entity.Role;
import com.bookstore.common.entity.User;

import com.bookstore.common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            Optional<User> user = userRepository.findByEmail(email);
//            List<Role> roles = userRepository.findRolesByEmail(email);
//            if (user == null) throw new UsernameNotFoundException("User name not found");
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//            roles.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getRoleName())));
            return new org.springframework.security.core.userdetails
                    .User(user.get().getEmail(), user.get().getPassword(),authorities);
    }
}
