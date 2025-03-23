package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.UsersPage;

public class UsersTest extends Base {

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public UsersPage usersPage;
	

	@BeforeMethod(alwaysRun=true)
	public void setup() {
		try {
			driver = openBrowserAndApplicationURL();
			loginPage = new LoginPage(driver);
			loginPage.enterEmail(prop.getProperty("email"));
			loginPage.enterPassword(prop.getProperty("password"));
			loginPage.checkRememberMeCheckBoxifNotSelected();
			loginPage.checkCookieCheckBoxifNotSelected();
			homePage = loginPage.clickOnSubmitButton();
			homePage.clickOnAutorizationOption();
			usersPage = homePage.clickOnUsersOption();
			Assert.assertEquals(getPageTitle(), prop.getProperty("usersPageTitle"));
			Assert.assertEquals(getUrl(), getExpectedPageURL("usersPageTitle"));
		  } catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Setup method failed due to exception: " + e.getMessage());
		}

	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		quitBrowser(driver);
	}

	@Test(priority = 1, groups= {"Smoke"})
	public void verifyNavigationToUsersModule() {
		Assert.assertEquals(usersPage.usersPageHeading(), prop.getProperty("usersPageHeading"));
		homePage.clickOnProfileIcon();
		homePage.clickOnLogoutIcon();

	}

	@Test(priority = 2, groups= {"Smoke"})
	public void verifyAddUserWithValidDetails() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.enterFirstName("atbs");
		usersPage.enterLastName("dasfd");
		usersPage.enterPhoneNumber("1234567890");
		usersPage.enterEmail("abc@yomail.com");
		usersPage.enterUserName("userss");
		usersPage.enterPassword("vguard@123");
		usersPage.enterConfirmPassword("vguard@123");
		usersPage.selectLocationType("Plant");
		usersPage.selectLocation("VCPL - Panthnagar");
		usersPage.selectBusinessUnit("None");
		usersPage.selectAssignRole("Testing role");
		usersPage.selectActiveCheckbox();
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getAlertText(), "Successfully submitted!");

	}

	@Test(priority = 3)
	public void verifyAddUserWithDuplicateUserName() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.enterFirstName("atbs");
		usersPage.enterLastName("dasfd");
		usersPage.enterPhoneNumber("1234567890");
		usersPage.enterEmail("abc@yomail.com");
		usersPage.enterUserName("userss");
		usersPage.enterPassword("vguard@123");
		usersPage.enterConfirmPassword("vguard@123");
		usersPage.selectLocationType("Plant");
		usersPage.selectLocation("VCPL - Panthnagar");
		usersPage.selectBusinessUnit("None");
		usersPage.selectAssignRole("Testing role");
		usersPage.selectActiveCheckbox();
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getAlertText(), "User name is already exists");

	}

	@Test(priority = 4)
	public void verifyMandatoryFieldValidationForAddUser() {
		SoftAssert softAssert = new SoftAssert();
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.clickOnSaveButton();
		softAssert.assertEquals(usersPage.getFirstNameFieldWarningAlert(), "The first name field is required.");
		softAssert.assertEquals(usersPage.getLastNameFieldWarningAlert(), "The last name field is required.");
		softAssert.assertEquals(usersPage.getPhoneNumberFieldWarningAlert(), "The phone number field is required.");
		softAssert.assertEquals(usersPage.getEmailFieldWarningAlert(), "The email field is required.");
		softAssert.assertEquals(usersPage.getPasswordFieldWarningAlert(), "The password field is required.");
		softAssert.assertEquals(usersPage.getConfirmPasswordFieldWarningAlert(),
				"The confirm password field is required.");
		softAssert.assertEquals(usersPage.getLocationTypeFieldWarningAlert(), "The location type field is required.");
		softAssert.assertEquals(usersPage.getLocationFieldWarningAlert(), "The location field is required.");
		softAssert.assertEquals(usersPage.getBusinessUnitFieldWarningAlert(), "The business unit field is required.");
		softAssert.assertEquals(usersPage.getAssignRoleFieldWarningAlert(), "The assign role field is required.");
		softAssert.assertAll();
		usersPage.clickOnCloseButton();
		homePage.clickOnProfileIcon();
		homePage.clickOnLogoutIcon();

	}
	
	@Test(priority = 4)
	public void verifyMandatoryFieldValidationForUpdatePassword() {
		SoftAssert softAssert = new SoftAssert();
		usersPage.searchAndClickIcon("userss", "atbs", "dasfd", "abc@yomail.com","updatePassword");
		Assert.assertTrue(usersPage.updatePasswordWindowHeading());
		usersPage.clickOnSaveButton();
		softAssert.assertEquals(usersPage.getPasswordFieldWarningAlert(), "The password field is required.");
		softAssert.assertEquals(usersPage.getConfirmPasswordFieldWarningAlert(),
				"The confirm password field is required.");
				softAssert.assertAll();
		usersPage.clickOnCloseButton();
		homePage.clickOnProfileIcon();
		homePage.clickOnLogoutIcon();

	}

	@Test(priority = 5)
	public void verifyAddUserUsingLeadingAndTrailingSpaces() {
		SoftAssert softAssert = new SoftAssert();
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		String firstName = "  atbs  ";
		usersPage.enterFirstName(firstName);
		usersPage.enterLastName("  dasfd  ");
		usersPage.enterPhoneNumber("  1234567890  ");
		usersPage.enterEmail("  abc@yomail.com  ");
		usersPage.enterUserName("  userssa  ");
		usersPage.enterPassword("  vguard@123  ");
		usersPage.enterConfirmPassword("  vguard@123  ");
		usersPage.selectLocationType("Plant");
		usersPage.selectLocation("VCPL - Panthnagar");
		usersPage.selectBusinessUnit("None");
		usersPage.selectAssignRole("Testing role");
		usersPage.selectActiveCheckbox();
		// usersPage.clickOnSaveButton();
		// Assert.assertEquals(usersPage.getAlertText(), "Successfully submitted!");
		softAssert.assertEquals(usersPage.getFirstNameFieldDoMValue(), firstName.trim());
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void verifySearchUser() throws InterruptedException, AWTException {
		
		  usersPage.enterSerachTextAndSearch("atbs");
		  clickKeyboradKeyMultipleTimes(driver, Keys.RETURN, 1); 
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ENTER);
			 * robot.keyRelease(KeyEvent.VK_ENTER);
			 */
		  usersPage.clickOnEditUserIcon();
		 
	}

	@Test(priority = 7)
	public void verifySavedUserDetailsInEditWindow() {
		SoftAssert softAssert = new SoftAssert();
		//usersPage.searchAndClickIcon("userss", "atbs", "dasfd", "abc@yomail.com","edit");
		usersPage.searchAndClickIcon("100013", "A B Traders", "Plant", "Kolkota@plant.com","edit");
		Assert.assertTrue(usersPage.editUserWindowHeading());
		String firstName = "atbs";
		String lastName = "dasfd";
		String phoneNumber = "1234567890";
		String email = "abc@yomail.com";
		String userName = "userss";
		String locationType = "Plant";
		String location = "VCPL - Panthnagar";
		String businessUnit = "None";
		String assingRole = "Testing role";
		boolean activeStatus = true;
		
		softAssert.assertEquals(usersPage.getFirstNameFieldDoMValue(), firstName);
		softAssert.assertEquals(usersPage.getLastNameFieldDoMValue(), lastName);
		softAssert.assertEquals(usersPage.getPhoneNumberFieldDoMValue(), phoneNumber);
		softAssert.assertEquals(usersPage.getEmailFieldDoMValue(), email);
		softAssert.assertEquals(usersPage.getUserNameFieldDoMValue(), userName);
		softAssert.assertEquals(usersPage.getLocationTypeFieldDoMValue(), locationType);
		softAssert.assertEquals(usersPage.getLocationFieldDoMValue(), location);
		softAssert.assertEquals(usersPage.getBusinessUnitFieldDoMValue(), businessUnit);
		softAssert.assertEquals(usersPage.getAssignRoleFieldDoMValue(), assingRole);
		softAssert.assertEquals(usersPage.getActiveCheckboxStatus(), activeStatus);
		softAssert.assertAll();
		logger.info("endign the test");
	}

	@Test
	public void verifyDeleteUser() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		boolean result = usersPage.searchAndClickIcon("userss", "atbs", "dasfd", "abc@yomail.com","delete");
		System.out.println(result);
		Thread.sleep(10000);
		softAssert.assertEquals(usersPage.getdeleteConfirmationAlertTitleText(), "Are you sure?");
		softAssert.assertEquals(usersPage.getdeleteConfirmationAlertText(), "Once deleted, you will not be able to recover this data!");
		softAssert.assertAll();
	}
	
	
	@Test(priority = 8)
	public void verifyUserInUsersModuleGridWithPagination() {
		boolean userFound = usersPage.searchRecord("40078", "Triwendra", "Joshi", "Panthnagar GRN Operations",
				"Triwendra.chandra@vguardcpl.in", "Active", "1234567890");
		Assert.assertTrue(userFound);
		if (userFound) {
			System.out.println("Test Result: PASS - User found in the grid as expected.");
		} else {
			System.out.println("Test Result: FAIL - Expected user to be found, but it was not in the grid.");
		}
		homePage.clickOnProfileIcon();
		homePage.clickOnLogoutIcon();

	}
	
	
	

}
