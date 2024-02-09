package com.epam.training.student_gregory_kubya.hooks;

import static com.epam.training.student_gregory_kubya.driver.DriverSingleton.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {

  @Before
  public void setUp(Scenario sc) {

    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
    driver.get("https://fiftyoutlet.com/");
    driver.manage().addCookie(new Cookie(
        "OptanonAlertBoxClosed",
        "2024-02-07T18:45:38.694Z"));
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

}
