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
    return service.getAllUser();
  }

  @GetMapping("/allPost")
  public List<PostDto> getAllPost() {
    return service.getAllPost();
  }

  @GetMapping("/allTodo")
  public List<TodoDto> getAllTodo() {
    return service.getAllTodo();
  }

  @GetMapping("/user/{idUser}")
  public UserDto getUserById(@PathVariable Long idUser) {
    return service.getUserById(idUser);
  }

  @GetMapping("/fullUser/{idUser}")
  public FullUserDto getFullUser(@PathVariable Long idUser) {
    return service.getFullUser(idUser);
  }
}
