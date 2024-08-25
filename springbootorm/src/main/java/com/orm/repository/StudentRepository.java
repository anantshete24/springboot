package com.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orm.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
