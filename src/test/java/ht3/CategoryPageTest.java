package ht3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryPageTest extends BaseTest {
    @Test
    public void testFilterSingleResult(){
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.applyFilter();

        Assert.assertEquals(categoryPage.getResultsCount(), 1, "There should be exactly one result after applying the filter");
    }
}
