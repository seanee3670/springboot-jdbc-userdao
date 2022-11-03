package com.example.demo;

import com.example.demo.dao.HospitalDao;
import com.example.demo.domain.Hospital;
import com.example.demo.parser.HospitalParser;
import com.example.demo.parser.ReadLineContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;
    @Autowired
    HospitalDao hospitalDao;

    @BeforeEach
    void beforeEach() {
        hospitalDao.deleteAll();
    }

    String testLine = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";


    @Test
    @DisplayName("Hospital insert() Test")
    void add() {
        hospitalDao.deleteAll();

        assertEquals(0, hospitalDao.getCount());
        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse(testLine);
        hospitalDao.add(hospital);
        assertEquals(1, hospitalDao.getCount());
    }
}
