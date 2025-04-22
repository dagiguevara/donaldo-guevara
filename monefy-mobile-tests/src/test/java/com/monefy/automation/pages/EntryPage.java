package com.monefy.automation.pages;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EntryPage extends BasePage {

  private final By noteTextView = id("com.monefy.app.lite:id/textViewNote");
  private final By chooseCategoryButton =
      androidUIAutomator(
          "new UiSelector().resourceId(\"com.monefy.app.lite:id/keyboard_action_button\").textContains(\"CHOOSE CATEGORY\")");

  @Step("Create entry")
  public void createEntry(String amount, String note, String category) {
    enterAmount(amount);
    typeText(noteTextView, note);
    tap(chooseCategoryButton);
    tap(categoryByName(category));
  }

  private void enterAmount(String digits) {
    for (char digit : digits.toCharArray()) {
      tap(id("com.monefy.app.lite:id/buttonKeyboard" + digit));
    }
  }

  private By categoryByName(String categoryName) {
    return androidUIAutomator(String.format("new UiSelector().text(\"%s\")", categoryName));
  }

  public EntryPage(AppiumDriver driver) {
    super(driver);
  }
}
