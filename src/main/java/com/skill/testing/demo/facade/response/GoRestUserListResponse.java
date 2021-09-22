package com.skill.testing.demo.facade.response;

import com.skill.testing.demo.facade.model.User;
import java.util.List;

public class GoRestUserListResponse extends GoRestResponse {
  private List<User> data;

  public List<User> getData() {
    return data;
  }

  public void setData(List<User> data) {
    this.data = data;
  }
}
