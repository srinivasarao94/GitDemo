package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.cssSelector("input[value='Log in']");
    By logoutLink = By.linkText("Log out");

    public void loginUser(String userEmail, String userPassword) {
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(loginButton).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElements(logoutLink).size() > 0;
    }
}
