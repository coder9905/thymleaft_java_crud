package uz.baxtiyor.thymleaft_java.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.baxtiyor.thymleaft_java.entity.Student;
import uz.baxtiyor.thymleaft_java.service.StudentService;

import java.util.UUID;


@Controller
@RequiredArgsConstructor
//@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){

        studentService.saveStudent(student);
        return "redirect:/students";

    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable("id") UUID id, Model model){
        model.addAttribute("student",studentService.getById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute("student") Student student, Model model){
        Student student1=studentService.getById(id);

        student1.setId(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());

        studentService.updateStudent(student1);

        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id, Model model){
        System.out.println("post delete");
        studentService.deleteStudents(id);
        return "redirect:/students";
    }

}
