package ht3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage {
    private WebDriver driver;

    @FindBy(css = "label[for='Apple']") //rz-filter-section-autocomplete//a[contains(@href,'apple')]
    private WebElement filterOption;

    @FindBy(css = "span.goods-tile__title")
    private List<WebElement> results;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void applyFilter(){
        filterOption.click();
    }
    public int getResultsCount(){
        return results.size();
    }
}
