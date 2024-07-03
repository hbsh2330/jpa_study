package com.example.jpa_study.controller;

import com.example.jpa_study.dto.UserDto;
import com.example.jpa_study.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/join")
    public String getJoin(){
        log.info("get join");
        return "/user/join";
    }

    @PostMapping("/join")
    public String postJoin(UserDto userDto){
        log.info("post join");
        userService.join(userDto);
        return "/index";
    }

    @GetMapping("/login")
    public String getLogin(){
        log.info("get Login");
        return "/user/login";
    }
    @PostMapping("/login")
    public String postLogin(@RequestParam String id, @RequestParam String password, HttpSession session, Model model){
        log.info("post login");
        boolean login = userService.login(id, password, session);
        if (login) {
            return "/index";
        }else {
            model.addAttribute("req", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "/user/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userId"); // 세션에서 사용자 ID 제거
        return "redirect:/login"; // 로그아웃 후 로그인 페이지로 리다이렉트
    }
}
