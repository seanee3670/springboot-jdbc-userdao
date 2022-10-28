package com.example.demo.controller;

import com.example.demo.UserDto.UserResDto;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResDto> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(UserResDto.form(userDao.findById(id)));
    }

    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}
