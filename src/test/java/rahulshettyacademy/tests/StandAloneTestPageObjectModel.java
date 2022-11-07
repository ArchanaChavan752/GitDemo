package rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObject.CartPage;
import rahulshettyacademy.pageObject.ConfirmationPage;
import rahulshettyacademy.pageObject.LandingPage;
import rahulshettyacademy.pageObject.ProductCatalogue;
import rahulshettyacademy.pageObject.checkOutPage;

public class StandAloneTestPageObjectModel extends BaseTest{

	@Test
	public void StandAloneTestPageObjectModel() throws IOException, InterruptedException{
		
		String productName="ZARA COAT 3";
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Files\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));	
//		
		// For Login Page:
//		LandingPage landingPage=new LandingPage(driver);
//		landingPage.goTo();
//		driver.get("https://rahulshettyacademy.com/client");
		
//		LandingPage landingPage=launchApplication();
		ProductCatalogue prodcat=landingPage.loginApplication("archanachavan752@gmail.com", "jufU2WD@nXgK9fq\r\n");
//		driver.findElement(By.id("userEmail")).sendKeys("archanachavan752@gmail.com");  // Email
//		driver.findElement(By.id("userPassword")).sendKeys("jufU2WD@nXgK9fq\r\n");  // Password
//		driver.findElement(By.id("login")).click();  // Login button

		// For AbstractComponents Page: 
		// Here we have reusable code, so we will create on page object for that and use it in all the classes.
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb-3")));
		
//		First grab all the products
//		There are 3 products
		
		// For Products Action class:
		List<WebElement> products= prodcat.getProductList();
				
//		List<WebElement> products=driver.findElements(By.className("mb-3"));
		
//		Here we have used Stream.. in that will not get the product directly so we have find it deeply..
//		WebElement prod=products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

		
		// Add to Cart Action class:
		prodcat.addProductToCart(productName);
//		In that product will get an two buttons view and Add to Cart, so we have to click on Add to Cart so we have use hare latest locator i.e. last-of-type.
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		// Cart its comes in header so it is common to all,so it is reusable to all the pages,so it will come in Abstract Component page.
		CartPage cartPage=prodcat.goToCartPage();
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		Boolean match=cartPage.verifyCartProducts(productName);
		
//		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match= cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));


//		Validation will not go in page object model.
		//		Assert.assertTrue(match);
		
		checkOutPage checkoutpage=cartPage.checkOutpage();
		checkoutpage.SelectCountry("india");
		ConfirmationPage confirmationPage= checkoutpage.SubmitOrder();
		String ConfirmationMessage=confirmationPage.getConfirmationMessage();
		//		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		
//		Actions a= new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		
//		driver.findElement(By.xpath("//button[contains(@class,'ta-item')])[2]")).click();
//		driver.findElement(By.cssSelector(".action__submit")).click();
	
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
	
	}

}
