package com.skill.testing.demo.facade.impl;

import com.skill.testing.demo.facade.IGoRestRepositoryFacade;
import com.skill.testing.demo.facade.model.Post;
import com.skill.testing.demo.facade.model.Todo;
import com.skill.testing.demo.facade.model.User;
import com.skill.testing.demo.facade.response.GoRestPostResponse;
import com.skill.testing.demo.facade.response.GoRestTodoResponse;
import com.skill.testing.demo.facade.response.GoRestUserListResponse;
import com.skill.testing.demo.facade.response.GoRestUserResponse;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GoRestRepositoryImpl implements IGoRestRepositoryFacade {

  private RestTemplate restTemplate;

  private final String GO_REST_URL = "https://gorest.co.in/public/v1";
  private final String USERS = "/users/";
  private final String POSTS = "/posts/";
  private final String TODOS = "/todos/";


  public GoRestRepositoryImpl(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  @Override
  public List<User> getAllUsers() {

    return restTemplate.getForEntity(this.buildUsersURL(), GoRestUserListResponse.class).getBody().getData();

  }

  @Override
  public User getUserById(Long userId) {

    return restTemplate.getForEntity(this.buildUserByIdURL(userId), GoRestUserResponse.class).getBody().getData();

  }

  @Override
  public List<Post> getAllPosts() {

    return restTemplate.getForEntity(this.buildPostsURL(), GoRestPostResponse.class).getBody().getData();
  }

  @Override
  public List<Todo> getAllTodos() {
    return restTemplate.getForEntity(this.buildTodosURL(), GoRestTodoResponse.class).getBody().getData();
  }

  @Override
  public List<Post> getPostByUser(Long userId) {
    try {
      return restTemplate.getForEntity(this.buildPostByUserURL(userId), GoRestPostResponse.class).getBody().getData();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public List<Todo> getTodoByUser(Long userId) {
    try {
      return restTemplate.getForEntity(this.buildTodosByUserURL(userId), GoRestTodoResponse.class).getBody().getData();
    } catch (Exception e) {
      return null;
    }
  }

  private String buildUsersURL() {
    return GO_REST_URL.concat(USERS);
  }

  private String buildUserByIdURL(Long id) {
    return buildUsersURL().concat(id.toString());
  }

  private String buildPostByUserURL(Long id) {
    return buildUserByIdURL(id).concat(POSTS);
  }

  private String buildTodosByUserURL(Long id) {
    return buildUserByIdURL(id).concat(TODOS);
  }

  private String buildPostsURL() {
    return GO_REST_URL.concat(POSTS);
  }

  private String buildTodosURL() {
    return GO_REST_URL.concat(TODOS);
  }

}
