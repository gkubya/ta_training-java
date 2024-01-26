package com.epam.training.student_gregory_kubya.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

  public static WebDriver driver;


  private DriverSingleton() {
  }

  public static WebDriver getDriver() {
    if (null == driver) {
      switch (System.getProperty("browser")) {
        case "firefox": {
          System.setProperty("webdriver.firefox.bin",
              "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
          driver = new FirefoxDriver();
        }
        default: {
          driver = new ChromeDriver();
        }
      }
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }

}
