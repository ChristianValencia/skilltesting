package com.skill.testing.demo.service.dto;

import com.skill.testing.demo.facade.model.User;

public class UserDto {
  private Long id;
  private String name;
  private String email;
  private String gender;
  private String status;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public UserDto(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.gender = user.getGender();
    this.status = user.getStatus();
  }
}
