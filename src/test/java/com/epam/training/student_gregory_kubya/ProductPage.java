package com.epam.training.student_gregory_kubya;


import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage {

  private final WebDriverWait wait;


  @FindBy(css = ".js-product-reference")
  private WebElement productReferenceNumber;

  @FindBy(css = ".js-product-name")
  private WebElement productName;

  @FindBy(css = "div .scope_pdpSideBar> span.js-product-price.priceItem")
  private WebElement productPrice;

  @FindBy(css = "label[for='size_M']")
  private WebElement sizeMButton;

  @FindBy(css = ".js-add-to-cart-button.gi-add-to-bag-desktop")
  private WebElement addToCartButton;

  @FindBy(css = ".js-dialog-btnClose.gi-minicart-close")
  private WebElement closeCartButton;


  public ProductPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(2));
  }

  public ProductDTO createProductObject() {
    int referenceNumber = Integer.parseInt(
        productReferenceNumber.getText().replaceAll("[^0-9]", ""));
    String name = productName.getText();
    double price = Double.parseDouble(
        productPrice.getText().replaceAll("\\s|€", "").replace(",", "."));
    int quantity = 1;

    return new ProductDTO(referenceNumber, name, price, quantity);
  }

  public void addToCart() {
    wait.until(ExpectedConditions.elementToBeClickable(sizeMButton));
    sizeMButton.click();
    addToCartButton.click();

    try {
      wait.until(ExpectedConditions.elementToBeClickable(closeCartButton));
      if (closeCartButton.isEnabled()) {
        this.closeCartButton.click();
      }
    } catch (TimeoutException e) {
      System.out.println("Close cart Button Not Found");
    }
  }
}
