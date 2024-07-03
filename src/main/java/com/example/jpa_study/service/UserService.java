package com.example.jpa_study.service;

import com.example.jpa_study.dto.UserDto;
import com.example.jpa_study.entity.User;
import com.example.jpa_study.repository.UserRepositoy;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepositoy userRepositoy;

    public void join(UserDto userDto) {
        User user = userDto.toEntity();
        userRepositoy.save(user);
    }

    public boolean login(String id, String password, HttpSession session) {
        Optional<User> userOptional = userRepositoy.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String Db_id = user.getId();
            String Db_password = user.getPassword();
            if (id.equals(Db_id) && password.equals(Db_password)) {
                session.setAttribute("userId", id);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
