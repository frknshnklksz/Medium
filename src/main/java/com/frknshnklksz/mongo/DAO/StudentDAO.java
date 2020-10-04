package com.frknshnklksz.mongo.DAO;

import com.frknshnklksz.mongo.entitiy.Student;
import com.frknshnklksz.mongo.entitiy.UpdateStudent;
import com.frknshnklksz.mongo.messages.ExceptionMessages;
import com.frknshnklksz.mongo.messages.SuccessMessages;
import com.frknshnklksz.mongo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDAO {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.insert(student);
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> deleteById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        student.ifPresent(item -> studentRepository.delete(item));
        return student;
    }

    public Optional<Student> updateStudentById(int id, UpdateStudent updateStudent) {
        Optional<Student> student = studentRepository.findById(id);
        student.ifPresent(item -> item.setEmail(updateStudent.getEmail()));
        student.ifPresent(item -> item.setCity(updateStudent.getCity()));
        student.ifPresent(item -> studentRepository.save(item));
        return student;
    }
}
