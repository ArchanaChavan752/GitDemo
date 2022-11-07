package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class checkOutPage extends AbstractComponents{

WebDriver driver;
	
	public checkOutPage(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement SelectCountry;
	
	@FindBy(css="app-order.ng-star-inserted:nth-child(2) section.content:nth-child(2) div.container-fluid div.row div.col-md-7 div.container div.payment div.payment__info div.payment__shipping div.details__user div.user__name.mt-5 div.user__address:nth-child(3) div.form-group:nth-child(2) section.ta-results.list-group.ng-star-inserted > button.ta-item.list-group-item.ng-star-inserted:nth-child(3)")
	WebElement SelectIndia;
	
	@FindBy(linkText="Place Order ")
	WebElement Submit;
	
	public void SelectCountry(String CountryName)
	{
		Actions a= new Actions(driver);
		a.sendKeys(SelectCountry, CountryName).build().perform();
		
		waitForElementAppear(By.cssSelector(".ta-results"));
		
		driver.findElement(By.cssSelector("app-order.ng-star-inserted:nth-child(2) section.content:nth-child(2) div.container-fluid div.row div.col-md-7 div.container div.payment div.payment__info div.payment__shipping div.details__user div.user__name.mt-5 div.user__address:nth-child(3) div.form-group:nth-child(2) section.ta-results.list-group.ng-star-inserted > button.ta-item.list-group-item.ng-star-inserted:nth-child(3)")).click();
		driver.findElement(By.linkText("Place Order ")).click();
		SelectIndia.click();
	}
	
	public ConfirmationPage SubmitOrder()
	{
		Submit.click();
		return new ConfirmationPage(driver);
	}
	
}
