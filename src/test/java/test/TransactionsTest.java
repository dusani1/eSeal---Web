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
import pages.TransactionsPage;

public class TransactionsTest extends Base {

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public TransactionsPage transactionPage;

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
			homePage.clickOnCompaniesOption();
			transactionPage = homePage.clickOnTransactionsOption();
			Assert.assertEquals(getPageTitle(), prop.getProperty("transactionsPageTitle"));
			Assert.assertEquals(getUrl(), getExpectedPageURL("transactionsPageUrl"));
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
		Assert.assertEquals(transactionPage.transactionsPageHeading(), prop.getProperty("transactionsPageHeading"));
		homePage.clickOnProfileIcon();
		homePage.clickOnLogoutIcon();

	}

	@Test(priority = 2, groups= {"Smoke"})
	public void verifyAddTransactionWithValidData() {
		transactionPage.clickOnAddTransactionButton();
		Assert.assertTrue(transactionPage.addTransactionWindowHeading());
		transactionPage.enterTransactionName("Testabc");
		transactionPage.enterDescription("AT1");
		transactionPage.enterActionCode("ABC");
		transactionPage.selectSourceLocationAction("1");
		transactionPage.selectDestinationLocationAction("0");
		transactionPage.selectIntransitAction("0");
		transactionPage.enterFeatureCode("AT1");
		transactionPage.enterGroup("Dummy");
		transactionPage.clickOnSaveButton();
		Assert.assertEquals(transactionPage.getAlertText(), "Successfully submitted!");

	}

	@Test(priority = 3)
	public void verifyAddUserWithDuplicateTransactionName() {
		transactionPage.clickOnAddTransactionButton();
		Assert.assertTrue(transactionPage.addTransactionWindowHeading());
		transactionPage.enterTransactionName("BT QR Printing");
		transactionPage.enterDescription("AT1");
		transactionPage.enterActionCode("ABC");
		transactionPage.selectSourceLocationAction("1");
		transactionPage.selectDestinationLocationAction("0");
		transactionPage.selectIntransitAction("0");
		transactionPage.enterFeatureCode("AT11");
		transactionPage.enterGroup("Dummy");
		transactionPage.clickOnSaveButton();
		Assert.assertEquals(transactionPage.getAlertText(), "Transaction Name already exists");

	}

	@Test(priority = 4)
	public void verifyAddUserWithDuplicateFeatureCode() {
		transactionPage.clickOnAddTransactionButton();
		Assert.assertTrue(transactionPage.addTransactionWindowHeading());
		transactionPage.enterTransactionName("abvd");
		transactionPage.enterDescription("AT1");
		transactionPage.enterActionCode("ABC1");
		transactionPage.selectSourceLocationAction("1");
		transactionPage.selectDestinationLocationAction("0");
		transactionPage.selectIntransitAction("0");
		transactionPage.enterFeatureCode("FPCBLP1");
		transactionPage.enterGroup("Dummy");
		transactionPage.clickOnSaveButton();
		Assert.assertEquals(transactionPage.getAlertText(), "Feature Code already exists");

	}

	@Test(priority = 5)
	public void verifyMandatoryFieldValidationForAddUser() {
		SoftAssert softAssert = new SoftAssert();
		transactionPage.clickOnAddTransactionButton();
		Assert.assertTrue(transactionPage.addTransactionWindowHeading());
		transactionPage.clickOnSaveButton();
		softAssert.assertEquals(transactionPage.getTransactionNameFieldWarningAlert(),
				"The transaction name field is required.");
		softAssert.assertEquals(transactionPage.getDescriptionFieldWarningAlert(), "");
		softAssert.assertEquals(transactionPage.getActionCodeFieldWarningAlert(), "The action code field is required.");
		softAssert.assertEquals(transactionPage.getSourceLocationFieldWarningAlert(),
				"The source location field is required.");
		softAssert.assertEquals(transactionPage.getDestinationLocationFieldWarningAlert(),
				"The destination location field is required.");
		softAssert.assertEquals(transactionPage.getIntransitActionFieldWarningAlert(),
				"The intransit action field is required.");
		softAssert.assertEquals(transactionPage.getFeatureCodeFieldWarningAlert(),
				"The feature code field is required.");
		softAssert.assertEquals(transactionPage.getGroupFieldWarningAlert(), "");
		softAssert.assertAll();
		transactionPage.clickOnCloseButton();
		homePage.clickOnProfileIcon();
		homePage.clickOnLogoutIcon();

	}

	@Test(priority = 6)
	public void verifyAddUserUsingLeadingAndTrailingSpaces() {
		SoftAssert softAssert = new SoftAssert();
		transactionPage.clickOnAddTransactionButton();
		Assert.assertTrue(transactionPage.addTransactionWindowHeading());
		String transactionName = " Testabc ";
		transactionPage.enterTransactionName(transactionName);
		transactionPage.enterDescription("AT1");
		transactionPage.enterActionCode("ABC");
		transactionPage.selectSourceLocationAction("1");
		transactionPage.selectDestinationLocationAction("0");
		transactionPage.selectIntransitAction("0");
		transactionPage.enterFeatureCode("AT1");
		transactionPage.enterGroup("Dummy");
		// transactionPage.clickOnSaveButton();
		// usersPage.clickOnSaveButton();
		// Assert.assertEquals(usersPage.getAlertText(), "Successfully submitted!");
		softAssert.assertEquals(transactionPage.getTransactionNameFieldDoMValue(), transactionName.trim());
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void verifySavedTransactionDetailsInEditWindow() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		transactionPage.searchAndClickIcon("Testabc", "AT1", "edit");
		Thread.sleep(2000);
		Assert.assertTrue(transactionPage.editTransactionWindowHeading());
		String transactionName = "Testabc";
		String description = "AT1";
		String action = "ABC";
		String sourceLocationAction = "1";
		String destLocAction = "0";
		String intransitAction = "0";
		String featureCode = "AT1";
		String group = "Dummy";

		softAssert.assertEquals(transactionPage.getTransactionNameFieldDoMValue(), transactionName);
		softAssert.assertEquals(transactionPage.getDescriptionFieldDoMValue(), description);
		softAssert.assertEquals(transactionPage.getActionFieldDoMValue(), action);
		softAssert.assertEquals(transactionPage.getSourceLocationActionFieldDoMValue(), sourceLocationAction);
		softAssert.assertEquals(transactionPage.getDestinationLocationActionFieldDoMValue(), destLocAction);
		softAssert.assertEquals(transactionPage.getIntransitActionFieldDoMValue(), intransitAction);
		softAssert.assertEquals(transactionPage.getFeatureCodeFieldDoMValue(), featureCode);
		softAssert.assertEquals(transactionPage.getGroupFieldDoMValue(), group);
		softAssert.assertAll();
	}

	@Test(priority = 8)
	public void verifyUserInUsersModuleGridWithPagination() {
		boolean transactionFound = transactionPage.searchRecord("Testabc", "ABC", "AT1");
		Assert.assertTrue(transactionFound);
		if (transactionFound) {
			System.out.println("Test Result: PASS - Transaction found in the grid as expected.");
		} else {
			System.out.println("Test Result: FAIL - Expected Transaction to be found, but it was not in the grid.");
		}
		homePage.clickOnProfileIcon();
		homePage.clickOnLogoutIcon();

	}

	@Test(priority = 9)
	public void verifyDeleteUser() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		transactionPage.searchAndClickIcon("Testabc", "AT1", "delete");
		Thread.sleep(3000);
		softAssert.assertEquals(transactionPage.getdeleteConfirmationAlertTitleText(), "Are you sure?");
		softAssert.assertEquals(transactionPage.getdeleteConfirmationAlertText(),
				"Once deleted, you will not be able to recover this data!");
		softAssert.assertAll();
	}

}
