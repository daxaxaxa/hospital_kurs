package kurswork.hospital.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String specialization;

    public void setSpecialization(String specialization) {this.specialization = specialization;}

    public String getSpecialization() {return specialization;}

    public Long getId() {return id;}

    public void setName(String name) {this.name = name;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
}
