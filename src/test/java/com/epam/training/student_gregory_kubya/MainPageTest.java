package com.epam.training.student_gregory_kubya;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

@BeforeEach    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://");

        mainPage = new MainPage(driver);
    }

@AfterEach    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {

    }

    @Test
    public void toolsMenu() {
    }

    @Test
    public void navigationToAllTools() {

    }
}
