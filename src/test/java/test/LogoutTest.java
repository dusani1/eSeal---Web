package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends Base {

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = openBrowserAndApplicationURL();
		loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("email"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.checkRememberMeCheckBoxifNotSelected();
		loginPage.checkCookieCheckBoxifNotSelected();
		homePage = loginPage.clickOnSubmitButton();
		homePage.clickOnProfileIcon();
		Assert.assertEquals(homePage.getLoggedInMail(), prop.getProperty("email"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		quitBrowser(driver);
	}

	@Test(priority = 1, groups = { "Smoke" })
	public void verifyLogoutFromLogoutOptionUnderProfile() {
		homePage.clickOnLogoutIcon();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(getPageTitle(), prop.getProperty("loginPageTitle"));
		Assert.assertEquals(getUrl(), getExpectedPageURL("loginPageUrl"));
	}

	@Test(priority = 2, groups = { "Smoke" })
	public void verifyReLoginImmediatelyAfterLogout() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		homePage.clickOnLogoutIcon();
		Thread.sleep(1000);
		softAssert.assertEquals(getPageTitle(), prop.getProperty("loginPageTitle"));
		softAssert.assertEquals(getUrl(), getExpectedPageURL("loginPageUrl"));
		loginPage.enterEmail(prop.getProperty("email"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.checkRememberMeCheckBoxifNotSelected();
		loginPage.checkCookieCheckBoxifNotSelected();
		homePage = loginPage.clickOnSubmitButton();
		homePage.clickOnProfileIcon();
		softAssert.assertEquals(homePage.getLoggedInMail(), prop.getProperty("email"));
		homePage.clickOnLogoutIcon();
		softAssert.assertEquals(getPageTitle(), prop.getProperty("loginPageTitle"));	
		softAssert.assertEquals(getUrl(), getExpectedPageURL("loginPageUrl"));
		softAssert.assertAll();

	}

	@Test(priority = 3, groups = { "Sanity" })
	public void verifyLogoutAndBackNavigation() throws InterruptedException {
		homePage.clickOnLogoutIcon();
		Thread.sleep(1000);
		Assert.assertEquals(getPageTitle(), prop.getProperty("loginPageTitle"));
		Assert.assertEquals(getUrl(), getExpectedPageURL("loginPageUrl"));
		driver.navigate().back();
		Thread.sleep(1000);
		Assert.assertEquals(getPageTitle(), prop.getProperty("loginPageTitle"));
		Assert.assertEquals(getUrl(), getExpectedPageURL("loginPageUrl"));
	}

	@Test(priority = 4, groups = { "Sanity" })
	public void verifyLogoutAndForwardNavigation() throws InterruptedException {
		homePage.clickOnLogoutIcon();
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(1000);
		Assert.assertEquals(getUrl(), getExpectedPageURL("loginPageUrl"));
	}

	@Test(priority = 5, groups = { "Sanity" })
	public void verifyAutoLogoutAfterSessionTimeout() throws InterruptedException {
		Thread.sleep(10000); // 15 minutes timeout simulation: Time need to get from Dev team
		driver.navigate().refresh();
		Assert.assertEquals(getUrl(), getExpectedPageURL("loginPageUrl"));
	}

}
