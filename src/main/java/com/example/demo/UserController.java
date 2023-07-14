package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "users")
public class UserController {
  @Autowired
  UserRepository userRepository;

  @PostMapping
  public UserCreated create(@RequestParam String name) {
    var created = userRepository.save(User.builder()
      .name(name)
      .build()
    );

    return UserCreated.builder()
      .message(created.toString())
      .build();
  }

  @GetMapping
  @ResponseBody
  public UserRequested query(@RequestParam(name = "id", required = false) String id) {
    try {
      if (id == null) {
        var users = userRepository.findAll();
        var list = new ArrayList<User>();

        users.forEach(list::add);

        return UserRequested.builder()
          .message("Total: " + userRepository.count())
          .users(list)
          .build();
      }

      var requested = userRepository.findById(Long.valueOf(id));
      var user = requested.orElseThrow();

      return UserRequested.builder()
        .message(user.toString())
        .build();
    } catch (NoSuchElementException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }
}
