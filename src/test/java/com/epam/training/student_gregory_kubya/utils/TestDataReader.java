package com.epam.training.student_gregory_kubya.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TestDataReader {

  public static List<String> getTestData() {
    ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("environment", "qa"));

    List<String> productReferences = new ArrayList<>();

    int i = 1;
    while (true) {
      String key = "product" + i++;
      try {
        productReferences.add(bundle.getString(key));
      } catch (MissingResourceException e) {
        break;
      }
    }

    return productReferences;
  }
}
