package com.skill.testing.demo.controller;

import com.skill.testing.demo.service.IUserService;
import com.skill.testing.demo.service.dto.FullUserDto;
import com.skill.testing.demo.service.dto.PostDto;
import com.skill.testing.demo.service.dto.TodoDto;
import com.skill.testing.demo.service.dto.UserDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private IUserService service;

  public UserController(IUserService service) {
    this.service = service;
  }

  @GetMapping("/allUsers")
  public List<UserDto> getAllUsers() {
    return service.getAllUsers();
  }

  @GetMapping("/allPosts")
  public List<PostDto> getAllPosts() {
    return service.getAllPosts();
  }

  @GetMapping("/allTodos")
  public List<TodoDto> getAllTodos() {
    return service.getAllTodos();
  }

  @GetMapping("/user/{userId}")
  public UserDto getUserById(@PathVariable Long userId) {
    return service.getUserById(userId);
  }

  @GetMapping("/user/{userId}/overAllInfo")
  public FullUserDto getFullUser(@PathVariable Long userId) {
    return service.getFullUser(userId);
  }
}
