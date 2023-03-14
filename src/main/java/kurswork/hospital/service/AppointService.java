package kurswork.hospital.service;

import kurswork.hospital.dto.AppointDto;
import kurswork.hospital.entity.Appoint;

import java.util.List;

public interface AppointService {
    Appoint saveAppoint(AppointDto appointDto);
    Appoint findByNumber(String number);
    List<AppointDto> findAllAppoint();
}
