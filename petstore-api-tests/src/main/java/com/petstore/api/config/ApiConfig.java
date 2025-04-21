package com.petstore.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
public class ApiConfig {
  private String baseUri;
  private String contentType;

  public String getBaseUri() {
    return baseUri;
  }

  public void setBaseUri(String baseUri) {
    this.baseUri = baseUri;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }
}
