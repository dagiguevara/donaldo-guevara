package com.petstore.api.client;

import com.petstore.api.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseClient {

  @Autowired private ApiConfig apiConfig;

  protected RequestSpecification requestSpec() {
    return RestAssured.given()
        .baseUri(apiConfig.getBaseUri())
        .header("Content-Type", apiConfig.getContentType())
        .log()
        .all();
  }

  protected Response post(String path, Object body) {
    return requestSpec().body(body).when().post(path).then().log().all().extract().response();
  }

  protected Response put(String path, Object body) {
    return requestSpec().body(body).when().put(path).then().log().all().extract().response();
  }

  protected Response get(String path) {
    return requestSpec().when().get(path).then().log().all().extract().response();
  }

  protected Response delete(String path) {
    return requestSpec().when().delete(path).then().log().all().extract().response();
  }
}
