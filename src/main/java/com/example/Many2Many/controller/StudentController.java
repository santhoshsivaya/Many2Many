package com.example.Many2Many.controller;

import com.example.Many2Many.models.Student;
import com.example.Many2Many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentRepository repository;

    @GetMapping
    public List<Student> getAllStudent(){
        return repository.findAll();
    }

    @PostMapping
    public String insertStudent(@RequestBody Student student){
        repository.save(student);
        return "Student added.";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable long id,@RequestBody Student student){
        Optional<Student> student1 = repository.findById(id);
        if (student1.isPresent()) {
            student1.get().setName(student.getName());
            student1.get().setCourses(student.getCourses());
            repository.save(student1.get());
        }
        return "Student updated.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        repository.deleteById(id);
        return "Student delete0d.";
    }
}