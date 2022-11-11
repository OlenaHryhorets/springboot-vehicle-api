package com.myorg.controller;

import com.myorg.model.User;
import com.myorg.service.UserService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value =  "api/v1/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public Optional<User> getUserById(@PathVariable Integer id) {
    return userService.getUserById(id);
  }

  @PostMapping("")
  public ResponseEntity<?> saveUser(@RequestBody User user) {
    ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.CREATED);
    try {
      userService.saveUser(user);
      return response;
    } catch (Exception e) {
      response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      return response;
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id) {
    ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.OK);
    try {
      Optional<User> existUser = userService.getUserById(id);
      user.setId(id);
      userService.saveUser(user);
      return response;
    } catch (NoSuchElementException e) {
      response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
      return response;
    }
  }

  @DeleteMapping("/{id}")
  public void deleteUserById(@PathVariable Integer id) {
    userService.deleteUserById(id);
  }
}
