package com.epam.training.student_gregory_kubya;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainPageTest {


  private static WebDriver driver;
  private static MainPage mainPage;

  @BeforeAll
  public static void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    mainPage = new MainPage(driver);
  }

  @BeforeEach
  public void openHomePage() {
    mainPage.openMainPage();
    mainPage.checkMainPageIsLoaded();
    mainPage.acceptCookies();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void checkSearchResultQuantity() {

    mainPage.searchForValue("abrigo");

    Assertions.assertThat(mainPage.getSearchResultQuantity())
        .as("The search result quantity does not meed the minimum criteria")
        .isGreaterThan(300);
  }
}
