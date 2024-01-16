package com.epam.training.student_gregory_kubya;

public class PriceUtil {

  public static double convertEuro(String priceInEuro) {
    String convertedPrice = priceInEuro.replaceAll("\\s|€", "").replace(",", ".");
    return Double.parseDouble(convertedPrice);
  }

}
