package com.monefy.automation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IncomeTest extends BaseTest {

  @BeforeEach
  void completeOnboarding() {
    onboarding.completeOnBoarding();
  }

  @Test
  @DisplayName("Test Income Creation")
  void testIncomeCreation() {
    String category = "Salary";
    String expectedAmount = "$25.00";
    homePage.tapIncomeButton();
    entryPage.createEntry("25", "This is an income", category);
    homePage.verifyBalanceAmount(expectedAmount);
    homePage.verifyEntryAdded(category, expectedAmount);
  }
}
