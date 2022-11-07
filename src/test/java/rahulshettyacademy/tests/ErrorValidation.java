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

public class ErrorValidation extends BaseTest{

	@Test
	public void StandAloneTestPageObjectModel() throws IOException, InterruptedException{
		
		landingPage.loginApplication("archanachavan753@gmail.com", "jufU2WD@nXgK9fq\r\n");
		
		Assert.assertEquals(" Incorrect email or password.",landingPage.getErroMessage() );
	}

}
