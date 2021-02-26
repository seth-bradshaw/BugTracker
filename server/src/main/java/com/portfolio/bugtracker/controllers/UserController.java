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

    //admin only
    @GetMapping(value = "/user/{userid}", produces = "application/json")
    public ResponseEntity<?> getUserById(@PathVariable long userid) throws Exception
    {
        User user = userService.findUserById(userid);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //for user to access limited other user data
    @GetMapping(value ="/user/{userid}/limited", produces = "application/json")
    public ResponseEntity<?> getLimitedUserInfoById(@PathVariable long userid)
    {
        User user = userService.findUserByIdLimited(userid);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //admin permissions
    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<?> getAllUsers()
    {
        List<User> userList = userService.findAllUsers();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    //for user to access limited users data
    @GetMapping(value = "/users/limited", produces = "application/json")
    public ResponseEntity<?> getAllUsersLimited()
    {
        List<User> userList = userService.findAllUsersLimited();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    //admin
    @PostMapping(value = "/users", consumes = "application/json")
    public ResponseEntity<?> addNewUser(@RequestBody @Valid User newuser) throws Exception
    {
        newuser.setUserid(0);
        newuser = userService.save(newuser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //admin
    @PutMapping(value = "/user/{userid}", consumes = "application/json")
    public ResponseEntity<?> editFullExistingUser(@RequestBody @Valid User editedFullUser, @PathVariable long userid) throws Exception
    {
        editedFullUser.setUserid(userid);
        editedFullUser = userService.save(editedFullUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //admin or activeuser can edit username, email and password.
    @PatchMapping(value = "/edituser/{userid}", consumes = "application/json")
    public ResponseEntity<?> editPartExistingUser(@RequestBody User partiallyEditedUser, @PathVariable long userid) throws Exception
    {
        partiallyEditedUser.setUserid(userid);
        partiallyEditedUser = userService.edit(partiallyEditedUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //admin
    @DeleteMapping(value = "/user/{userid}")
    public ResponseEntity<?> deleteUserById(@PathVariable long userid)
    {
        userService.deleteUserById(userid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
