package Navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navigation_Demo {
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

        // Open a website
        driver.get("https://www.apple.com");
        String title_apple = driver.getTitle();
        System.out.println("Title: " +title_apple);

        String url_apple = driver.getCurrentUrl();
        System.out.println("Url: " +url_apple);

        driver.navigate().back();
        System.out.println("Back to " + driver.getTitle());

        driver.navigate().forward();
        System.out.println("Forward to " + driver.getTitle());

        // Close the browser
        driver.close();
    }
}
