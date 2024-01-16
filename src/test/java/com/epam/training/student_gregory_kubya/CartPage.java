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
  List<WebElement> productNamesOnCart;
  @FindAll({@FindBy(css = "div[class='sku product-ref'] span[class='value']")})
  List<WebElement> referenceNumbersOnCart;
  @FindAll({@FindBy(css = ".price-total")})
  List<WebElement> productsPricesOnCart;
  @FindAll({@FindBy(css = ".item-quantity>.input-text")})
  List<WebElement> quantityOfItemsCart;

  @FindBy(css = ".order-subtotal>.order-totals-value")
  private WebElement orderTotal;


  public CartPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void openCartPage() {
    driver.get(PAGE_URL);
  }

  public List<String> getProductNamesOnCart() {
    return productNamesOnCart.stream()
        .map(WebElement::getText).toList();
  }

  public double getOrderTotal() {
    return PriceUtil.convertEuro(orderTotal.getText());
  }

  public List<ProductDTO> getProductListFromCartPage() {

    List<ProductDTO> getListOfAllProductsOnCartPage = new ArrayList<>();
    for (int i = 0; i < productNamesOnCart.size(); i++) {
      String name = productNamesOnCart.get(i).getText();
      int referenceNumber = Integer.parseInt(referenceNumbersOnCart.get(i).getText()
          .substring(0, referenceNumbersOnCart.get(i).getText().length() - 4));
      double price = PriceUtil.convertEuro(productsPricesOnCart.get(i).getText());
      int quantity = Integer.parseInt(quantityOfItemsCart.get(i).getAttribute("value"));
      ProductDTO product = new ProductDTO(referenceNumber, name, price, quantity);
      getListOfAllProductsOnCartPage.add(product);
    }
    return getListOfAllProductsOnCartPage;
  }

}
