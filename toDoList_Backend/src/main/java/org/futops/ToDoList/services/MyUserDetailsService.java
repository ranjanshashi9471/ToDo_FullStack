package org.futops.ToDoList.services;

import lombok.RequiredArgsConstructor;
import org.futops.ToDoList.models.Users;
import org.futops.ToDoList.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users found = userRepo.getByEmail(username);
        if (found == null) {
            throw new UsernameNotFoundException("User not found!!");
        }
        return new User(found.getEmail(), found.getPassword(), Collections.EMPTY_LIST);
    }
}