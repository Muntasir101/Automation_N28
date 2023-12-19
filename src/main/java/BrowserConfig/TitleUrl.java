package BrowserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TitleUrl {

    @Test
    public void chrome_config(){
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open a website
        driver.get("https://www.google.com");

        // Perform Selenium actions here
        String title = driver.getTitle();
        System.out.println("Title: " +title);

        String url = driver.getCurrentUrl();
        System.out.println("Url: " +url);

        // Close the browser
        driver.close();
    }
}
