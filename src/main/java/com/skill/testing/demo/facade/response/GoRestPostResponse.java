package com.skill.testing.demo.facade.response;

import com.skill.testing.demo.facade.model.Post;
import java.util.List;

public class GoRestPostResponse extends GoRestResponse {


  private List<Post> data;


  public List<Post> getData() {
    return data;
  }

  public void setData(List<Post> data) {
    this.data = data;
  }
}
