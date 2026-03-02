package tests;

import framework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSampleTests extends BaseTest {

    @Test(description = "Validate Amazon page title contains Amazon")
    public void verifyHomePageTitle() {
        String title = driver.getTitle();
        logger.info("Amazon home title: {}", title);
        Assert.assertTrue(title.toLowerCase().contains("amazon"), "Title should contain Amazon");
    }

    @Test(description = "Search for a product and verify results")
    public void searchForProduct() {
        By searchBox = By.id("twotabsearchtextbox");
        By resultContainer = By.cssSelector("div.s-main-slot");

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchInput.clear();
        searchInput.sendKeys("laptop", Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(resultContainer));
        logger.info("Search results are displayed for laptop");
        Assert.assertTrue(driver.getCurrentUrl().contains("k=laptop"), "URL should include search query");
    }
}
