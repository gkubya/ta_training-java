package com.epam.training.student_gregory_kubya.tests;

import com.epam.training.student_gregory_kubya.driver.WebDriverProvider;
import com.epam.training.student_gregory_kubya.pages.CartPage;
import com.epam.training.student_gregory_kubya.pages.MainPage;
import com.epam.training.student_gregory_kubya.pages.ProductPage;
import com.epam.training.student_gregory_kubya.utils.MyTestWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(MyTestWatcher.class)
public class CommonConditions {

  public static MainPage mainPage;
  public static ProductPage productPage;
  public static CartPage cartPage;

  @BeforeAll
  public static void setUp() {
    WebDriver driver = WebDriverProvider.getDriver();
    mainPage = new MainPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
  }

  @BeforeEach
  public void openHomePage() {
    mainPage.openMainPage();
    mainPage.waitMainPageTobeLoaded();
  }

  @AfterEach
  public void tearDown() {
    WebDriverProvider.closeDriver();
  }

}
