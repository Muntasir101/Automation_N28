package QAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {



    @Test
    public void test_login_valid() throws Exception {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open a website
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        Thread.sleep(5000);

        WebElement Email_field = driver.findElement(By.name("email"));
        WebElement Password_field = driver.findElement(By.name("password"));
        WebElement Login_field = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        Email_field.sendKeys("noman.chowdhury1976@gmail.com");
        Password_field.sendKeys("Noman1234");
        Login_field.click();
        Thread.sleep(5000);

        // Verify login successful
        WebElement my_orders = driver.findElement(By.cssSelector("#content > h2:nth-child(3)"));
        String my_order_text = my_orders.getText();

        // Define the expected welcome message
        String expectedMessage = "My Orders";

        // Perform the text assertion
        Assert.assertEquals(my_order_text, expectedMessage, "Login successful");

        driver.close();

    }

    @Test
    public void test_login_invalid() throws Exception {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open a website
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        Thread.sleep(5000);

        WebElement Email_field = driver.findElement(By.name("email"));
        WebElement Password_field = driver.findElement(By.name("password"));
        WebElement Login_field = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        Email_field.sendKeys("noman.chowdhury1976@gmail.com");
        Password_field.sendKeys("1233");
        Login_field.click();
        Thread.sleep(5000);

        // Verify login not successful
        WebElement error_message = driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible"));
        String error_message_text = error_message.getText();

        // Define the expected welcome message
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";

        // Perform the text assertion
        Assert.assertEquals(error_message_text, expectedMessage, "Login is not successful");

        driver.close();

    }
}
