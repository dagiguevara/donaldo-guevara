package com.monefy.automation.drivers;

import com.monefy.automation.config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.options.BaseOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverManager {

  private AppiumDriver driver;

  @Autowired private AppiumConfig config;

  public void createDriver() {
    if ("Android".equalsIgnoreCase(config.getPlatformName())) {
      try {
        driver = new AndroidDriver(new URL(config.getServerUrl()), buildAndroidOptions());
      } catch (MalformedURLException e) {
        throw new RuntimeException("Invalid Appium server URL: " + config.getServerUrl(), e);
      }
    } else {
      throw new UnsupportedOperationException("Only Android is currently supported.");
    }
  }

  private BaseOptions<?> buildAndroidOptions() {
    UiAutomator2Options options = new UiAutomator2Options();

    options.setPlatformName(config.getPlatformName());
    options.setDeviceName(config.getDeviceName());
    options.setAutomationName(config.getAutomationName());
    options.setNoReset(config.isNoReset());
    options.setApp(resolveAppPath(config.getApp()));

    if (config.getAppPackage() != null && config.getAppActivity() != null) {
      options.setAppPackage(config.getAppPackage());
      options.setAppActivity(config.getAppActivity());
    }

    return options;
  }

  private String resolveAppPath(String appPath) {
    return appPath.startsWith("classpath:")
        ? Optional.ofNullable(
                getClass().getClassLoader().getResource(appPath.replace("classpath:", "")))
            .map(url -> Paths.get(url.getPath()).toFile().getAbsolutePath())
            .orElseThrow(() -> new RuntimeException("APK file not found: " + appPath))
        : appPath;
  }

  public AppiumDriver getDriver() {
    if (driver == null) {
      createDriver();
    }
    return driver;
  }

  public void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
