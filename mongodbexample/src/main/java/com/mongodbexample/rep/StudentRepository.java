package com.mongodbexample.rep;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodbexample.models.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

}
