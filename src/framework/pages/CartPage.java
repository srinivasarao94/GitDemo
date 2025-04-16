package framework.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
    }

    By searchBox = By.id("small-searchterms");
    By searchButton = By.cssSelector("input[value='Search']");
    By addToCartButton = By.cssSelector("input[value='Add to cart']");
    By cartLink = By.cssSelector("a[href='/cart']");
    By cartItems = By.cssSelector("tr.cart-item-row td.product a.product-name");

    public void searchAndAddToCart(String item) {
        // Wait for the search box to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(item);

        // Wait for the search button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        // Wait for the "Add to cart" button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }

    public void navigateToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        driver.findElement(cartLink).click();
    }


    public boolean isItemInCart(String itemName) {
        navigateToCart();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        return driver.findElements(cartItems)
                     .stream()
                     .anyMatch(item -> item.getText().toLowerCase().contains(itemName.toLowerCase()));
    }


}
