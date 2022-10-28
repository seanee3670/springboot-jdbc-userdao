package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class User {
    private String id;
    private String name;
    private String password;

}
