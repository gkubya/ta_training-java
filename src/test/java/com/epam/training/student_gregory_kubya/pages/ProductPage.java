package com.epam.training.student_gregory_kubya.pages;


import com.epam.training.student_gregory_kubya.ProductDTO;
import com.epam.training.student_gregory_kubya.utils.PriceUtil;
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


  @FindBy(css = "div.productReference")
  private WebElement productReferenceNumber;

  @FindBy(css = ".js-product-name")
  private WebElement productName;

  @FindBy(css = "div .scope_pdpSideBar> span.js-product-price.priceItem")
  private WebElement productPrice;

  @FindBy(css = "label[for='mainSizeIDM']")
  private WebElement productMediumSizeButton;

  @FindBy(css = ".js-addToCartButton.addToCartButton")
  private WebElement addToCartButton;

  @FindBy(css = "div[class*='dialogClose']")
  private WebElement dialogCloseButton;


  public ProductPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(2));
  }

  private int getProductReferenceCodeFromProductPage() {
    wait.until(ExpectedConditions.visibilityOf(productReferenceNumber));
    return Integer.parseInt(productReferenceNumber.getText().replaceAll("\\D", ""));
  }

  public ProductDTO createProductObject() {
    int referenceNumber = getProductReferenceCodeFromProductPage();
    String name = productName.getText();
    double price = PriceUtil.parseEuroValue(productPrice.getText());
    int quantity = 1;

    return ProductDTO.builder().referenceNumber(referenceNumber).name(name).price(price)
        .quantity(quantity).build();
  }

  public void addToCart() {
    wait.until(ExpectedConditions.elementToBeClickable(productMediumSizeButton));
    productMediumSizeButton.click();
    addToCartButton.click();

    try {
      wait.until(ExpectedConditions.elementToBeClickable(dialogCloseButton));
      if (dialogCloseButton.isEnabled()) {
        this.dialogCloseButton.click();
      }
    } catch (TimeoutException e) {
      System.out.println("Close cart Button Not Found");
    }
  }
}
