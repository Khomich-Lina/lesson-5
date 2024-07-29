package ht1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GG {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void myTest() {

        try {

            driver.get("https://rozetka.com.ua/");


            driver.get("https://rozetka.com.ua/notebooks/c80004/");


            List<WebElement> compareButtons = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".compare-button")));
            compareButtons.get(0).click();
            compareButtons.get(1).click();


            WebElement comparePageLink = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.compare-button_state_active")));
            comparePageLink.click();


            List<WebElement> comparedProducts = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".products-grid__cell")));




            for (WebElement product : comparedProducts) {
                String productName = product.findElement(By.cssSelector(".product-title__text")).getText();
                System.out.println("Товар у порівнянні: " + productName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}