package com.skill.testing.demo.service.dto;

import com.skill.testing.demo.facade.model.User;
import java.util.ArrayList;
import java.util.List;

public class FullUserDto extends UserDto {

  private TodoDto latestTodo;


  private List<PostDto> posts = new ArrayList<>();

  public FullUserDto(User user) {
    super(user);
  }


  public void addPost(PostDto postDto) {
    this.posts.add(postDto);
  }


  public List<PostDto> getPosts() {
    return posts;
  }

  public TodoDto getLatestTodo() {
    return latestTodo;
  }

  public void setLatestTodo(TodoDto latestTodo) {
    this.latestTodo = latestTodo;
  }
}
