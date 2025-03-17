package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.Base;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base{

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;

	@BeforeMethod
	public void setup() {
		driver = openBrowserAndApplicationURL();
		loginPage = new LoginPage(driver);

	}

	@AfterMethod
	public void tearDown() {
		quitBrowser(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
