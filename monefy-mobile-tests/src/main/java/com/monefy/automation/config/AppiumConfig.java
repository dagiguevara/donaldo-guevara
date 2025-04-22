package com.monefy.automation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "appium")
public class AppiumConfig {
  private String platformName;
  private String deviceName;
  private String automationName;
  private String app;
  private String appActivity;
  private String appPackage;
  private boolean noReset;
  private String serverUrl;

  public String getPlatformName() {
    return platformName;
  }

  public void setPlatformName(String platformName) {
    this.platformName = platformName;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getAutomationName() {
    return automationName;
  }

  public void setAutomationName(String automationName) {
    this.automationName = automationName;
  }

  public String getApp() {
    return app;
  }

  public void setApp(String app) {
    this.app = app;
  }

  public String getAppPackage() {
    return appPackage;
  }

  public void setAppPackage(String appPackage) {
    this.appPackage = appPackage;
  }

  public String getAppActivity() {
    return appActivity;
  }

  public void setAppActivity(String appActivity) {
    this.appActivity = appActivity;
  }

  public boolean isNoReset() {
    return noReset;
  }

  public void setNoReset(boolean noReset) {
    this.noReset = noReset;
  }

  public String getServerUrl() {
    return serverUrl;
  }

  public void setServerUrl(String serverUrl) {
    this.serverUrl = serverUrl;
  }
}
