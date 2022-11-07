package rahulshettyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

//	We have to create local object
	WebDriver driver;
	
//	LandingPage do not have any clue about driver,so we have  
//	Here we will create Constructor of LandingPage class
//	The main advantage of constructor is that it will get excuted first then only other conditions will get executed.
//	Many tester use this constructor method mostly.
	
	public LandingPage(WebDriver driver)
	{
		super(driver); // Here super is a keyword in java , in that child page(LandingPage) smartly send driver to parent page(AbstractComponents).
		this.driver=driver; // this.driver referes to the current class instance variable.
		PageFactory.initElements(driver, this);
	}
//	We have passed argument to the constructor (i.e. WebDriver driver) that has scope only in the constructor method only.means block scope.
//	That driver argument will not accessible out of the constructor.
	
	
//	WebElement userEmail=driver.findElement(By.id("userEmail"));
	
//	Another method is Page-Factory design pattern.
//	It will reduce the code for definig the WebElement.
	
	@FindBy(id="userEmail")
	WebElement Email;
	
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement submit;
	
//	ng-tns-c4-7 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorMasg;
	
	
	
//	Interview question:
//	How this annotation(@FindBy) knows about driver?
//	Ans. Then you should tell that there is one method initElement which we have to write first,which will take care of constructing that using driver argument that we have send in the
//	method.

//	Then we have to do action like 'login'
	public ProductCatalogue loginApplication(String email,String pwd)
	{
		Email.sendKeys(email);
		Password.sendKeys(pwd);
		submit.click();
		ProductCatalogue prodcat=new ProductCatalogue(driver);
		return prodcat;
	}
	
	public String getErroMessage()
	{
		return ErrorMasg.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
