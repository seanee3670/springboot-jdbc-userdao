package com.example.demo.dao;

import com.example.demo.domain.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class HospitalDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Hospital findById(String id) {
        String sql = "SELECT * FROM nation_wide_hospitals ORDER BY nation_wide_hospitals.id=?";
        return jdbcTemplate.queryForObject(sql, hospitalRowMapper(), id);
    }
    public int getCount() {
        String sql = "SELECT count(id) FROM nation_wide+hospitals;";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<Hospital> getAll() {
        String sql = "SELECT * FROM nation_wide_hospitals ORDER BY id";
        return jdbcTemplate.query(sql, hospitalRowMapper());
    }

    // List<Hospital> -- 11만건 Hospital
    public void add(Hospital hospital) { // id, management_number 는 각각 pk, unique 이다
        String sql = "INSERT INTO nation_wide_hospitals(id, open_service_name, open_local_government_code, manegement_number, license_date, business_state, business_status_code, phone, full_address, road_name_address, hospital_name, business_type_name, healthcare_provider_count, patient_room_count, total_number_of_beds, total_area_size)" +
                "VALUES (?, ?, ?," +
                " ?, ?, ?," +
                " ?, ?, ?," +
                " ?, ?, ?," +
                " ?, ?, ?," +
                " ?)";
        jdbcTemplate.update(sql, hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(),
                hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(),
                hospital.getBusinessStatusCode(), hospital.getPhone(), hospital.getFullAddress(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName(),
                hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(),
                hospital.getTotalAreaSize()

        );
    }

    public void deleteById(String id) {
        String sql = "DELETE FROM nation_wide_hospitals.id=?";
        jdbcTemplate.update(sql, id);
    }

    public void deleteAll() {
        String sql = "DELETE FROM nation_wide_hospitals";
        jdbcTemplate.update(sql);
    }

    private RowMapper<Hospital> hospitalRowMapper() {
        return (rs, rowNum) -> {
            SimpleDateFormat sdf = new SimpleDateFormat();
            Hospital hospital = new Hospital(rs.getInt("id"),
                    rs.getString("open_service_name"),
                    rs.getInt("open_local_government_code"),
                    rs.getString("management_number"),
                    rs.getTimestamp("license_date").toLocalDateTime(),
                    rs.getInt("business_state"),
                    rs.getInt("business_status_code"),
                    rs.getString("phone"),
                    rs.getString("full_address"),
                    rs.getString("road_name_address"),
                    rs.getString("hospital_name"),
                    rs.getString("business_type_name"),
                    rs.getInt("healthcare_provider_count"),
                    rs.getInt("patient_room_count"),
                    rs.getInt("total_number_of_beds"),
                    rs.getFloat("total_area_size"));
            return hospital;
        };
    }
}
