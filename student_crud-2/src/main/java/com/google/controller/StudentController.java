package com.google.controller;

import com.google.entity.Student;
import com.google.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository Repo;
    //get all students
    @GetMapping("/students")
    public List<Student>getAllStudents(){
        List<Student>students=Repo.findAll();
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student=Repo.findById(id).get();
        return student;
    }
    @PostMapping("/student/add")
    public void createStudent(@RequestBody Student student){
        Repo.save(student);

    }
    @PutMapping("/student/update/{id}")
    public Student updateStudents(@PathVariable int id){
       Student student= Repo.findById(id).get();
       student.setName("david");
       student.setPercentage(78);
       Repo.save(student);
       return student;
    }
    @DeleteMapping("/student/delete/{id}")
    public void  deleteStudent(@PathVariable int id){
        Student student=Repo.findById(id).get();
        Repo.delete(student);

    }

}
