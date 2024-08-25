package com.data.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="mybooks", collectionResourceRel="boo")
public interface BookRepository extends JpaRepository<Book, Integer>{

	
}
