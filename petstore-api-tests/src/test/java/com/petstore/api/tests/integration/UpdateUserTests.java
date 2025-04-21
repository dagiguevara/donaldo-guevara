package com.petstore.api.tests.integration;

import static com.petstore.api.model.UserFactory.createDefaultUser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.petstore.api.client.UserClient;
import com.petstore.api.model.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Update User Tests")
class UpdateUserTests {

  @Autowired UserClient userClient;

  private final String username = "test_username";
  private User user;
  private boolean wasUserCreated = false;

  @BeforeEach
  void setUp() {
    user = createDefaultUser(username);
  }

  @AfterEach
  void tearDown() {
    if (wasUserCreated) {
      userClient.deleteUser(username);
    }
  }

  @Test
  @DisplayName("Update existing user")
  void updateExistingUser() {
    userClient.createUser(user);
    wasUserCreated = true;

    user.setFirstName("Updated_First_Name");
    user.setLastName("Updated_Last_Name");
    user.setEmail("updated@test.com");

    Response updateResponse = userClient.updateUser(username, user);

    assertEquals(
        200, updateResponse.statusCode(), "Expected status code 200 for successful update");

    Response getResponse = userClient.getUser(username);
    User updatedUser = getResponse.as(User.class);

    assertEquals("Updated_First_Name", updatedUser.getFirstName());
    assertEquals("Updated_Last_Name", updatedUser.getLastName());
    assertEquals("updated@test.com", updatedUser.getEmail());
  }

  @Test
  @DisplayName("Update non existent user")
  void updateNonExistentUser() {
    Response updateResponse = userClient.updateUser("non_existent", user);
    assertEquals(404, updateResponse.statusCode());
  }
}
