package com.skill.testing.demo.service;

import com.skill.testing.demo.service.dto.FullUserDto;
import com.skill.testing.demo.service.dto.PostDto;
import com.skill.testing.demo.service.dto.TodoDto;
import com.skill.testing.demo.service.dto.UserDto;
import java.util.List;

public interface IUserService {

  List<UserDto> getAllUsers();

  UserDto getUserById(Long userId);

  List<PostDto> getAllPosts();

  List<TodoDto> getAllTodos();

  FullUserDto getFullUser(Long userId);

}
