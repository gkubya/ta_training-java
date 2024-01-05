package com.epam.training.student_gregory_kubya;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url =
public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
