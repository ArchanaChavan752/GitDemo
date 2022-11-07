package rahulshettyacademypractice.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPagesample extends AbstractComponents{ 
	WebDriver driver;
	

	public CartPagesample(WebDriver driver)
	{
		super(driver);  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;

	public Boolean verifyCartSample(String productName)
	{
		Boolean match= cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));
		return match;
	}
}
