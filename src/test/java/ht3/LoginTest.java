package ht3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginWithNonexistentUser(){
        driver.get("https://rozetka.com.ua/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nonexistentuser@example.com", "wrongpassword");

        Assert.assertTrue(loginPage.isErrorMessageDisplfyed(), "Error message should be displayed for nonexistent user login");
    }

}
