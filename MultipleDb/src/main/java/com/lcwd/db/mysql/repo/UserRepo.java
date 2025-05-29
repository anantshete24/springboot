package com.lcwd.db.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.db.mysql.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
