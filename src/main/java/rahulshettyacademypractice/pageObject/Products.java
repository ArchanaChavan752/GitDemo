package rahulshettyacademypractice.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class Products extends AbstractComponents{ 
	WebDriver driver;
	

	public Products(WebDriver driver)
	{
		super(driver);
		this.driver=driver; 
		PageFactory.initElements(driver,this);
	}
	
//	List<WebElement> products=driver.findElements(By.className("mb-3"));
	@FindBy(className="mb-3") 
	List<WebElement> products;
	
//	driver.findElement(By.cssSelector(".ng-animating"))
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productsBy=By.className("mb-3");
	By addTocart=By.cssSelector(".card-body button:last-of-type");

		
	public List<WebElement> getProducts()
	{
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb-3")));
		
		waitForElementAppear(productsBy); // First we have wait for product appear.
		return products;
	}
	
	public WebElement getProductsByname(String productName)
	{
		
//		waitForElementAppear(addTocart);
		WebElement prod=products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public WebElement addToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductsByname( productName);
		prod.findElement(addTocart).click();
		waitForElementDisappear(spinner);
		return prod;
		
	}
	
}
