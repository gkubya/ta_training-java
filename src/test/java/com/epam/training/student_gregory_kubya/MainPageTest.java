package com.epam.training.student_gregory_kubya;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
  private static ProductPage productPage;
  private static CartPage cartPage;

  @BeforeAll
  public static void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    mainPage = new MainPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);

  }

  @BeforeEach
  public void openHomePage() {
    mainPage.openMainPage();
    mainPage.waitMainPageTobeLoaded();
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
        .as("Check search result quantity")
        .isGreaterThan(300);
  }

  @Test
  public void checkMultipleItemsInCart() {
    List<ProductDTO> productList = new ArrayList<>();
    List<String> productsReferences = Arrays.asList("3687009", "9006113", "3856253");
    for (String productReference : productsReferences) {
      mainPage.openProductPage(productReference);
      productPage.addToCart();
      productList.add(productPage.createProductObject());
    }
    cartPage.openCartPage();

    Assertions.assertThat(cartPage.productNamesOnCart())
        .as("Product not found in cart")
        .containsAll(productList.stream().map(ProductDTO::getName).toList());
    Assertions.assertThat(cartPage.getOrderTotal())
        .as("Order total is not equal")
        .isEqualTo(productList.stream().mapToDouble(ProductDTO::getPrice).sum());
    Assertions.assertThat(cartPage.cartProducts())
        .as("ProductDTO not found in cart")
        .containsAll(productList);
  }
}
