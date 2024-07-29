package ht3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ComparisonPage {
    private WebDriver driver;

    @FindBy(css = "button.compare-button")
    private List<WebElement> compareButtons;

    @FindBy(css = "a[href*='/compare']")
    private WebElement comparisonPageLink;

    @FindBy(css = "div.comparison-t ul li")
    private List<WebElement> comparisonItems;

    public ComparisonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addItemsToComparison(){
        compareButtons.get(0).click();
        compareButtons.get(1).click();
    }
    public void goToComparisonPage(){
        comparisonPageLink.click();
    }
    public int getComparisonItemsCount(){
        return comparisonItems.size();
    }
}
