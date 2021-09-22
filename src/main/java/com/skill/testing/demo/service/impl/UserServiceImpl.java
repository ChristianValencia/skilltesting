package com.skill.testing.demo.service.impl;

import com.skill.testing.demo.facade.IGoRestRepositoryFacade;
import com.skill.testing.demo.facade.model.Post;
import com.skill.testing.demo.facade.model.Todo;
import com.skill.testing.demo.facade.model.User;
import com.skill.testing.demo.service.IUserService;
import com.skill.testing.demo.service.dto.FullUserDto;
import com.skill.testing.demo.service.dto.PostDto;
import com.skill.testing.demo.service.dto.TodoDto;
import com.skill.testing.demo.service.dto.UserDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private IGoRestRepositoryFacade facade;

  public UserServiceImpl(IGoRestRepositoryFacade facade) {
    this.facade = facade;
  }

  @Override
  public List<UserDto> getAllUser() {
    return facade.getAllUser()
        .stream()
        .map(user -> new UserDto(user))
        .collect(Collectors.toList());
  }

  @Override
  public UserDto getUserById(Long idUser) {
    User user = Optional.ofNullable(facade.getUserById(idUser)).orElseGet(User::new);
    return new UserDto(user);
  }

  @Override
  public List<PostDto> getAllPost() {
    return facade.getAllPost()
        .stream()
        .map(post -> new PostDto(post))
        .collect(Collectors.toList());
  }

  @Override
  public List<TodoDto> getAllTodo() {
    return facade.getAllTodo()
        .stream()
        .map(todo -> new TodoDto(todo))
        .collect(Collectors.toList());
  }

  @Override
  public FullUserDto getFullUser(Long idUser) {

    User user = Optional.ofNullable(facade.getUserById(idUser)).orElseGet(User::new);

    FullUserDto fullUserDto = new FullUserDto(user);

    final Optional<List<Post>> postByUser = Optional.ofNullable(facade.getPostByUser(idUser));

    if (postByUser.isPresent()) {
      postByUser.get().stream().forEach(post -> fullUserDto.addPost(new PostDto(post)));
    }

    final Optional<List<Todo>> todoByUser = Optional.ofNullable(facade.getTodoByUser(idUser));

    if (todoByUser.isPresent()) {
      todoByUser.get().stream().forEach(todo -> fullUserDto.addTodo(new TodoDto(todo)));
    }

    return fullUserDto;

  }
}
