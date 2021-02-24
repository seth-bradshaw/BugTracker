package com.portfolio.bugtracker.controllers;

import com.portfolio.bugtracker.models.User;
import com.portfolio.bugtracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/users")
@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{userid}", produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable long userid) throws Exception
    {
        User user = userService.findUserById(userid);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> userList = userService.findAllUsers();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = "application/json")
    public ResponseEntity<?> addNewUser(@RequestBody @Valid User newuser)
    {
        newuser.setUserid(0);
        newuser = userService.save(newuser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{userid}", consumes = "application/json")
    public ResponseEntity<?> editFullExistingUser(@RequestBody @Valid User editedFullUser, @PathVariable long userid)
    {
        editedFullUser.setUserid(userid);
        editedFullUser = userService.save(editedFullUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/edituser/{userid}", consumes = "application/json")
    public ResponseEntity<?> editPartExistingUser(@RequestBody User partiallyEditedUser, @PathVariable long userid) throws Exception
    {
        partiallyEditedUser.setUserid(userid);
        partiallyEditedUser = userService.edit(partiallyEditedUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{userid}")
    public ResponseEntity<?> deleteUserById(@PathVariable long userid)
    {
        userService.deleteUserById(userid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
