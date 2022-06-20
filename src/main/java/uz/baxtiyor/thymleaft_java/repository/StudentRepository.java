package uz.baxtiyor.thymleaft_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.baxtiyor.thymleaft_java.entity.Student;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

//    Student findById(UUID id);

}
