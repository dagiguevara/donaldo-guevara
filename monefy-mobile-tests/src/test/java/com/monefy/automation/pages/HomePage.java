package com.monefy.automation.pages;

import static io.appium.java_client.AppiumBy.id;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

  private final By expenseButton = id("com.monefy.app.lite:id/expense_button");
  private final By incomeButton = id("com.monefy.app.lite:id/income_button");
  private final By balanceAmount = id("com.monefy.app.lite:id/balance_amount");
  private final By searchButton = id("com.monefy.app.lite:id/menu_search");
  private final By searchInput = id("com.monefy.app.lite:id/et_search");
  private final By snackBar = id("com.monefy.app.lite:id/snackbar_text");

  public HomePage(AppiumDriver driver) {
    super(driver);
  }

  @Step("Tap Expense Button")
  public void tapExpenseButton() {
    tap(expenseButton);
  }

  @Step("Tap Income Button")
  public void tapIncomeButton() {
    tap(incomeButton);
  }

  @Step("Tap Search Button")
  public void tapSearchButton() {
    tap(searchButton);
  }

  @Step("Search record")
  public void searchRecord(String input) {
    typeTextAndSubmit(searchInput, input);
  }

  @Step("Verify balance amount")
  public void verifyBalanceAmount(String expectedAmount) {
    String balance = driver.findElement(balanceAmount).getText();
    assertEquals("Balance " + expectedAmount, balance);
  }

  @Step("Verify entry added")
  public void verifyEntryAdded(String category, String expectedAmount) {
    String snackBarMessage = driver.findElement(snackBar).getText();
    assertEquals(category + ": " + expectedAmount + " added", snackBarMessage);
  }
}
