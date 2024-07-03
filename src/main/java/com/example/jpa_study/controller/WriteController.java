package com.example.jpa_study.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WriteController {
    @GetMapping("/write")
    public String writePage(HttpSession session) {
        Object userId = session.getAttribute("userId");
        if (userId != null){
            return "/write/writeForm";
        }else {
            return "/user/login";
        }
    }
}
