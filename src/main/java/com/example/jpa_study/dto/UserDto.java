package com.example.jpa_study.dto;

import com.example.jpa_study.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDto {
    private String id;
    private String password;
    private String name;
    private String phone;
    private String zipcode;
    private String addr;
    private String detailAddr;
    private String email;

    @Builder
    public UserDto(String id, String password, String name, String phone, String zipcode, String addr, String detailAddr, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.zipcode = zipcode;
        this.addr = addr;
        this.detailAddr = detailAddr;
        this.email = email;
    }

    //Dto를 Entity로 변환시키는 로직
    public User toEntity(){
        return User.builder()
                .id(id)
                .password(password)
                .name(name)
                .phone(phone)
                .zipcode(zipcode)
                .addr(addr)
                .detailAddr(detailAddr)
                .email(email)
                .build();
    }
    //Entity를 Dto로 변환시키는 로직
    public UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .zipcode(user.getZipcode())
                .addr(user.getAddr())
                .detailAddr(user.getDetailAddr())
                .email(user.getEmail())
                .build();
    }
}
