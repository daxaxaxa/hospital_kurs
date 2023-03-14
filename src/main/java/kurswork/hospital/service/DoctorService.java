package kurswork.hospital.service;

import kurswork.hospital.dto.DoctorDto;
import kurswork.hospital.entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(DoctorDto doctorDto);
    Doctor findByName(String name);
    List<DoctorDto> findAllDoctor();
}
