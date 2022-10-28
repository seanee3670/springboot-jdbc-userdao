package com.example.demo.UserDto;

import com.example.demo.domain.User;
import lombok.Getter;

@Getter
public class UserReqDto {
    private String id;
    private String name;
    private String password;

    public User toEntity() {
        return new User(id, name, password);
    }
}
