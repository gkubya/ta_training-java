package com.epam.training.student_gregory_kubya.utils;

import static com.epam.training.student_gregory_kubya.driver.WebDriverProvider.driver;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureAttachmentsManager {

  @Attachment(value = "Screenshot", type = "image/png")
  public static byte[] screenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

}
