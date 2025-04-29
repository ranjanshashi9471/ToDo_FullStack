package org.futops.ToDoList.services;

import lombok.RequiredArgsConstructor;
import org.futops.ToDoList.models.ToDo;
import org.futops.ToDoList.models.Users;
import org.futops.ToDoList.repos.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private UserService userService;
    private ToDoRepo toDoRepo;

    public List<ToDo> getAllToDoByUser(String userEmail) {
        Users user = userService.getByEmail(userEmail);
        return  toDoRepo.findAllByUser(user);
    }

    public ToDo add(ToDo toDo, String email) {
        toDo.setUser(userService.getByEmail(email));
        return toDoRepo.save(toDo);
    }

    public ResponseEntity<String> delete(ToDo toDo, String userEmail) { 
        Optional<ToDo> returned = toDoRepo.findById(toDo.getId());
        if(returned.isPresent()){
            if(returned.get().getUser().getEmail().equals(userEmail)){
                toDoRepo.delete(returned.get());
                return new ResponseEntity<>("Success!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("UnAuthorized", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("Not Found!!", HttpStatus.NOT_FOUND);
    }
}
