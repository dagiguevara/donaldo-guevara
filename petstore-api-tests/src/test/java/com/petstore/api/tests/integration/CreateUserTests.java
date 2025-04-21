package com.petstore.api.tests.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.petstore.api.client.UserClient;
import com.petstore.api.model.User;
import com.petstore.api.model.UserFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Create User Tests")
class CreateUserTests {

  @Autowired UserClient userClient;

  private final String username = "test_username";
  private User user;

  @BeforeEach
  void setUp() {
    user = UserFactory.createCustomUser(username, "Test", "User");
  }

  @AfterEach
  void tearDown() {
    userClient.deleteUser(username);
  }

  @Test
  @DisplayName("Create User Successfully")
  void createUserSuccessfully() {
    Response createResponse = userClient.createUser(user);
    assertEquals(200, createResponse.getStatusCode());

    Response getResponse = userClient.getUser(username);
    assertEquals(200, getResponse.getStatusCode());

    User actualUser = getResponse.as(User.class);
    assertEquals(user.getUsername(), actualUser.getUsername());
    assertEquals(user.getFirstName(), actualUser.getFirstName());
    assertEquals(user.getLastName(), actualUser.getLastName());
    assertEquals(user.getEmail(), actualUser.getEmail());
  }
}
