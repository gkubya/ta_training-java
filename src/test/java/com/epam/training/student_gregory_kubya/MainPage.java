package com.epam.training.student_gregory_kubya;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//
public class MainPage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  String pageURL = "https://fiftyoutlet.com/";

  @FindBy(id = "onetrust-accept-btn-handler")
  public WebElement acceptCookieButton;

  @FindBy(css = "div.navigation.navigation-search")
  public WebElement searchButton;

  @FindBy(css = ".gi-search-search-input")
  public WebElement searchField;

  public void searchForValue(String value) {
    this.searchField.sendKeys(value);
    this.searchField.sendKeys(Keys.ENTER);
  }

  public int getSearchResultQuantity() {
    WebElement element = this.driver.findElement(By.cssSelector("div[data-dl-search-count]"));
    return Integer.parseInt(element.getAttribute("data-dl-search-count"));
  }

  public MainPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  protected void openMainPage() {
    driver.get(pageURL);
  }

  public void checkMainPageIsLoaded() {
    wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
  }
}
