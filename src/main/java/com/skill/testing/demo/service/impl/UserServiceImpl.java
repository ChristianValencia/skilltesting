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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private IGoRestRepositoryFacade facade;
  private final String PENDING_STATE="pending";

  public UserServiceImpl(IGoRestRepositoryFacade facade) {
    this.facade = facade;
  }

  @Override
  public List<UserDto> getAllUsers() {
    return facade.getAllUsers()
        .stream()
        .map(user -> new UserDto(user))
        .collect(Collectors.toList());
  }

  @Override
  public UserDto getUserById(Long userId) {
    User user = Optional.ofNullable(facade.getUserById(userId)).orElseGet(User::new);
    return new UserDto(user);
  }

  @Override
  public List<PostDto> getAllPosts() {
    return facade.getAllPosts()
        .stream()
        .map(post -> new PostDto(post))
        .collect(Collectors.toList());
  }

  @Override
  public List<TodoDto> getAllTodos() {
    return facade.getAllTodos()
        .stream()
        .map(todo -> new TodoDto(todo))
        .collect(Collectors.toList());
  }

  @Override
  public FullUserDto getFullUser(Long userId) {

    User user = Optional.ofNullable(facade.getUserById(userId)).orElseGet(User::new);

    FullUserDto fullUserDto = new FullUserDto(user);

    final Optional<List<Post>> postByUser = Optional.ofNullable(facade.getPostByUser(userId));

    if (postByUser.isPresent()) {
      postByUser.get().stream().forEach(post -> fullUserDto.addPost(new PostDto(post)));
    }

    final Optional<List<Todo>> todoByUser = Optional.ofNullable(facade.getTodoByUser(userId));

    if (todoByUser.isPresent()) {

      Optional<TodoDto> todoDto = todoByUser.get().stream()
          .filter(todo -> todo.getStatus().equalsIgnoreCase(PENDING_STATE))
          .sorted(Comparator.comparing(Todo::getDueOn).reversed())
          .findFirst().map(todo -> new TodoDto(todo));

      fullUserDto.setLatestTodo(todoDto.get());

    }

    return fullUserDto;

  }
}
