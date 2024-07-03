package com.example.jpa_study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String password;
    private String name;
    private String phone;
    private String zipcode;
    private String addr;
    private String detailAddr;
    private String email;

    @Builder
    public User(String id, String password, String name, String phone, String zipcode, String addr, String detailAddr, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.zipcode = zipcode;
        this.addr = addr;
        this.detailAddr = detailAddr;
        this.email = email;
    }
}
