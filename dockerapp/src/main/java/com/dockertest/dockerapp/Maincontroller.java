package com.dockertest.dockerapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Maincontroller {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/getstudents")
    public List<Student> getAllStudnet() {
        return studentRepo.findAll();
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
       Student stu = new Student();
       stu.setStudentName(student.getStudentName());
       studentRepo.save(stu);
       return "Success";
    }


}
