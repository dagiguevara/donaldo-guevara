package com.monefy.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Onboarding extends BasePage {
  public Onboarding(AppiumDriver driver) {
    super(driver);
  }

  private final By getStartedButton = buttonWithText("GET STARTED");
  private final By amazingButton = buttonWithText("AMAZING");
  private final By iAmReadyButton = buttonWithText("I’M READY");

  private final By closeButton = AppiumBy.id("com.monefy.app.lite:id/buttonClose");

  @Step("Complete OnBoarding")
  public void completeOnBoarding() {
    tap(getStartedButton);
    tap(amazingButton);
    tap(iAmReadyButton);
    tap(closeButton);
  }

  private By buttonWithText(String text) {
    return AppiumBy.androidUIAutomator(
        String.format(
            "UiSelector().resourceId(\"com.monefy.app.lite:id/buttonContinue\").textContains(\"%s\")",
            text));
  }
}
