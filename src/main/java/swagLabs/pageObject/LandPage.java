package swagLabs.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandPage {

	WebDriver driver;
	public LandPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	@FindBy(id="user-name")
	WebElement Username;

//	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	@FindBy(id="password")
	WebElement Pass;

//	driver.findElement(By.id("login-button")).click();
	@FindBy(id="login-button")
	WebElement Login;
	

	public void LoginApp(String user,String pwd)
	{
		Username.sendKeys(user);
		Pass.sendKeys(pwd);
		Login.click();
	}
}
