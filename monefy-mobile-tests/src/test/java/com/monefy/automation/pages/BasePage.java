package com.monefy.automation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  protected AppiumDriver driver;

  protected AndroidDriver androidDriver = (AndroidDriver) driver;

  public BasePage(AppiumDriver driver) {
    this.driver = driver;
  }

  private WebElement waitUntilClickable(By locator, int timeout) {
    return new WebDriverWait(driver, Duration.ofSeconds(timeout))
        .until(ExpectedConditions.elementToBeClickable(locator));
  }

  protected WebElement waitUntilDisappear(By locator, int timeoutSeconds) {
    return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
        .until(ExpectedConditions.elementToBeClickable(locator));
  }

  protected void tap(By locator) {
    waitUntilClickable(locator, 10).click();
  }

  protected void tap(By locator, int timeout) {
    waitUntilClickable(locator, timeout).click();
  }

  protected void typeText(By locator, String text) {
    driver.findElement(locator).sendKeys(text);
  }

  protected void typeTextAndSubmit(By locator, String text) {
    driver.findElement(locator).sendKeys(text);
    if (driver instanceof AndroidDriver) {
      ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }
  }

  protected String getElementText(By locator) {
    return driver.findElement(locator).getText();
  }
}
