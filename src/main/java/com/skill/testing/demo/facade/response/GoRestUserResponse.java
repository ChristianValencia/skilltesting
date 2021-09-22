package com.skill.testing.demo.facade.response;

import com.skill.testing.demo.facade.model.User;

public class GoRestUserResponse extends GoRestResponse {


  private User data;


  public User getData() {
    return data;
  }

  public void setData(User data) {
    this.data = data;
  }
}
