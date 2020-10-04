package com.frknshnklksz.mongo.controller;

import com.frknshnklksz.mongo.entitiy.Student;
import com.frknshnklksz.mongo.entitiy.UpdateStudent;
import com.frknshnklksz.mongo.messages.ExceptionMessages;
import com.frknshnklksz.mongo.messages.SuccessMessages;
import com.frknshnklksz.mongo.paths.Paths;
import com.frknshnklksz.mongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frknshnklksz.mongo.messages.SuccessMessages;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = Paths.INSERT_STUDENT)
    public String addStudent(@RequestBody Student student){
        try{
            studentService.createStudent(student);
            return SuccessMessages.SUCCESS_MESSAGE_FOR_INSERT;
        }catch (Exception e){
            return ExceptionMessages.INSERT_EXCEPTON + e.getMessage();
        }
    }


    @GetMapping(value = Paths.GET_BY_ID+"/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }


    @GetMapping(value = Paths.GET_ALL_STUDENTS)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @DeleteMapping(value = Paths.DELETE_BY_ID+"/{id}")
    public String deleteBookById(@PathVariable("id") int id){
        try{
            studentService.deleteStudentById(id);
            return SuccessMessages.SUCCESS_MESSAGE_FOR_DELETE;
        }catch (Exception e){
            return ExceptionMessages.DELETE_EXCEPTION;
        }

    }


    @PutMapping(value = Paths.UPDATE_BY_ID+"/{id}")
    public Optional<Student> updateById(@PathVariable("id") int id, @RequestBody UpdateStudent updateStudent){
        return studentService.updateStudentById(id, updateStudent);
    }
}
