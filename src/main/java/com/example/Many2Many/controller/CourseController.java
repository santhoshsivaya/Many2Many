package com.example.Many2Many.controller;

import com.example.Many2Many.models.Course;
import com.example.Many2Many.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    public CourseRepository repository;

    @GetMapping
    public List<Course> getAllCourse(){
        return repository.findAll();
    }

    @PostMapping
    public String insertCourse(@RequestBody Course course){
        repository.save(course);
        return "Course added.";
    }

    @PutMapping("/{id}")
    public String updateCourse(@PathVariable long id,@RequestBody Course course){
        Optional<Course> course1 = repository.findById(id);
        if (course1.isPresent()) {
            course1.get().setName(course.getName());
            course1.get().setStudents(course.getStudents());
            repository.save(course1.get());
        }
        return "Course updated.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        repository.deleteById(id);
        return "Course delete0d.";
    }
}
