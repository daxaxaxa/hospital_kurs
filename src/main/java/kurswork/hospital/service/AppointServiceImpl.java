package kurswork.hospital.service;

import kurswork.hospital.dto.AppointDto;
import kurswork.hospital.entity.Appoint;
import kurswork.hospital.repository.AppointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointServiceImpl implements AppointService{
    private AppointRepository appointRepository;
    public AppointServiceImpl(AppointRepository appointRepository){this.appointRepository=appointRepository;}
    @Override
    public Appoint saveAppoint(AppointDto appointDto) {
        Appoint appoint=new Appoint();
        appoint.setDataBirth(appointDto.getDataBirth());
        appoint.setDateApp(appointDto.getDateApp());
        appoint.setFathersName(appointDto.getFathersName());
        appoint.setFirstName(appointDto.getFirstName());
        appoint.setLastName(appointDto.getLastName());
        appoint.setNumber(appointDto.getNumber());
        appoint.setdId(appointDto.getdId());
        appoint.setStatus("Expected");
        return appointRepository.save(appoint);
    }

    @Override
    public Appoint findByNumber(String number) {
        return appointRepository.findByNumber(number);
    }

    @Override
    public List<AppointDto> findAllAppoint() {
        List<Appoint> appoints=appointRepository.findAll();
        return appoints.stream().map((appoint)->convertEntityToDto(appoint)).collect(Collectors.toList());
    }
    private AppointDto convertEntityToDto(Appoint appoint){
        AppointDto appointDto = new AppointDto();
        appointDto.setDataBirth(appoint.getDataBirth());
        appointDto.setDateApp(appoint.getDateApp());
        appointDto.setFathersName(appoint.getFathersName());
        appointDto.setFirstName(appoint.getFirstName());
        appointDto.setLastName(appoint.getLastName());
        appointDto.setNumber(appoint.getNumber());
        appointDto.setId(appoint.getId());
        appointDto.setdId(appoint.getdId());
        appointDto.setStatus(appoint.getStatus());
        return appointDto;
    }
}
