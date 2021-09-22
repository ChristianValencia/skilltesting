package com.skill.testing.demo.service;

import com.skill.testing.demo.service.dto.FullUserDto;
import com.skill.testing.demo.service.dto.PostDto;
import com.skill.testing.demo.service.dto.TodoDto;
import com.skill.testing.demo.service.dto.UserDto;
import java.util.List;

public interface IUserService {

  List<UserDto> getAllUser();

  UserDto getUserById(Long idUser);

  List<PostDto> getAllPost();

  List<TodoDto> getAllTodo();

  FullUserDto getFullUser(Long idUser);

}
