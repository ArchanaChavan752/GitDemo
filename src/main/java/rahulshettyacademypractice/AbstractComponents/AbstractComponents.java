package rahulshettyacademypractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	driver.findElement(By.className("mb-3")); .... It is called as WebElement
//	By.className("mb-3") ....It is called as Bylocator
	
	@FindBy(css="[routerlink*='cart']")
	WebElement CartHeader;
	
	public void waitForElementAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	

	public void WaitForElementDisable(WebElement ele) throws InterruptedException
	{
		Thread.sleep(2000);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	

	public void goToCartPage()
	{
		CartHeader.click();
	}
}
