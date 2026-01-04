package org.bloggerManagementSystem.blogger.controller;

import org.bloggerManagementSystem.blogger.entity.User;
import org.bloggerManagementSystem.blogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public List<User> createUsers(@RequestBody List<User> users){
        return userService.createUsers(users);
    }
}


// create user (single user) --> POST /user  (RequestBody)
// update user --> PUT /user  (RequestBody)
// delete user by id --> DELETE /user:id=ashu  
// get user by id --> GET /user:id=ashu
// login user controller OR  get user by email and password --> POST /loginuser  (RequestBody Customize or DTO)

