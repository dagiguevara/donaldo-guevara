package com.petstore.api.model;

public class UserFactory {

  public static User createDefaultUser(String username) {
    return User.builder()
        .id(System.currentTimeMillis())
        .username(username)
        .firstName("Default")
        .lastName("User")
        .email(username + "@test.com")
        .password("password123")
        .phone("1231231234")
        .userStatus(1)
        .build();
  }

  public static User createCustomUser(String username, String firstName, String lastName) {
    return User.builder()
        .id(System.currentTimeMillis())
        .username(username)
        .firstName(firstName)
        .lastName(lastName)
        .email(username + "@test.com")
        .password("password")
        .phone("1231231234")
        .userStatus(1)
        .build();
  }
}
