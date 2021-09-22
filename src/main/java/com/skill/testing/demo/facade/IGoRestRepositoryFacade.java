package com.skill.testing.demo.facade;

import com.skill.testing.demo.facade.model.Post;
import com.skill.testing.demo.facade.model.Todo;
import com.skill.testing.demo.facade.model.User;
import java.util.List;

public interface IGoRestRepositoryFacade {

  List<User> getAllUsers();

  User getUserById(Long userId);

  List<Post> getAllPosts();

  List<Todo> getAllTodos();

  List<Post> getPostByUser(Long userId);

  List<Todo> getTodoByUser(Long userId);

}
