package com.epam.training.student_gregory_kubya;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainPageTest {

  private WebDriver driver;
  private MainPage mainPage;


  @BeforeEach
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://fiftyoutlet.com/");

    mainPage = new MainPage(driver);
    mainPage.acceptCookieButton.click();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void checkSearchResultQuantity() {

    mainPage.searchButton.click();
    mainPage.searchForValue("abrigo");

    assertTrue(400 < mainPage.getSearchResultQuantity());
  }
}
