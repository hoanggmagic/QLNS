package com.qlns.qlns.Serevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlns.qlns.Mode.Users;
import com.qlns.qlns.Repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Users> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
