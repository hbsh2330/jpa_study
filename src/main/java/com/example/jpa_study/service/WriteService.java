package com.example.jpa_study.service;

import com.example.jpa_study.dto.WriteDto;
import com.example.jpa_study.entity.User;
import com.example.jpa_study.entity.Write;
import com.example.jpa_study.repository.WriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WriteService {
    @Autowired
    WriteRepository writeRepository;
    public void write(WriteDto writeDto, User user) {

           Write write = Write.builder()
                   .title(writeDto.getTitle())
                   .content(writeDto.getContent())
                   .regDate(LocalDateTime.now())
                   .user(user)
                   .build();
        writeRepository.save(write);
    }

    public List<Write> findWriteList(User user) {
        return writeRepository.findAllByUserId(user.getId());
    }
}
