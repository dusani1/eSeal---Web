package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class LoginTest extends Base {

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = openBrowserAndApplicationURL();
		loginPage = new LoginPage(driver);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		quitBrowser(driver);
	}
	
	@Test(priority = 1, groups = { "Smoke" })
	public void verifyLoginPageTitleAndUrl() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(getPageTitle(), prop.getProperty("loginPageTitle"));
		softAssert.assertEquals(getPageUrl(driver), getExpectedPageURL("loginPageUrl"));
		softAssert.assertAll();
		}


	
	@Test(priority = 2, groups = { "Smoke" })
	public void verifyFieldAndCheckboxLabels() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(loginPage.getEmailFieldLabelText(), "Email");
		softAssert.assertEquals(loginPage.getPasswordFieldLabelText(), "Password");
		softAssert.assertEquals(loginPage.getRememberMeCheckBoxLabelText(), "Remember me");
		softAssert.assertEquals(loginPage.getCookieCheckBoxLabelText(), "I am aware that this site will be using cookies to improve user experience by managing/retaining user sessions on the browser");		
		softAssert.assertEquals(loginPage.getSignInButtonText(), "SIGN IN");
		softAssert.assertEquals(loginPage.getForgotPasswordText(), "Forgot password? Click here");	
		softAssert.assertAll();
		}

	@Test(priority = 3, groups = { "Smoke" })
	public void verifyLoginUsingValidCredentials() {
		loginPage.enterEmail(prop.getProperty("email"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.checkRememberMeCheckBoxifNotSelected();
		loginPage.checkCookieCheckBoxifNotSelected();
		homePage = loginPage.clickOnSubmitButton();
		homePage.clickOnProfileIcon();
		Assert.assertEquals(homePage.getLoggedInMail(), prop.getProperty("email"));
		homePage.clickOnLogoutIcon();

	}
	
	@Test(priority = 4, groups = { "Sanity1" })
	public void verifyLoginUsingInvalidCredentials() throws InterruptedException {
		loginPage.enterEmail(CommonUtils.generateNewEmail());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.checkRememberMeCheckBoxifNotSelected();
		loginPage.checkCookieCheckBoxifNotSelected();
		loginPage.clickOnSubmitButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorAlertWindow()));
		Assert.assertEquals(loginPage.getErrorMessage(), "Server: Invalid email or password.");
		loginPage.clickOnOkInErrorWindow();

	}

	@Test(priority = 5, groups = { "Sanity1" })
	public void verifyLoginWithInvalidEmailAndValidPassword() throws InterruptedException {
		loginPage.enterEmail(prop.getProperty("invalidEmail"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.checkRememberMeCheckBoxifNotSelected();
		loginPage.checkCookieCheckBoxifNotSelected();
		loginPage.clickOnSubmitButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorAlertWindow()));
		Thread.sleep(10000);
		Assert.assertEquals(loginPage.getErrorMessage(), "Server: Invalid email or password.");
		loginPage.clickOnOkInErrorWindow();
	}

	@Test(priority = 6, groups = { "Sanity1" })
	public void verifyLoginWithValidEmailAndInvalidPassword() throws InterruptedException {
		loginPage.enterEmail(prop.getProperty("email"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.checkRememberMeCheckBoxifNotSelected();
		loginPage.checkCookieCheckBoxifNotSelected();
		loginPage.clickOnSubmitButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorAlertWindow()));
		Thread.sleep(10000);
		Assert.assertEquals(loginPage.getErrorMessage(), "Server: Invalid email or password.");
		loginPage.clickOnOkInErrorWindow();
	}

	@Test(priority = 7, groups = { "Sanity" })
	public void verifyLoginWithBlankCredentials() {
		SoftAssert softAssert = new SoftAssert();
		loginPage.enterEmail("");
		loginPage.enterPassword("");
		loginPage.checkCookieCheckBoxifNotSelected();
		loginPage.clickOnSubmitButton();
		softAssert.assertEquals(loginPage.getEmailFieldWarningAlert(), "The email field is required.");
		softAssert.assertEquals(loginPage.getPasswordFieldWarningAlert(), "The password field is required.");
	}

	@Test(priority = 8, groups = { "Sanity" })
	public void verifyLoginWithEmailOnly() {
		loginPage.enterEmail(prop.getProperty("email"));
		loginPage.checkCookieCheckBoxifNotSelected();
		loginPage.clickOnSubmitButton();
		Assert.assertEquals(loginPage.getPasswordFieldWarningAlert(), "The password field is required.");
	}

	@Test(priority = 9, groups = { "Sanity" })
	public void verifyLoginWithPasswordOnly() {
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.checkCookieCheckBoxifNotSelected();
		loginPage.clickOnSubmitButton();
		Assert.assertEquals(loginPage.getEmailFieldWarningAlert(), "The email field is required.");
	}

	@Test(priority = 10, groups = { "Sanity" })
	public void verifyLoginWithShortPassword() {
		loginPage.enterEmail(prop.getProperty("email"));
		loginPage.enterPassword("123");
		loginPage.checkCookieCheckBoxifNotSelected();
		loginPage.clickOnSubmitButton();
		Assert.assertEquals(loginPage.getPasswordFieldWarningAlert(), "The password must be at least 6 characters.");

	}

	@Test(priority = 11, groups = { "Smoke" })
	public void verifyLoginWithUppercaseInsensitiveEmail() {
		loginPage.enterEmail(prop.getProperty("email").toUpperCase());
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.checkCookieCheckBoxifNotSelected();
		homePage = loginPage.clickOnSubmitButton();
		homePage.clickOnProfileIcon();
		Assert.assertEquals(homePage.getLoggedInMail().toLowerCase(), prop.getProperty("email").toLowerCase());
	}

	@Test(priority = 12, groups = { "Smoke" })
	public void verifyLoginWithLowercaseInsensitiveEmail() {
		loginPage.enterEmail(prop.getProperty("email").toLowerCase());
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.checkCookieCheckBoxifNotSelected();
		homePage = loginPage.clickOnSubmitButton();
		homePage.clickOnProfileIcon();
		Assert.assertEquals(homePage.getLoggedInMail().toLowerCase(), prop.getProperty("email").toLowerCase());
	}

	// @Test(priority = 13, groups = { "Sanity" })
	public void verifyAccountLockout() {

		/*
		 * for (int i = 0; i < 5; i++) {
		 * loginPage.enterEmail(prop.getProperty("email"));
		 * loginPage.enterPassword("wrongPassword");
		 * loginPage.checkCookieCheckBoxifNotSelected();
		 * loginPage.clickOnSubmitButton(); loginPage.clickOnOkInErrorWindow(); }
		 * Assert.assertEquals(loginPage.getErrorMessage(),
		 * "Account locked due to too many failed attempts.");
		 */ }

	// @Test(priority = 14, groups = { "Others" })
	public void verifyLoginWithDeactivatedAccount() {
		/*
		 * loginPage.enterEmail(prop.getProperty("deactivatedEmail"));
		 * loginPage.enterPassword(prop.getProperty("password"));
		 * loginPage.checkRememberMeCheckBoxifNotSelected();
		 * loginPage.clickOnSubmitButton();
		 * Assert.assertEquals(loginPage.getErrorMessage(),
		 * "Server: Account has been deactivated.");
		 */ }

