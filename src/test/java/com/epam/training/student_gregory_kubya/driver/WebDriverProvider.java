package com.epam.training.student_gregory_kubya.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider {

  public static WebDriver driver;


  private WebDriverProvider() {
  }

  public static WebDriver getDriver() {
    if (driver == null) {
      if (System.getProperty("browser") != null && System.getProperty("browser")
          .equals("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
      } else {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
      }
//      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void setDriver(WebDriver driver) {
    WebDriverProvider.driver = driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
