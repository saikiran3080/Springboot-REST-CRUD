package com.springboot.restcrud.rest;
//   BEST PRACTICE OF EXCEPTION HANDLING GLOBALY FOR LARGE SCALE PROJECTS
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
//    add exception handling code here

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
