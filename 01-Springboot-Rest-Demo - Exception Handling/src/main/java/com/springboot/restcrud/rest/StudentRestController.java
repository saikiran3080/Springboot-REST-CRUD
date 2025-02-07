package com.springboot.restcrud.rest;

import com.springboot.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//        check student index against its size
        if(studentId >= theStudents.size() || studentId<0)
        {
            throw new StudentNotFoundException("Student ID is not found: "+studentId);
        }


//        just index into list : just for making it simple
        return theStudents.get(studentId);
    }


//    Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
//        create student error response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessages(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

//        return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

//    Add another excception handler to cathc any exceptiom
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> catchException(Exception exc)
    {
//        create student error response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessages(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

//        return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
