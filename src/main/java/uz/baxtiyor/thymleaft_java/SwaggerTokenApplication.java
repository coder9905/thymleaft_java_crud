package uz.baxtiyor.thymleaft_java;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.baxtiyor.thymleaft_java.repository.StudentRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class SwaggerTokenApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SwaggerTokenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Student student1=new Student("Ramesh1","Fadatare1","test1@gmail.com");
//        studentRepository.save(student1);
//
//        Student student2=new Student("Ramesh2","Fadatare2","test2@gmail.com");
//        studentRepository.save(student2);
//
//        Student student3=new Student("Ramesh3","Fadatare3","test3@gmail.com");
//        studentRepository.save(student3);

    }
}
