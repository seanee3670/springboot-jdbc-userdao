package com.example.demo.controller;

import com.example.demo.dao.HospitalDao;
import com.example.demo.domain.Hospital;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalDao hospitalDao;


    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> get(@PathVariable String id) {
        Hospital hospital = hospitalDao.findById(id);
        Optional<Hospital> opt = Optional.of(hospital);
        if (!opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(hospital);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }
    }


//    @PostMapping("/")
//    public ResponseEntity<Hospital> create(@ResponseBody Hospital hospital) {
//
//    }
}
