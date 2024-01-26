package com.epam.training.student_gregory_kubya.utils;

public class PriceUtil {

  public static double parseEuroValue(String priceInEuro) {
    String convertedPrice = priceInEuro.replaceAll("\\s|€", "").replace(",", ".");
    return Double.parseDouble(convertedPrice);
  }

}
