package com.bookstore;

import com.bookstore.common.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.bookstore.common.entity.User;


@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

//    @Component
//    class runner implements CommandLineRunner{
//        private PasswordEncoder passwordEncoder;
//        private UserRepository userRepository;
//
//        runner(PasswordEncoder passwordEncoder, UserRepository userRepository) {
//            this.passwordEncoder = passwordEncoder;
//            this.userRepository = userRepository;
//        }
//
//        @Override
//        public void run(String... args) throws Exception {
//            User user = new User("hieuok", "1234567890", "mail@gmail.com", passwordEncoder.encode("12345678"));
//            userRepository.save(user);
//        }
//    }
}
