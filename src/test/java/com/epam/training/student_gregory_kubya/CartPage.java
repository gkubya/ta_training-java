package com.epam.training.student_gregory_kubya;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

  private final WebDriver driver;
  private static final String PAGE_URL = "https://fiftyoutlet.com/es/es/cart";


  @FindAll({@FindBy(css = "div.name.product-name")})
  List<WebElement> cartNameList;
  @FindAll({@FindBy(css = "div.sku.product-ref")})
  List<WebElement> cartReferenceList;
  @FindAll({@FindBy(css = ".price-total")})
  List<WebElement> cartPriceList;
  @FindAll({@FindBy(css = ".item-quantity>.input-text")})
  List<WebElement> cartQuantityList;

  @FindBy(css = ".order-subtotal>.order-totals-value")
  private WebElement orderTotal;


  public CartPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }


  public void openCartPage() {
    driver.get(PAGE_URL);
  }

  public List<String> productNamesOnCart() {
    return cartNameList.stream()
        .map(WebElement::getText)
        .toList();
  }

  public double getOrderTotal() {
    return Double.parseDouble(orderTotal.getText()
        .replaceAll("\\s|€", "").replace(",", "."));
  }

  public ArrayList<ProductDTO> cartProducts() {

    ArrayList<ProductDTO> productCartList = new ArrayList<>();
    for (int i = 0; i < cartNameList.size(); i++) {
      String name = cartNameList.get(i).getText();
      String refString = cartReferenceList.get(i).getText()
          .replaceAll("[^0-9]", "");
      int referenceNumber = Integer.parseInt(refString.substring(0, refString.length() - 4));
      double price = Double.parseDouble(cartPriceList.get(i).getText()
          .replaceAll("\\s|€", "").replace(",", "."));
      int quantity = Integer.parseInt(cartQuantityList.get(i).getAttribute("value"));
      ProductDTO product = new ProductDTO(referenceNumber, name, price, quantity);
      productCartList.add(product);
    }
    return productCartList;
  }

}
