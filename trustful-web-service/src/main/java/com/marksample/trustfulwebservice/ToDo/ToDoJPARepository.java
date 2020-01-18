package com.marksample.trustfulwebservice.ToDo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoJPARepository extends JpaRepository<ToDo, Long> {

    List<ToDo> findByUsername(String username);
}
