package com.example.jpa_study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WriteRepositoryTest {
    @Autowired
    WriteRepository writeRepository;
    @Test
    public void test() {
        System.out.println(writeRepository.findAllByUserId("hbsh2330"));
    }
}