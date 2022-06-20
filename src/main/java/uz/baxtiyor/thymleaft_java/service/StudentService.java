package uz.baxtiyor.thymleaft_java.service;

import uz.baxtiyor.thymleaft_java.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<Student> getAllStudent();

    Student saveStudent(Student student);

    Student getById(UUID id);

    Student updateStudent(Student student);

    void deleteStudents(UUID id);
}
