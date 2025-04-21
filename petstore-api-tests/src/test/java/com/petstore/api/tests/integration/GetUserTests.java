package com.petstore.api.tests.integration;

import static com.petstore.api.model.UserFactory.createDefaultUser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.petstore.api.client.UserClient;
import com.petstore.api.model.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Get User Tests")
class GetUserTests {
  @Autowired UserClient userClient;

  private final String username = "test_username";
  private User user;

  @BeforeEach
  void setUp() {
    user = createDefaultUser(username);
  }

  @Test
  @DisplayName("Get User by username")
  void getUserByUsername() {
    userClient.createUser(user);
    Response response = userClient.getUser(username);

    assertEquals(200, response.getStatusCode(), "Expected status code 200 for existing user");
    User actualUser = response.as(User.class);

    assertEquals(user.getUsername(), actualUser.getUsername());
    assertEquals(user.getFirstName(), actualUser.getFirstName());
    assertEquals(user.getLastName(), actualUser.getLastName());
    assertEquals(user.getEmail(), actualUser.getEmail());
  }

  @Test
  @DisplayName("Get non existent user")
  void getNonExistentUser() {
    Response response = userClient.getUser("non_existent");
    assertEquals(404, response.getStatusCode(), "Expected status code 404 for non-existent user");
  }
}
