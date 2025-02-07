package com.springboot.restcrud.rest;

import com.springboot.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
//    define @PostConstruct to load student data only at once
    @PostConstruct
    public void loadData()
    {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Sai" ,"Kiran"));
        theStudents.add(new Student("David" , "Warner"));
        theStudents.add(new Student("Patt","Cummins"));
        theStudents.add(new Student("Virat", "Kohli"));

    }

//    define endpoints for /students : return the list of all students
//    for now i am hard coding it , will connect it to DB later
    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        return  theStudents;
//        Spring REST and JACKSON converts automatically POJOS to JSON
//        Jackson is one of the most used libraries of spring boot which translates
//        JSON data to a Java POJO by itself and vice-versa. JSON stands for
//        JavaScript-object-Notation and POJO is our plain-old-java-object class.
    }


//    define endpoints for "students/{studnetId}" : reterive data for singe student
    @GetMapping("students/{studentId}")
    public  Student getStudentById(@PathVariable int studentId)
    {
//        just index into list : just for making it simple
        return theStudents.get(studentId);
    }
}
