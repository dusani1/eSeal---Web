package test;

import java.awt.AWTException;

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
	SoftAssert softAssert;

	@BeforeMethod(alwaysRun = true)
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
			Assert.assertEquals(getUrl(), getExpectedPageURL("usersPageUrl"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Setup method failed due to exception: " + e.getMessage());
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		quitBrowser(driver);
	}

	@Test(priority = 1, groups = { "Smoke" })
	public void verifyNavigationToUsersModule() {
		Assert.assertEquals(usersPage.usersPageHeading(), prop.getProperty("usersPageHeading"));
		homePage.clickOnProfileIcon();
		homePage.clickOnLogoutIcon();

	}

	@Test(groups = "debug")
	public void verifyUsersModuleDetails() {
		softAssert = new SoftAssert();
		softAssert.assertEquals(getPageTitle(), prop.getProperty("usersPageTitle"), "Users Page Title Mismatched");
		softAssert.assertEquals(getUrl(), getExpectedPageURL("usersPageUrl"), "Users Page URL is mismatched");
		softAssert.assertEquals(usersPage.usersPageHeading(), prop.getProperty("usersPageHeading1"),
				"Users Page Heading mismatchd");
		softAssert.assertAll();
	}

	public void verifyUsersModuleHeaderSection() {
		// eSeal logo
		// Customer logo
		// Expand button
		// profile icon
		// loged in mail

	}

	@Test
	public void verifyUsersModuleFooterSection() {
		Assert.assertEquals(usersPage.getfooterSectionText(), "© 2025, Eseal.io");
	}

	@Test
	public void verifyNavigationToAddUserPage() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
	}

	@Test
	public void verifyFieldLabelAndAsteriskSymbolForMandatoryFieldsInAddUserPage() {
		softAssert = new SoftAssert();
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		softAssert.assertEquals(usersPage.getFirstNameFieldLabelText(), "First Name*",
				"First Name field label mismached");
		softAssert.assertEquals(usersPage.getLasttNameFieldLabelText(), "Last Name*",
				"Last Name field label mismached");
		softAssert.assertEquals(usersPage.getPhoneNumberrFieldLabelText(), "Phone Number*",
				"Phone Number field label mismached");
		softAssert.assertEquals(usersPage.getEmailFieldLabelText(), "Email*", "Email field label mismached");
		softAssert.assertEquals(usersPage.getUserNameFieldLabelText(), "User Name*", "User Name field label mismached");
		softAssert.assertEquals(usersPage.getPasswordFieldLabelText(), "Password*", "Password field label mismached");
		softAssert.assertEquals(usersPage.getConfirmPasswordFieldLabelText(), "Confirm Password*",
				"Confirm Password field label mismached");
		softAssert.assertEquals(usersPage.getLocationTypeFieldLabelText(), "Location Type*",
				"Location Type field label mismached");
		softAssert.assertEquals(usersPage.getLocationFieldLabelText(), "Location*", "Location field label mismached");
		softAssert.assertEquals(usersPage.getBusinessUnitFieldLabelText(), "Business Unit*",
				"Business Unit field label mismached");
		softAssert.assertEquals(usersPage.getAssignRoleFieldLabelText(), "Assign Role*",
				"Assign Role field label mismached");
		softAssert.assertEquals(usersPage.getActiveCheckboxLabelText(), "Active*", "Active field label mismached");
		softAssert.assertAll();

	}

	@Test
	public void verifyAddUserFormFieldPlaceholders() {
		softAssert = new SoftAssert();
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		softAssert.assertEquals(usersPage.getFirstNameFieldPlaceholderText(), "First Name",
				"First Name field placeholder text mismached");
		softAssert.assertEquals(usersPage.getLasttNameFieldPlaceholderText(), "Last Name",
				"Last Name field placeholder text mismached");
		softAssert.assertEquals(usersPage.getPhoneNumberrFieldPlaceholderText(), "Phone Number",
				"Phone Number placeholder text label mismached");
		softAssert.assertEquals(usersPage.getEmailFieldPlaceholderText(), "Email",
				"Email field placeholder text mismached");
		softAssert.assertEquals(usersPage.getUserNameFieldPlaceholderText(), "User Name",
				"FUser Name field placeholder text mismached");
		softAssert.assertEquals(usersPage.getPasswordFieldPlaceholderText(), "Password",
				"Password field placeholder text mismached");
		softAssert.assertEquals(usersPage.getConfirmPasswordFieldPlaceholderText(), "Confirm Password",
				"Confirm Password field placeholder text mismached");
		softAssert.assertEquals(usersPage.getLocationTypeFieldPlaceholderText(), "Please Select",
				"Location Type field placeholder text mismached");
		softAssert.assertEquals(usersPage.getLocationFieldPlaceholderText(), "Please Select",
				"Location field placeholder text mismached");
		softAssert.assertEquals(usersPage.getBusinessUnitFieldPlaceholderText(), "Please Select",
				"Business Unit field placeholder text mismached");
		softAssert.assertEquals(usersPage.getAssignRoleFieldPlaceholderText(), "Please Select",
				"Assign Role field placeholder text mismached");
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void verifyMandatoryFieldAlertsInAddUser() {
		softAssert = new SoftAssert();
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

	@Test
	public void verifyAddUserWithValidData() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "1234567890", "abc@yomail.com", "userss", "vguard@123", "vguard@123",
				"Plant", "VCPL - Panthnagar", "None", "Testing role");
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getAlertText(), "Successfully submitted!");

	}

	@Test
	public void verifyAddUserWithExistingUserName() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "1234567890", "abc@yomail.com", "userss", "vguard@123", "vguard@123",
				"Plant", "VCPL - Panthnagar", "None", "Testing role");
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getAlertText(), "User name is already exists");

	}

	@Test
	public void verifyAddUserWithExistingEmail() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "1234567890", "abc@yomail.com", "userss", "vguard@123", "vguard@123",
				"Plant", "VCPL - Panthnagar", "None", "Testing role");
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getAlertText(), "Email is already exists");
	}

	@Test
	public void verifyAddUserWithMismatchedPassword() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "1234567890", "abc@yomail.com", "userss", "vguard@123", "mismatchpwd",
				"Plant", "VCPL - Panthnagar", "None", "Testing role");
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getConfirmPasswordFieldWarningAlert(), "Passwords need to match!");

	}

	@Test
	public void verifyAddUserWithInvalidEmailFormat() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "1234567890", "4938JOi43maijsa", "userss", "vguard@123", "vguard@123",
				"Plant", "VCPL - Panthnagar", "None", "Testing role");
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getEmailFieldWarningAlert(), "The email must be a valid email address.");
	}

	@Test
	public void verifyAddUserWithInvalidPhoneNumber() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "123453324567890", "abc@yomail.com", "userss", "vguard@123",
				"vguard@123", "Plant", "VCPL - Panthnagar", "None", "Testing role");
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getPhoneNumberFieldWarningAlert(),
				"The phone number must be a valid phone number.");

	}

	@Test
	public void verifyAddUserWithLongUserName() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "1234567890", "abc@yomail.com",
				"userssdkfoeiriojasdlkfjoieoaifdjoiase32", "vguard@123", "vguard@123", "Plant", "VCPL - Panthnagar",
				"None", "Testing role");
		usersPage.clickOnSaveButton();
		Assert.assertEquals(usersPage.getUserNameFieldWarningAlert(),
				"The user name may not be greater than 20 characters.");

	}

	@Test
	public void verifyAddUserWithEmptySpacesInFields() {
		softAssert = new SoftAssert();
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("  ", "  ", "  ", "  ", "  ", "  ", "  ", "Plant", "VCPL - Panthnagar", "None",
				"Testing role");
		usersPage.clickOnSaveButton();
		softAssert.assertEquals(usersPage.getFirstNameFieldWarningAlert(), "The first name field is required.");
		softAssert.assertEquals(usersPage.getLastNameFieldWarningAlert(), "The last name field is required.");
		softAssert.assertEquals(usersPage.getPhoneNumberFieldWarningAlert(), "The phone number field is required.");
		softAssert.assertEquals(usersPage.getEmailFieldWarningAlert(), "The email field is required.");
		softAssert.assertEquals(usersPage.getPasswordFieldWarningAlert(), "The password field is required.");
		softAssert.assertEquals(usersPage.getConfirmPasswordFieldWarningAlert(),
				"The confirm password field is required.");
		softAssert.assertAll();

	}

	public void verifyAddUserWithTrillingSpaces() {

	}

	@Test
	public void verifyCloseAddUserWithoutEnteringDetailsUsingCloseButton() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.clickOnCloseButton();
		Assert.assertFalse(usersPage.addUserWindowHeading());

	}

	@Test
	public void verifyCloseAddUserWithoutEnteringDetailsUsingCloseIcon() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.clickOnCloseIcon();
		Assert.assertFalse(usersPage.addUserWindowHeading());
	}

	@Test
	public void verifyCloseAddUserUsingCloseButtonWithEnterDeatils() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "1234567890", "abc@yomail.com", "userss", "vguard@123", "vguard@123",
				"Plant", "VCPL - Panthnagar", "None", "Testing role");
		usersPage.clickOnCloseButton();
		Assert.assertFalse(usersPage.addUserWindowHeading());
	}

	@Test
	public void verifyCloseAddUserUsingCloseIconWithEnterDeatils() {
		usersPage.clickOnAddUserButton();
		Assert.assertTrue(usersPage.addUserWindowHeading());
		usersPage.fillUserForm("atbs", "dasfd", "1234567890", "abc@yomail.com", "userss", "vguard@123", "vguard@123",
				"Plant", "VCPL - Panthnagar", "None", "Testing role");
		usersPage.clickOnCloseIcon();
		Assert.assertFalse(usersPage.addUserWindowHeading());
	}

	public void verifyVerticalScrollInAddUserPage() {

	}

	@Test(priority = 4)
	public void verifyMandatoryFieldValidationForUpdatePassword() {
		SoftAssert softAssert = new SoftAssert();
		usersPage.searchAndClickIcon("userss", "atbs", "dasfd", "abc@yomail.com", "updatePassword");
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
		usersPage.fillUserForm(firstName, " dasfd ", "  1234567890 ", "  abc@yomail.com  ", " userss ", " vguard@123",
				" vguard@123", "Plant", "VCPL - Panthnagar", "None", "Testing role");

		// usersPage.clickOnSaveButton();
		// Assert.assertEquals(usersPage.getAlertText(), "Successfully submitted!");
		softAssert.assertEquals(usersPage.getFirstNameFieldDoMValue(), firstName.trim());
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void verifySearchUser() throws InterruptedException, AWTException {

		usersPage.enterSerachTextAndSearch("atbs");
		clickKeyboradKeyMultipleTimes(driver, Keys.RETURN, 1);
		usersPage.clickOnEditUserIcon();

	}

	@Test(priority = 7)
	public void verifySavedUserDetailsInEditWindow() {
		SoftAssert softAssert = new SoftAssert();
		// usersPage.searchAndClickIcon("userss", "atbs", "dasfd",
		// "abc@yomail.com","edit");
		usersPage.searchAndClickIcon("100013", "A B Traders", "Plant", "Kolkota@plant.com", "edit");
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
		boolean result = usersPage.searchAndClickIcon("userss", "atbs", "dasfd", "abc@yomail.com", "delete");
		System.out.println(result);
		Thread.sleep(10000);
		softAssert.assertEquals(usersPage.getdeleteConfirmationAlertTitleText(), "Are you sure?");
		softAssert.assertEquals(usersPage.getdeleteConfirmationAlertText(),
				"Once deleted, you will not be able to recover this data!");
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

	@Test
	public void verifyPaginationControlsPresence() {
		usersPage.isPaginationPresence();
	}

	
}
