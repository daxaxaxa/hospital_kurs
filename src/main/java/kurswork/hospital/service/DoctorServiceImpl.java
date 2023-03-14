package kurswork.hospital.service;

import kurswork.hospital.dto.DoctorDto;
import kurswork.hospital.entity.Doctor;
import kurswork.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{
    private DoctorRepository doctorRepository;
    public DoctorServiceImpl(DoctorRepository doctorRepository){this.doctorRepository=doctorRepository;}
    @Override
    public Doctor saveDoctor(DoctorDto doctorDto) {
        Doctor doctor=new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor findByName(String name) {
        return doctorRepository.findByName(name);
    }

    @Override
    public List<DoctorDto> findAllDoctor() {
        List<Doctor> doctors=doctorRepository.findAll();
        return doctors.stream().map((doctor)->convertEntityToDto(doctor)).collect(Collectors.toList());
    }
    private DoctorDto convertEntityToDto(Doctor doctor){
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setName(doctor.getName());
        doctorDto.setId(doctor.getId());
        doctorDto.setSpecialization(doctor.getSpecialization());
        return doctorDto;
    }
}
