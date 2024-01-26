package com.epam.training.student_gregory_kubya;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {

  private final WebDriver driver;
  private static final String PAGE_URL = "https://fiftyoutlet.com/";
  private final WebDriverWait wait;

  @FindBy(id = "onetrust-accept-btn-handler")
  private WebElement acceptCookieButton;

  @FindBy(css = "div.navigation.navigation-search")
  private WebElement searchFieldOpener;

  @FindBy(css = ".gi-search-search-input")
  private WebElement searchField;

  @FindBy(css = "div[data-dl-search-count]")
  private WebElement searchCount;

  @FindBy(className = "search-button-icon")
  private WebElement searchButton;



  public void searchForValue(String value) {
    this.searchFieldOpener.click();
    wait.until(ExpectedConditions.elementToBeClickable(searchButton));
    this.searchField.sendKeys(value);
    this.searchField.sendKeys(Keys.ENTER);
  }

  public void openProductPage(String value) {
    driver.get(PAGE_URL + "es/es/" + value + ".html");
  }

  public int getSearchResultQuantity() {
    return Integer.parseInt(searchCount.getAttribute("data-dl-search-count"));
  }

  public MainPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(2));

  }

  protected void openMainPage() {
    driver.get(PAGE_URL);
  }

  public void waitMainPageTobeLoaded() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(searchFieldOpener));
  }

  public void acceptCookies() {
    try {
      wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
      if (acceptCookieButton.isEnabled()) {
        this.acceptCookieButton.click();
      }
    } catch (TimeoutException e) {
      System.out.println("Cookie already accepted or button not found");
    }
  }
}
