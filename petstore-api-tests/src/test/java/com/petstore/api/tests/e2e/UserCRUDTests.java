package com.petstore.api.tests.e2e;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.petstore.api.client.UserClient;
import com.petstore.api.model.User;
import com.petstore.api.model.UserFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("CRUD User Tests")
class UserCRUDTests {

  @Autowired UserClient userClient;

  @Test
  @DisplayName("Perform CRUD operation successfully")
  void performCrudOperationSuccessfully() {
    // Create user
    String username = "test_username";
    User user = UserFactory.createDefaultUser(username);

    Response createResponse = userClient.createUser(user);
    assertEquals(200, createResponse.statusCode(), "Create user failed");

    // Get user
    Response getResponse = userClient.getUser(username);
    assertEquals(200, getResponse.statusCode(), "Get User failed");
    User fetchedUser = getResponse.as(User.class);
    assertEquals(user.getUsername(), fetchedUser.getUsername());
    assertEquals(user.getFirstName(), fetchedUser.getFirstName());

    // Update user
    user.setFirstName("updated_user");
    user.setEmail("updated_email@test.com");

    Response updateResponse = userClient.updateUser(username, user);
    assertEquals(200, updateResponse.statusCode(), "Update user failed");

    // Get updated user
    Response getUpdatedResponse = userClient.getUser(username);
    assertEquals(200, getUpdatedResponse.statusCode(), "Get after update failed");
    User updatedUser = getUpdatedResponse.as(User.class);
    assertEquals("updated_user", updatedUser.getFirstName());
    assertEquals("updated_email@test.com", updatedUser.getEmail());

    // Delete user
    Response deleteResponse = userClient.deleteUser(username);
    assertEquals(200, deleteResponse.statusCode(), "Delete user failed");

    // Verify user is deleted
    Response getAfterDelete = userClient.getUser(username);
    assertEquals(404, getAfterDelete.statusCode(), "User still exists after deletion");
  }
}
