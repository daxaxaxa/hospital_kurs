package kurswork.hospital.controller;

import jakarta.validation.Valid;
import kurswork.hospital.dto.AppointDto;
import kurswork.hospital.entity.Appoint;
import kurswork.hospital.entity.Doctor;
import kurswork.hospital.entity.Status;
import kurswork.hospital.entity.User;
import org.springframework.ui.Model;
import kurswork.hospital.dto.DoctorDto;
import kurswork.hospital.repository.AppointRepository;
import kurswork.hospital.repository.DoctorRepository;
import kurswork.hospital.service.AppointService;
import kurswork.hospital.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {
    private DoctorRepository doctorRepository;
    private DoctorService doctorService;
    private AppointService appointService;
    private AppointRepository appointRepository;

    public MainController(DoctorService doctorService, DoctorRepository doctorRepository,
                          AppointRepository appointRepository, AppointService appointService){
        this.appointRepository=appointRepository;
        this.appointService=appointService;
        this.doctorRepository=doctorRepository;
        this.doctorService=doctorService;
    }

    @GetMapping("/patient")
    public String patient(Model model){
        List<DoctorDto> doctors=doctorService.findAllDoctor();
        model.addAttribute("doctors", doctors);
        return "patient";
    }

    @GetMapping("/patient/{doctor}")
    public String app(@PathVariable Doctor doctor,Model model){
        model.addAttribute("doctor",doctor);
        return "appoint";
    }
    @PostMapping("/patient/{doctor}")
    public String saveApp(@PathVariable Doctor doctor, @RequestParam String firstName, @RequestParam String lastName,
                          @RequestParam String fathersName, @RequestParam String data, @RequestParam String number,
                          @RequestParam String dateApp){
        AppointDto appoint=new AppointDto();
        appoint.setDateApp(dateApp);
        appoint.setDataBirth(data);
        appoint.setNumber(number);
        appoint.setFathersName(fathersName);
        appoint.setFirstName(firstName);
        appoint.setdId(doctor.getName());
        appoint.setLastName(lastName);
        appointService.saveAppoint(appoint);
        return "redirect:/patient";
    }

    @GetMapping("/doctor")
    public String doctor(Model model){
        List<AppointDto> appoints=appointService.findAllAppoint();
        model.addAttribute("appoints", appoints);
        List<String> statuses= Stream.of(Status.values()).map(Enum::name).collect(Collectors.toList());
        model.addAttribute("statuses",statuses);
        return "doctor";
    }

    @PostMapping("/doctor/{appoint}")
    public String userEdit(@PathVariable Appoint appoint, @RequestParam String status){
        if (!Objects.equals(status, "Over")){
            appoint.setStatus(status);
            appointRepository.save(appoint);
            return "redirect:/doctor";
        }
        appointRepository.delete(appoint);
        return "redirect:/doctor";
    }

    @GetMapping("admin/doctors")
    public String doctors(Model model){
        List<DoctorDto> doctors=doctorService.findAllDoctor();
        model.addAttribute("doctors",doctors);
        return "doctors";
    }

    @GetMapping("admin/doctors/{doctor}")
    public String delD(@PathVariable Doctor doctor){
        doctorRepository.delete(doctor);
        return "redirect:/admin/doctors";
    }

    @GetMapping("/admin/doctors/edit/{doctor}")
    public String dEditCard(@PathVariable Doctor doctor, Model model){
        model.addAttribute("doctor",doctor);
        return "edit_doctor";
    }

    @PostMapping("admin/doctors/edit/{doctor}")
    public String dEditSave(@PathVariable Doctor doctor,@RequestParam String name,
                            @RequestParam String specialization){
        doctor.setSpecialization(specialization);
        doctor.setName(name);
        doctorRepository.save(doctor);
        return "redirect:/admin/doctors";
    }

    @GetMapping("/admin/doctors/new")
    public String newD(Model model){
        DoctorDto doctor=new DoctorDto();
        model.addAttribute("doctor",doctor);
        return "new_doctor";
    }

    @PostMapping("/admin/doctors/new/save")
    public String saveD(@Valid @ModelAttribute("doctor") DoctorDto doctor,
                        BindingResult result,
                        Model model)
    {
        Doctor ex=doctorService.findByName(doctor.getName());
        if(ex!=null){
            result.rejectValue("name", null, "There is already a doctor with that name");
        }
        if (result.hasErrors()) {
            model.addAttribute("doctor", doctor);
        }
        doctorService.saveDoctor(doctor);
        return "redirect:/admin/doctors";
    }
}
