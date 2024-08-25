package com.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orm.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,String>{

}
