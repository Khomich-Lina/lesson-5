package ht3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparisonPageTest extends BaseTest{
    @Test
    public void testAddItemsToComparison(){
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        ComparisonPage comparisonPage = new ComparisonPage(driver);
        comparisonPage.addItemsToComparison();
        comparisonPage.goToComparisonPage();

        Assert.assertEquals(comparisonPage.getComparisonItemsCount(), 2, "There should be exactly two items in the comparison list");

    }
}
