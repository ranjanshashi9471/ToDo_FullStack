package org.futops.ToDoList.services;

import lombok.RequiredArgsConstructor;
import org.futops.ToDoList.dtos.LoginRequest;
import org.futops.ToDoList.models.Users;
import org.futops.ToDoList.repos.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private AuthenticationManager authManager;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private UserRepo userRepo;

    public ResponseEntity<String> verifyUser(LoginRequest credentials) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
            Authentication authenticate = authManager.authenticate(token);
            if (authenticate.isAuthenticated()) {
                String jwtToken = jwtService.getToken(credentials.getEmail());
                return ResponseEntity.ok(jwtToken);
            } else {
                return new ResponseEntity<>("Failed!!", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Users> registerUser(LoginRequest user) {
        try {
            Users newUser = new Users();
            newUser.setPwdhash(passwordEncoder.encode(user.getPassword()));
            newUser.setEmail(user.getEmail());
            newUser = userRepo.save(newUser);
            if (newUser.getId()!=null) {
                return new ResponseEntity<>(newUser, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Users getByEmail(String email) {
        return userRepo.getByEmail(email);
    }
}
