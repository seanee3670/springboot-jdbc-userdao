package com.example.demo.UserDto;

import com.example.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResDto {
    private String id;
    private String name;

    public static UserResDto form(User user) {
        return new UserResDto(user.getId(), user.getName());
    }
}