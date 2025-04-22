package com.monefy.automation.config;

import com.monefy.automation.drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverProvider {

  @Autowired private DriverManager driverManager;

  @Bean
  public AppiumDriver appiumDriver() {
    return driverManager.getDriver();
  }
}
