package com.epam.training.student_gregory_kubya.tests;

import com.epam.training.student_gregory_kubya.ProductDTO;
import com.epam.training.student_gregory_kubya.utils.TestDataReader;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemsInCartTests extends CommonConditions {

  @Test
  void checkMultipleItemsInCart() {
    List<ProductDTO> productList = new ArrayList<>();
    List<String> productsReferences = TestDataReader.getTestData();
    for (String productReference : productsReferences) {
      mainPage.openProductPage(productReference);
      productPage.addToCart();
      productList.add(productPage.createProductObject());
    }
    cartPage.openCartPage();

    Assertions.assertThat(cartPage.getProductNamesOnCart())
        .as("Check all products are present on the cart page")
        .containsAll(productList.stream().map(ProductDTO::getName).toList());
    Assertions.assertThat(cartPage.getOrderTotal()).as("Order total is not equal")
        .isEqualTo(productList.stream().mapToDouble(ProductDTO::getPrice).sum());
    Assertions.assertThat(cartPage.getProductListFromCartPage())
        .as("Expected all generated ProductDTO objects to be present, but failed to find all")
        .containsAll(productList);
  }

}
