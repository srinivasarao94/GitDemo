package Interview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Democlass {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");
		
		//Click Operation
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("welcomeDiv")).getText(), "You have done a dynamic click");
		
		//Right Click
		
		
		//Double Click
		
		// Double Click using Actions class
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.xpath("//button[@class='btn btn-secondary']"))).perform();
      //  Assert.assertEquals(driver.findElement(By.id("rightc")).getText(), "You have done a right click");

        action.doubleClick(driver.findElement(By.xpath("//button[@class='btn btn-success']"))).perform();

        Assert.assertEquals(driver.findElement(By.id("doublec")).getText(), "You have Double clicked");

        driver.quit();
	}
}

