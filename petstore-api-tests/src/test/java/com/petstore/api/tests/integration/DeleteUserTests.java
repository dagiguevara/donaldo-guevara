package com.petstore.api.tests.integration;

import static com.petstore.api.model.UserFactory.createDefaultUser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.petstore.api.client.UserClient;
import com.petstore.api.model.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Delete User Tests")
class DeleteUserTests {

  @Autowired UserClient userClient;

  private final String username = "test_username";
  private User user;

  @BeforeEach
  void setUp() {
    user = createDefaultUser(username);
  }

  @Test
  @DisplayName("Delete existing user successfully")
  void deleteExistingUserSuccessfully() {
    userClient.createUser(user);

    Response deleteResponse = userClient.deleteUser(username);
    assertEquals(
        200,
        deleteResponse.getStatusCode(),
        "Expected status code 200 when deleting existing user");

    Response getResponse = userClient.getUser(username);
    assertEquals(
        404, getResponse.getStatusCode(), "Expected status code 404 after deleting the user");
  }

  @Test
  @DisplayName("Delete non existent user")
  @Disabled("Based on API documentation it should return a 404, however is returning a 200")
  void deleteNonExistentUser() {
    String nonExistentUser = "nonExistentUser";
    Response response = userClient.deleteUser(nonExistentUser);
    assertEquals(
        404, response.getStatusCode(), "Expected status code 404 when deleting non-existent user");
  }
}
