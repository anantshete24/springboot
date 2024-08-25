package com.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orm.entities.Product;

public interface ProductRepo extends JpaRepository<Product,String>{

}
