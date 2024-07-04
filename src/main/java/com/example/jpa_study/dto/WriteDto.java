package com.example.jpa_study.dto;

import com.example.jpa_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class WriteDto {
    private String title;
    private String content;
    private LocalDateTime regDate;
    private User userId;
}
