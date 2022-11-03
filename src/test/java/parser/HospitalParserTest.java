package parser;

import com.example.demo.dao.HospitalDao;
import com.example.demo.domain.Hospital;
import com.example.demo.parser.ReadLineContext;
import com.example.demo.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest //SpringBoot가 스캔을 해서 등록한 Bean을 Test에서 쓸 수 있게 해줌
class HospitalParserTest {

    @Autowired //Autowired는 주로 test, 서비스 코드는 final or Constructor를 사용
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired //HospitalDao 에 @Component가 있어 bean으로 등록되어 있음.
    HospitalDao hospitalDao;

    @Autowired
    HospitalService hospitalService;

    @Test
    @DisplayName("10만건 이상 데이터가 add되는가")
    void name() throws IOException {
        String filename = "C:\\Users\\Chris\\Downloads\\likelion\\SQL_exercises";
        int cnt = this.hospitalService.insertLargeVolumeHospitalData(filename);
        assertTrue(cnt > 100000);
        System.out.printf("파싱된 데이터 개수:%d", cnt);
    }
}