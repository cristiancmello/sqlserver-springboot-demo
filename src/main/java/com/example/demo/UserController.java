package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  UserRepository userRepository;

  @PostMapping("/users")
  public UserCreated create() {
    var created = userRepository.save(User.builder()
      .name("Vitor")
      .build()
    );

    return UserCreated.builder()
      .message(created.toString())
      .build();
  }
}
