package com.frknshnklksz.mongo.service;

import com.frknshnklksz.mongo.DAO.StudentDAO;
import com.frknshnklksz.mongo.entitiy.Student;
import com.frknshnklksz.mongo.entitiy.UpdateStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public Student createStudent(Student student) {
        return studentDAO.createStudent(student);
    }

    public Optional<Student> getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Optional<Student> deleteStudentById(int id) {
        return  studentDAO.deleteById(id);
    }

    public Optional<Student> updateStudentById(int id, UpdateStudent updateStudent) {
        return studentDAO.updateStudentById(id, updateStudent);
    }
}
