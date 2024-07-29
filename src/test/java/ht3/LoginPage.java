package ht3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(css = "rz-auth-icon")
    private WebElement loginButton;

    @FindBy(id = "auth_email")
    private WebElement emilField;

    @FindBy(id = "auth_pass")
    private WebElement passwordField;

    @FindBy(css = "button.auth-modal__submit")
    private WebElement submitButton;

    @FindBy(css = "p.error-message.ng-star-inserted")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void login(String email, String password){
        loginButton.click();
        emilField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }
    public boolean isErrorMessageDisplfyed(){
        return errorMessage.isDisplayed();
    }
}
