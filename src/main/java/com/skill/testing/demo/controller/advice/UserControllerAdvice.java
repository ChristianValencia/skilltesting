package com.skill.testing.demo.controller.advice;

import com.skill.testing.demo.controller.UserController;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice(assignableTypes = {UserController.class})
public class UserControllerAdvice {


  @ExceptionHandler(HttpClientErrorException.class)
  public ResponseEntity<Object> controlHttpClientException(HttpClientErrorException e) {
    e.printStackTrace();
    return ResponseEntity.status(e.getStatusCode()).body(processResponse(e.getResponseBodyAsString()));

  }

  private Object processResponse(String response) {
    JSONParser parser = new JSONParser(response);
    try {
      return parser.parse();
    } catch (ParseException e) {
      return "Error while trying execute GoRestApi";
    }
  }
}
