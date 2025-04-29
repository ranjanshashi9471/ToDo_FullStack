package org.futops.ToDoList.controllers;

import lombok.RequiredArgsConstructor;
import org.futops.ToDoList.dtos.LoginRequest;
import org.futops.ToDoList.models.Users;
import org.futops.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest user){
        return userService.verifyUser(user);
    }

    @PostMapping("/register")
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        return userService.registerUser(user);
    }
}
