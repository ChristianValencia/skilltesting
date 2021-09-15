package com.skill.testing.demo.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.skill.testing.demo.models.PostsData;
import com.skill.testing.demo.models.TodosData;
import com.skill.testing.demo.models.TodosModel;
import com.skill.testing.demo.models.UserData;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/")
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.NONE)
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    String url = "https://gorest.co.in/public/v1/";

    @GetMapping("/users")
    public Object users() {
        ResponseEntity<?> response = restTemplate.exchange(url + "/users", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        Map<?, ?> responseData = (Map<?, ?>) response.getBody();
        assert responseData != null;
        List<UserData> data = (List<UserData>) responseData.get("data");
        return data;
    }
    @GetMapping("/users/{id}")
    public Object usersId(@PathVariable(value = "id")Long id) {
        ResponseEntity<UserData> users = restTemplate.getForEntity(url + "/users/" + id, UserData.class);
        return Objects.requireNonNull(users.getBody()).getData();
    }

    @GetMapping("/users/{id}/overAllInfo")
    public Object usersOverAllInfo(@PathVariable(value = "id")Long id) {
        ResponseEntity<UserData> users = restTemplate.getForEntity(url + "/users/" + id, UserData.class);
        ResponseEntity<PostsData> posts = restTemplate.getForEntity(url + "/users/" + id + "/posts", PostsData.class);
        ResponseEntity<TodosData> todos = restTemplate.getForEntity(url + "/users/" + id + "/todos", TodosData.class);

        JSONArray object = new JSONArray();
        ArrayList<TodosModel> todosListLatest = new ArrayList<>();
        JSONObject additional = new JSONObject();

        object.put(0 , Objects.requireNonNull(users.getBody()).getData());
        int i = 0;
        while (i< Objects.requireNonNull(todos.getBody()).getData().length) {
            if(i+1 == Arrays.stream(todos.getBody().getData()).count()){
                todosListLatest.add(0, todos.getBody().getData()[i]);
            }
            i++;
        }
        additional.put("latestTodo", todosListLatest);
        additional.put("posts", Objects.requireNonNull(posts.getBody()).getData());
        object.put(additional);
        return object.toList();
    }

    @GetMapping("/todos")
    public Object todos() {
        ResponseEntity<TodosData> todos = restTemplate.getForEntity(url + "/todos", TodosData.class);
        return Objects.requireNonNull(todos.getBody()).getData();
    }

    @GetMapping("/posts")
    public Object posts() {
        ResponseEntity<PostsData> posts = restTemplate.getForEntity(url + "/posts", PostsData.class);
        return Objects.requireNonNull(posts.getBody()).getData();
    }


}
