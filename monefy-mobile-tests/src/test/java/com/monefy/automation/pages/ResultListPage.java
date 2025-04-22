package com.monefy.automation.pages;

import static io.appium.java_client.AppiumBy.id;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ResultListPage extends BasePage {

  private final By noteView = id("com.monefy.app.lite:id/note_text_view");
  private final By titleView = id("com.monefy.app.lite:id/title_text_view");
  private final By amountView = id("com.monefy.app.lite:id/amount_text_view");

  public ResultListPage(AppiumDriver driver) {
    super(driver);
  }

  public void verifySearchRecord(String title, String amount, String note) {
    assertEquals(getElementText(titleView), title);
    assertEquals(getElementText(amountView), amount);
    assertEquals(getElementText(noteView), note);
  }
}
