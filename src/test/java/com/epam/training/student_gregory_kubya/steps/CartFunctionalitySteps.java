package com.epam.training.student_gregory_kubya.steps;

import com.epam.training.student_gregory_kubya.pages.CartPage;
import com.epam.training.student_gregory_kubya.pages.MainPage;
import com.epam.training.student_gregory_kubya.pages.ProductPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.assertj.core.api.Assertions;

public class CartFunctionalitySteps extends BaseStepDef{

  MainPage mainPage;
  CartPage cartPage;
  ProductPage productPage;

  public CartFunctionalitySteps() {
    mainPage = new MainPage(driver);
    cartPage = new CartPage(driver);
    productPage = new ProductPage(driver);
  }

  @Given("User is on the home page")
  public void userIsOnTheHomePage() {
    mainPage.openMainPage();
    mainPage.waitMainPageTobeLoaded();
  }

  @When("Add the following products to the cart:")
  public void addTheFollowingProductsToTheCart(DataTable dataTable) {
    List<String> products = dataTable.asList();

    for (String product : products) {
      mainPage.openProductPage(product);
      productPage.addToCart();
    }
  }

  @Then("Cart page is opened")
  public void cartPageIsOpened() {
    cartPage.openCartPage();
  }


  @And("Total value of order on the cart page is equal to {int}")
  public void checkTotalProductsInCart(int totalQuantity) {
    Assertions.assertThat(cartPage.getOrderTotal()).
        as("Order total is not equal").
        isGreaterThan(totalQuantity);
  }

}
