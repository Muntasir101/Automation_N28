package QAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test_search_valid() throws Exception {
        // Open a website
        driver.get("https://tutorialsninja.com/demo/");
        Thread.sleep(5000);

        // Find search field and search button
        WebElement searchField = driver.findElement(By.name("search"));
        WebElement searchButton = driver.findElement(By.cssSelector("#search > span > button"));

        // Enter search term and click the search button
        searchField.sendKeys("Macbook");
        searchButton.click();

        // Verify that 3 MacBooks are displayed on the search result page
        WebElement searchResult = driver.findElement(By.cssSelector(".product-layout .product-thumb"));
        int numberOfMacBooksDisplayed = driver.findElements(By.cssSelector(".product-layout .product-thumb")).size();

        Assert.assertEquals(numberOfMacBooksDisplayed, 3, "Expected 3 MacBooks to be displayed, but found " + numberOfMacBooksDisplayed);
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver after the test
        driver.quit();
    }
}
