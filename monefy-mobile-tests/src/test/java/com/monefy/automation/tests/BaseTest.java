package com.monefy.automation.tests;

import com.monefy.automation.TestAutomationApp;
import com.monefy.automation.drivers.DriverManager;
import com.monefy.automation.pages.EntryPage;
import com.monefy.automation.pages.HomePage;
import com.monefy.automation.pages.Onboarding;
import com.monefy.automation.pages.ResultListPage;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestAutomationApp.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

  protected AppiumDriver driver;
  protected HomePage homePage;
  protected Onboarding onboarding;
  protected EntryPage entryPage;
  protected ResultListPage resultListPage;

  @Autowired DriverManager driverManager;

  @BeforeEach
  public void setUp() {
    driverManager.createDriver();
    driver = driverManager.getDriver();

    homePage = new HomePage(driver);
    onboarding = new Onboarding(driver);
    entryPage = new EntryPage(driver);
    resultListPage = new ResultListPage(driver);
  }

  @AfterEach
  public void tearDown() {
    driverManager.quitDriver();
  }
}
