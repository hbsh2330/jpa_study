package com.example.jpa_study.controller;

import com.example.jpa_study.dto.WriteDto;
import com.example.jpa_study.entity.User;
import com.example.jpa_study.entity.Write;
import com.example.jpa_study.service.WriteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WriteController {
    @Autowired
    WriteService writeService;

    @GetMapping("/write")
    public String writePage(HttpSession session) {
        Object userId = session.getAttribute("user");
        if (userId != null){
            return "/write/writeForm";
        }else {
            return "/user/login";
        }
    }
    @PostMapping("/write")
    public String postWrite(WriteDto writeDto, HttpSession session){
        Object obj = session.getAttribute("user");
        User user = (User) obj;
        writeService.write(writeDto, user);
        return "/index";
    }
    @GetMapping("/writeList")
    public String getWriteSearchList(HttpSession session, Model model){
        Object obj = session.getAttribute("user");
        if (obj != null){
        User user = (User) obj;
        List<Write> writeList = writeService.findWriteList(user);
        model.addAttribute("writeList", writeList);
        return "/write/writeSearchList";
        }else {
            return "/user/login";
        }
    }
}
