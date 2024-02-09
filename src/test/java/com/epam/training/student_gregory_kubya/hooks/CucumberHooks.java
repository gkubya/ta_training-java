package com.epam.training.student_gregory_kubya.hooks;

import com.epam.training.student_gregory_kubya.driver.WebDriverProvider;
import io.cucumber.java.After;

public class CucumberHooks {

  @After
  public void tearDown() {
    WebDriverProvider.closeDriver();
  }

}
