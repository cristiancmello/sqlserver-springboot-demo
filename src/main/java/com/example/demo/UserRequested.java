package com.example.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
@Getter
public class UserRequested {
  private String message;

  private List<User> users;
}
