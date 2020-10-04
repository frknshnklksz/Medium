package com.frknshnklksz.mongo.repositories;

import com.frknshnklksz.mongo.entitiy.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
