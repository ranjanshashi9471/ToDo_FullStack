package org.futops.ToDoList.repos;

import org.futops.ToDoList.models.ToDo;
import org.futops.ToDoList.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Integer> {
    List<ToDo> findAllByUser(Users user);
}