package com.epam.training.student_gregory_kubya.steps;


import com.epam.training.student_gregory_kubya.driver.WebDriverProvider;
import com.epam.training.student_gregory_kubya.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class SearchFunctionSteps {

  MainPage mainPage;

  public SearchFunctionSteps() {
    WebDriver driver = WebDriverProvider.getDriver();
    mainPage = new MainPage(driver);
  }

  @Given("User is at the homepage")
  public void userIsOnTheHomepage() {
    mainPage.openMainPage();
    mainPage.waitMainPageTobeLoaded();
  }

  @When("Search for product {string}")
  public void searchForProduct(String string) {

    mainPage.searchForValue(string);
  }

  @Then("The number of available items should be greater than {int}")
  public void the_number_of_available_items_should_be_greater_than(Integer int1) {
    Assertions.assertThat(
            mainPage.getSearchResultQuantity()).
        as("Check search result quantity").
        isGreaterThan(int1);
  }


}
