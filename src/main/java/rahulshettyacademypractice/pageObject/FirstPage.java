package rahulshettyacademypractice.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class FirstPage extends AbstractComponents{ 
// Here we have used inheritance concept.  AbstractComponents is a parent class of all other page object classes.bcoz it holds all reusable stuff.
	
//	We have to create local object
	WebDriver driver;
	
//	FirstPage do not have any clue about driver,so Here we will create Constructor of FirstPage class.
//	The main advantage of constructor is that it will get excuted first ,then only other conditions/methods will get executed.
//	Many tester use this constructor method mostly.

	public FirstPage(WebDriver driver)
	{
		super(driver);  // Here super is a keyword in java , in that child page(FirstPage) smartly send driver to parent page(AbstractComponents).
		this.driver=driver;  // this.driver referes to the current class instance variable.
		PageFactory.initElements(driver,this);
	}
//	We have passed argument to the constructor (i.e. WebDriver driver) that has scope only in the constructor method only.means block scope.
//	That driver argument will not accessible out of the constructor.

	
//	Another method is Page-Factory design pattern.
//	It will reduce the code for definig the WebElement.

//	driver.findElement(By.id("userEmail")).sendKeys("archanachavan752@gmail.com");  // Email
	@FindBy(id="userEmail")
	WebElement Email;
	
//	driver.findElement(By.id("userPassword")).sendKeys("jufU2WD@nXgK9fq\r\n");  // Password
	@FindBy(id="userPassword")
	WebElement Password;
	
//	driver.findElement(By.id("login")).click();  // Login button
	@FindBy(id="login")
	WebElement Login;
	
//	Interview question:
//	How this annotation(@FindBy) knows about driver?
//	Ans. Then you should tell that there is one method initElement which we have to write first,which will take care of constructing that using driver argument that we have send in the
//	method.
	
//	For Action:
	public void LoginApp(String email,String pwd)
	{
		Email.sendKeys(email);
		Password.sendKeys(pwd);
		Login.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
