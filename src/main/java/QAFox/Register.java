package QAFox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Random;

public class Register {

    public static String generateUniqueEmail(String username) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        // Generate a random string as a unique identifier
        String uniqueIdentifier = randomString.toString();

        // Construct the unique email address
        String domain = "gmail.com"; // You can replace this with your desired domain

        return username + "_" + uniqueIdentifier + "@" + domain;
    }
    @Test
    public void Register() throws InterruptedException {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open a website
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        Thread.sleep(5000);

        WebElement Firstname_field = driver.findElement(By.name("firstname"));
        WebElement Lastname_field = driver.findElement(By.name("lastname"));
        WebElement Email_field = driver.findElement(By.name("email"));
        WebElement Telephone_field = driver.findElement(By.name("telephone"));
        WebElement Password_field = driver.findElement(By.name("password"));
        WebElement Passwordconfirm_field = driver.findElement(By.name("confirm"));
        WebElement Privatepolicy_field = driver.findElement(By.name("agree"));
        WebElement Continue_field = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        Firstname_field.sendKeys("Mohammad Farid Uddin");
        Lastname_field.sendKeys("Chowdhury");
        Email_field.sendKeys(generateUniqueEmail("test"));
        Thread.sleep(4000);
        Telephone_field.sendKeys("07354918131");
        Password_field.sendKeys("Noman1234");
        Passwordconfirm_field.sendKeys("Noman1234");
        Privatepolicy_field.click();
        Continue_field.click();
        Thread.sleep(5000);

        driver.close();
    }
}
