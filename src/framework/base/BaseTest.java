package framework.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest test;

    @BeforeClass
    public void setup() {
        // ChromeDriver initialization
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize Extent Reports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        extentReports.flush();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }
}
