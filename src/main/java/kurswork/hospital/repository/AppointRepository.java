package kurswork.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import kurswork.hospital.entity.Appoint;
public interface AppointRepository extends JpaRepository<Appoint,Long>{
    Appoint findByNumber(String number);
}
