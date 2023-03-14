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
public class AppointDto {
    private Long id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String fathersName;
    @NotEmpty
    private String dataBirth;
    @NotEmpty
    private String number;
    @NotEmpty
    private String dateApp;

    @NotEmpty
    private String dId;
    @NotEmpty
    private String status;

    public void setId(Long id) {this.id = id;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public void setFathersName(String fathersName) {this.fathersName = fathersName;}

    public String getNumber() {return number;}

    public String getLastName() {return lastName;}

    public String getFirstName() {return firstName;}

    public String getFathersName() {return fathersName;}

    public String getDateApp() {return dateApp;}

    public Long getId() {return id;}

    public void setDataBirth(String dataBirth) {this.dataBirth = dataBirth;}

    public String getDataBirth() {return dataBirth;}

    public void setNumber(String number) {this.number = number;}

    public void setDateApp(String dateApp) {this.dateApp = dateApp;}

    public String getdId() {return dId;}

    public void setdId(String dId) {this.dId = dId;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}
}
