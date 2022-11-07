package swagLabs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import swagLabs.pageObject.LandPage;

public class swagLabsPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Saucedemo.com");
		
		String productName="Sauce Labs Backpack";
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
//		LandPage land=new LandPage(driver);
//		land.LoginApp("standard_user", "secret_sauce");
//		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item_description")));
				
		List<WebElement>CartProducts=driver.findElements(By.cssSelector(".inventory_item_description"));
		CartProducts.stream().filter(c->c.findElement(By.cssSelector(".btn_secondary")).getText().equals(productName)).findFirst().orElse(null);
	}

}
