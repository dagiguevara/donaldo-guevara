package com.petstore.api.client;

import com.petstore.api.model.User;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class UserClient extends BaseClient {

  private static final String USER_PATH = "/user";

  public Response createUser(User user) {
    return post(USER_PATH, user);
  }

  public Response updateUser(String username, User user) {
    return put(USER_PATH + "/" + username, user);
  }

  public Response getUser(String username) {
    return get(USER_PATH + "/" + username);
  }

  public Response deleteUser(String username) {
    return delete(USER_PATH + "/" + username);
  }
}
