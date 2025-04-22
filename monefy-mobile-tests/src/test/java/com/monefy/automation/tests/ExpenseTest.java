package com.monefy.automation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExpenseTest extends BaseTest {

  @BeforeEach
  void completeOnboarding() {
    onboarding.completeOnBoarding();
  }

  @Test
  @DisplayName("Test Expense Creation")
  void testExpenseCreation() {
    String category = "Bills";
    String expectedAmount = "$25.00";
    homePage.tapExpenseButton();
    entryPage.createEntry("25", "This is an Expense", category);
    homePage.verifyBalanceAmount("-" + expectedAmount);
    homePage.verifyEntryAdded(category, expectedAmount);
  }
}
