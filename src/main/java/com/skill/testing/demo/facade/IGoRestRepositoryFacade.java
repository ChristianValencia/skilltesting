package com.skill.testing.demo.facade;

import com.skill.testing.demo.facade.model.Post;
import com.skill.testing.demo.facade.model.Todo;
import com.skill.testing.demo.facade.model.User;
import java.util.List;

public interface IGoRestRepositoryFacade {

  List<User> getAllUser();

  User getUserById(Long idUser);

  List<Post> getAllPost();

  List<Todo> getAllTodo();

  List<Post> getPostByUser(Long idUser);

  List<Todo> getTodoByUser(Long idUser);

}
