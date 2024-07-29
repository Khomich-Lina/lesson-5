import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class RozetkaTest {

    private WebDriver driver;

    @BeforeTest
    void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");
        driver.manage().window().maximize();
    }

    @Test
    public void testRozetka()  {

        WebElement inputSearchForm = driver.findElement(By.xpath("//input[@name='search']"));
        inputSearchForm.sendKeys("праска");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(@class, 'button button_color_green button_size_medium search-form__submit')]"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'compare-button')]")));

        List<WebElement> ironList = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button[contains(@class, 'compare-button')]"), 60));
        ironList.get(1).click();
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'notification')]")));
        ironList.get(2).click();

        driver.get("https://rozetka.com.ua/comparison/");
        Assert.assertEquals(driver.findElements(By.xpath("//li[@class='ul-i']")).size(), 2);

    }

        @AfterTest
        void closeDriver(){

            driver.quit();
        }
    }


