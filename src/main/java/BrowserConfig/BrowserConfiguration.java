package BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class BrowserConfiguration {

    @Test
    public void chrome_config(){
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.google.com");

        // Perform Selenium actions here

        // Close the browser
        driver.close();
    }

    @Test
    public void firefox_config(){
        // Initialize ChromeDriver
        WebDriver driver = new FirefoxDriver();

        // Open a website
        driver.get("https://www.apple.com");

        // Perform Selenium actions here

        // Close the browser
        driver.close();
    }

    @Test
    public void edge_config(){
        // Initialize ChromeDriver
        WebDriver driver = new EdgeDriver();

        // Open a website
        driver.get("https://www.bbc.com");

        // Perform Selenium actions here

        // Close the browser
        driver.close();
    }
}