//=============Data Driven Tests=========================================
	/*
	 * @Test(priority=2, dataProvider="validCredentialsSupplier") public void
	 * verifLoginIntoTheApplicationUsingValidCredentialsDD(HashMap<String, String>
	 * map) { loginPage.enterEmail(map.get("Email"));
	 * loginPage.enterPassword(map.get("Password"));
	 * //Assert.assertEquals(loginPage.getRememberMeLabelText(),
	 * REMEMBER_ME_LABEL_TEXT); loginPage.checkRememberMeCheckBoxifNotSelected();
	 * loginPage.checkCookieCheckBoxifNotSelected(); homePage =
	 * loginPage.clickOnSubmitButton(); homePage.clickOnProfileIcon();
	 * Assert.assertEquals(homePage.getLoggedInMail(), map.get("Email"));
	 * homePage.clickOnLogoutIcon();
	 * 
	 * }
	 * 
	 * @DataProvider(name="validCredentialsSupplier") public Object[][]
	 * testDataForLogin() { MyXLSReader myXLSReader = new
	 * MyXLSReader("\\src\\test\\resource\\eSealTestData.ods"); Object[][] data =
	 * CommonUtils.getTestData(myXLSReader, "LoginWithValidCredentials", "Login");
	 * return data; }
	 */

}
