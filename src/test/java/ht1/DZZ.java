package ht1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class DZZ {

    private WebDriver driver;

    @BeforeTest
    void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void myTest() {


        WebElement loginButton = driver.findElement(By.cssSelector("rz-auth-icon"));
        loginButton.click();


        WebElement emailField = driver.findElement(By.cssSelector("rz-auth-icon"));
        loginButton.click();
        emailField.sendKeys("nonexistentuser@gmail.com");


        WebElement passwordField = driver.findElement(By.id("auth_pass"));
        passwordField.sendKeys("incorrectpassword");


        WebElement submitButton = driver.findElement(By.cssSelector("button.auth-modal__submit"));
        submitButton.click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}