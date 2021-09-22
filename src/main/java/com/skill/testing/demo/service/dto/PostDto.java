package com.skill.testing.demo.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skill.testing.demo.facade.model.Post;

public class PostDto {

  private Long id;
  @JsonProperty("user_id")
  private Long userId;
  private String title;
  private String body;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public PostDto(Post post) {
    this.id = post.getId();
    this.userId = post.getUserId();
    this.title = post.getTitle();
    this.body = post.getBody();
  }
}
