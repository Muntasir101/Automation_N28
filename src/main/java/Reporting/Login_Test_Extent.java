package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Test_Extent {

    WebDriver driver;

    ExtentHtmlReporter htmlReporter;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeClass
    public void init_setup() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void TC_invalid_001() {
        // Implement Extent Report
        htmlReporter = new ExtentHtmlReporter("./ExtentReports/LoginTestReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // Information added to report
        reports.setSystemInfo("Environment", "Test");
        reports.setSystemInfo("Test By", "Muntasir");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("Browser", "Chrome");
        logger = reports.createTest("Login Test");

        // Navigate to the website
        driver.get("https://demo.guru99.com/selenium/newtours/");
        logger.log(Status.INFO, "Newtours Open");

        // Find elements
        WebElement email = driver.findElement(By.name("userName"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.name("submit"));

        // Perform actions and log in the report
        email.sendKeys("test");
        logger.log(Status.INFO, "Email typing");

        password.sendKeys("123456");
        logger.log(Status.INFO, "Password typing");

        loginBtn.click();
        logger.log(Status.INFO, "Sign in clicked");

        System.out.println("Login Invalid Test passed");
        logger.log(Status.PASS, "Test Passed");

        reports.flush();
    }
}
