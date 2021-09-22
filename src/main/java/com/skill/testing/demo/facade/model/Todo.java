package com.skill.testing.demo.facade.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Todo {

  private Long id;
  @JsonProperty("user_id")
  private Long userId;
  private String title;
  @JsonProperty("due_on")
  private Date dueOn;
  private String status;

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

  public Date getDueOn() {
    return dueOn;
  }

  public void setDueOn(Date dueOn) {
    this.dueOn = dueOn;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
