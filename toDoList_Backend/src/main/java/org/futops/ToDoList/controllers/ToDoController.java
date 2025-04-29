package org.futops.ToDoList.controllers;

import lombok.RequiredArgsConstructor;
import org.futops.ToDoList.models.ToDo;
import org.futops.ToDoList.services.JwtService;
import org.futops.ToDoList.services.MyUserDetailsService;
import org.futops.ToDoList.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class ToDoController {
    private JwtService jwtService;
    private ToDoService toDoService;
    private MyUserDetailsService myUserDetailsService;

    @GetMapping("/")
    public List<ToDo> getAllToDo(@RequestHeader("Authorization") String authToken) {
        String userEmail = jwtService.extractEmail(authToken.substring(7));
        return toDoService.getAllToDoByUser(userEmail);
    }

    @PutMapping("/")
    public ToDo addToDo(@RequestBody ToDo toDo, @RequestHeader("Authorization") String authToken) {
        String userEmail = jwtService.extractEmail(authToken.substring(7));
        return toDoService.add(toDo,userEmail);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteToDo(@RequestBody ToDo toDo, @RequestHeader("Authorization") String authToken) {
        String userEmail = jwtService.extractEmail(authToken.substring(7));
        return toDoService.delete(toDo, userEmail);
    }
}
