package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulshettyacademy.pageObject.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
//		first we have to create one global file for browser initialization ..means if we initialize in .properties file "browser=Chrome"
//		then taht entire framework will run in chrome browser.
//		that file should have .properties extension.
		
		// properties class
		// create object of properties class
		Properties props=new Properties();
		
//		FileInputStream will convert the file path into the inputstream format. 
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		props.load(fis);  // Here it will load the global properties file. but that we have to send that file in inputStream format , so there is one method in java 
//		i.e. FileInputStream();
		
		String browserName=props.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{	
			// For Chrome
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
		// For Firefox
			System.setProperty("webdriver.geko.driver", "C:\\Program Files\\Selenium Files\\gekodriver_win32\\gekodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Edge")) {
		// For Microsoft Edge
			System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Selenium Files\\edgedriver_win32\\edgedriver.exe");
			driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
