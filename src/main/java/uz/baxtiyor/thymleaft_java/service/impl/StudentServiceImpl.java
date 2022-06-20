package uz.baxtiyor.thymleaft_java.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.baxtiyor.thymleaft_java.entity.Student;
import uz.baxtiyor.thymleaft_java.repository.StudentRepository;
import uz.baxtiyor.thymleaft_java.service.StudentService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student getById(UUID id){
        Student student=studentRepository.findById(id).get();
        return student;
    }

    @Override
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudents(UUID id){
        studentRepository.deleteById(id);
    }

}
