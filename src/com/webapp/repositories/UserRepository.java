package com.webapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  public List<User> findAll();
  
  public User findByName(String name);
  
}
