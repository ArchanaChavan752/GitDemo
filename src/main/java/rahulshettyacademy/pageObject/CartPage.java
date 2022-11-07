package rahulshettyacademy.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage<goTocheckOutPage> extends AbstractComponents {

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement Checkout;
	
	
		
	public boolean verifyCartProducts(String productName)
	{
		Boolean match= cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public checkOutPage checkOutpage()
	{
		Checkout.click();
		return new checkOutPage(driver);
	}
			
	
	
}
