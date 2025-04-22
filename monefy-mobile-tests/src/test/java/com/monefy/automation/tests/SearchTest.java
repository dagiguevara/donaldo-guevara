package com.monefy.automation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SearchTest extends BaseTest {

  @BeforeEach
  void addExpense() {
    onboarding.completeOnBoarding();
    homePage.tapExpenseButton();
    entryPage.createEntry("20", "Dinner Berlin", "Eating out");
    homePage.tapExpenseButton();
  }

  @ParameterizedTest(name = "Search with input: {0}")
  @ValueSource(strings = {"Dinner", "Eating out", "20"})
  void testSearchRecord(String keyword) {
    homePage.tapSearchButton();
    homePage.searchRecord(keyword);
    resultListPage.verifySearchRecord("Eating out", "$20.00", "Dinner Berlin");
  }
}
