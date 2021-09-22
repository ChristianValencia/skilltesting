package com.skill.testing.demo.facade.response;

import com.skill.testing.demo.facade.model.Todo;
import java.util.List;

public class GoRestTodoResponse extends GoRestResponse {


  private List<Todo> data;


  public List<Todo> getData() {
    return data;
  }

  public void setData(List<Todo> data) {
    this.data = data;
  }
}
