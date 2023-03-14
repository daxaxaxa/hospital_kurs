package kurswork.hospital.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="appointments")
public class Appoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String firstName;
    @Column(nullable=false)
    private String lastName;
    @Column(nullable=false)
    private String fathersName;
    @Column(nullable=false)
    private String dataBirth;
    @Column(nullable=false,unique=true)
    private String number;
    @Column(nullable = false)
    private String dateApp;

    @Column(nullable = false)
    private String dId;

    @Column(nullable = false)
    private String status;

    public void setId(Long id) {this.id = id;}

    public Long getId() {return id;}

    public String getDataBirth() {return dataBirth;}

    public void setDataBirth(String dataBirth) {this.dataBirth = dataBirth;}

    public String getDateApp() {return dateApp;}

    public String getFathersName() {return fathersName;}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public String getNumber() {return number;}

    public void setDateApp(String dateApp) {this.dateApp = dateApp;}

    public void setFathersName(String fathersName) {this.fathersName = fathersName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setNumber(String number) {this.number = number;}

    public String getdId() {return dId;}

    public void setdId(String dId) {this.dId = dId;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}
}
