package org.futops.ToDoList.repos;

import org.futops.ToDoList.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users getByEmail(String username);
}
