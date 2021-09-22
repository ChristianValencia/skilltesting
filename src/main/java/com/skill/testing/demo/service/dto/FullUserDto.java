package com.skill.testing.demo.service.dto;

import com.skill.testing.demo.facade.model.User;
import java.util.ArrayList;
import java.util.List;

public class FullUserDto extends UserDto {

  private List<TodoDto> todos = new ArrayList<>();
  private List<PostDto> posts = new ArrayList<>();

  public FullUserDto(User user) {
    super(user);
  }

  public void addTodo(TodoDto todoDto) {
    this.todos.add(todoDto);
  }

  public void addPost(PostDto postDto) {
    this.posts.add(postDto);
  }

  public List<TodoDto> getTodos() {
    return todos;
  }

  public List<PostDto> getPosts() {
    return posts;
  }
}
