package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Orange_Login {
    @Test
    public void login_valid_Test() throws InterruptedException {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open a website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);

        // Find WebElement
        WebElement Username_field = driver.findElement(By.name("username"));
        WebElement Password_field = driver.findElement(By.name("password"));
        WebElement Login_button = driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button"));

        // Action
        Username_field.sendKeys("Admin");
        Password_field.sendKeys("admin123");
        Login_button.click();
        Thread.sleep(5000);

        // Close the browser
        driver.close();
    }
}
