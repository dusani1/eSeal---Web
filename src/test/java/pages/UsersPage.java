package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class UsersPage extends RootPage {

	public UsersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h4[text()='User']")
	private WebElement userPageHeading;

	@FindBy(xpath = "//p[normalize-space()='User']")
	private WebElement addUserButton;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@placeholder='Email Id']")
	private WebElement emailFieldInEditUser;

	@FindBy(xpath = "//input[@placeholder='User Name']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//*[text()='Location Type*']/following-sibling::div/div/select")
	private WebElement locationTypeDropdown;

	@FindBy(xpath = "//*[text()='Location*']/following-sibling::div/div/select")
	private WebElement locationDropdown;

	@FindBy(xpath = "//*[text()='Business Unit*']/following-sibling::div/div/select")
	private WebElement businessUnitDropdown;

	@FindBy(xpath = "//*[text()='Assign Role*']/following-sibling::div/div/select")
	private WebElement assignRoleDropdown;

	@FindBy(xpath = "//*[@Placeholder='Active']")
	private WebElement activeCheckbox;

	@FindBy(xpath = "//h4[text()='Add']")
	private WebElement addUserWindow;

	@FindBy(xpath = "//h4[text()='Edit']")
	private WebElement editUserWindow;

	@FindBy(xpath = "//h4[text()='Update']")
	private WebElement updatePasswordWindow;

	@FindBy(xpath = "//*[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[text()='Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//span[@class=\"close-icon-custom\"]")
	private WebElement closeIcon;

	@FindBy(xpath = "//input[@placeholder='First Name']//following-sibling::span")
	private WebElement firstNameFieldWarningAlert;

	@FindBy(xpath = "//input[@placeholder='Last Name']//following-sibling::span")
	private WebElement lastNameWarningAlert;

	@FindBy(xpath = "//input[@placeholder='Phone Number']//following-sibling::span")
	private WebElement phoneNumberWarningAlert;

	@FindBy(xpath = "//input[@placeholder='Email']//following-sibling::span")
	private WebElement emailWarningAlert;

	@FindBy(xpath = "//input[@placeholder='User Name']//following-sibling::span")
	private WebElement userNameWarningAlert;

	@FindBy(xpath = "//input[@placeholder='Password']//following-sibling::span")
	private WebElement passwordWarningAlert;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']//following-sibling::span")
	private WebElement confirmPasswordWarningAlert;

	@FindBy(xpath = "//*[text()='Location Type*']/following-sibling::div//select/following-sibling::span")
	private WebElement locationTypeWarningAlert;

	@FindBy(xpath = "//*[text()='Location*']/following-sibling::div//select/following-sibling::span")
	private WebElement locationWarningAlert;

	@FindBy(xpath = "//*[text()='Business Unit*']/following-sibling::div//select/following-sibling::span")
	private WebElement businessUnitWarningAlert;

	@FindBy(xpath = "//*[text()='Assign Role*']/following-sibling::div//select/following-sibling::span")
	private WebElement assignRoleWarningAlert;

	@FindBy(xpath = "//table//tbody//tr[1]//td//p//div//i[@class='fa fa-pencil-square-o fa-edit']")
	private WebElement editUserIcon;

	@FindBy(xpath = "//table//tbody//tr[1]//td//p//div//i[@class='fa fa-key']")
	private WebElement editPasswordIcon;

	@FindBy(xpath = "//table//tbody//tr[1]//td//p//div//i[@class='fa fa-trash-o fa-delete']")
	private WebElement deleteIcon;

	@FindBy(xpath = "//input[contains(@placeholder, 'Search User')]")
	private WebElement searchUserTextField;

	@FindBy(xpath = "//button[@aria-label='Clear search']")
	private WebElement clearSearchIcon;

	@FindBy(xpath = "//div[@class='swal-text']")
	private WebElement alertTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='First Name*']")
	private WebElement firstNameFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Last Name*']")
	private WebElement lastNameFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Phone Number*']")
	private WebElement phoneNumberFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Email*']")
	private WebElement emailFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='User Name*']")
	private WebElement userNameFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Password*']")
	private WebElement passwordFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Confirm Password*']")
	private WebElement confirmPasswordFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Location Type*']")
	private WebElement locationTypeFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Location*']")
	private WebElement locationFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Business Unit*']")
	private WebElement businessUnitFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Assign Role*']")
	private WebElement assingRoleFieldLabelTextElement;

	@FindBy(xpath = "//label[@class='Label' and text()='Active*']")
	private WebElement ActiveCheckboxLabelTextElement;

	@FindBy(xpath = "//table//tbody//tr")
	List<WebElement> rows;

	@FindBy(xpath = "//button[@aria-label=\"Go to next page\"]")
	private WebElement nextPageIcon;

	@FindBy(xpath = "//div[@class='swal-title']")
	private WebElement deleteConfirmationAlertTitleText;

	@FindBy(xpath = "//div[@class='swal-text']")
	private WebElement deleteConfirmationAlertText;
	
	@FindBy(xpath="//*[@aria-label='pagination navigation']")
	private WebElement paginationElement;
	
	public boolean isPaginationPresence() {
		return elementUtilities.isElementDisplayed(paginationElement);
	}

	public String usersPageHeading() {
		String pageHeading = elementUtilities.getElementText(userPageHeading);
		return pageHeading;
	}

	public void clickOnAddUserButton() {
		elementUtilities.clickOnElement(addUserButton);
	}

	public void enterFirstName(String firstName) {
		elementUtilities.enterTextIntoElement(firstNameField, firstName);

	}

	public void enterLastName(String lastName) {
		elementUtilities.enterTextIntoElement(lastNameField, lastName);

	}

	public void enterPhoneNumber(String phoneNumber) {
		elementUtilities.enterTextIntoElement(phoneNumberField, phoneNumber);

	}

	public void enterEmail(String email) {
		elementUtilities.enterTextIntoElement(emailField, email);

	}

	public void enterUserName(String userName) {
		elementUtilities.enterTextIntoElement(userNameField, userName);

	}

	public void enterPassword(String password) {
		elementUtilities.enterTextIntoElement(passwordField, password);

	}

	public void enterConfirmPassword(String confirmPassword) {
		elementUtilities.enterTextIntoElement(confirmPasswordField, confirmPassword);

	}

	public void selectLocationType(String locationType) {

		elementUtilities.selectOptionFromDropdownFieldUsingVisibleText(locationTypeDropdown, locationType);

	}

	public void selectLocation(String location) {

		elementUtilities.selectOptionFromDropdownFieldUsingVisibleText(locationDropdown, location);

	}

	public void selectBusinessUnit(String businessUnit) {

		elementUtilities.selectOptionFromDropdownFieldUsingVisibleText(businessUnitDropdown, businessUnit);

	}

	public void selectAssignRole(String assignRole) {

		elementUtilities.selectOptionFromDropdownFieldUsingVisibleText(assignRoleDropdown, assignRole);

	}

	public void selectActiveCheckbox() {
		if (!elementUtilities.isElementSelected(activeCheckbox)) {
			activeCheckbox.click();
		}
	}

	public void deSelectActiveCheckbox() {
		if (elementUtilities.isElementSelected(activeCheckbox)) {
			activeCheckbox.click();
		}
	}

	public void clickOnSaveButton() {
		elementUtilities.clickOnElement(saveButton);
	}

	public void clickOnCloseButton() {
		elementUtilities.clickOnElement(closeButton);
	}

	public void clickOnCloseIcon() {
		elementUtilities.clickOnElement(closeIcon);
	}

	public boolean addUserWindowHeading() {
		return elementUtilities.waitAndCheckElementDisplayStatus(addUserWindow, 5);
	}

	public boolean editUserWindowHeading() {
		return elementUtilities.waitAndCheckElementDisplayStatus(editUserWindow, 5);
	}

	public boolean updatePasswordWindowHeading() {
		return elementUtilities.waitAndCheckElementDisplayStatus(updatePasswordWindow, 5);
	}

	public String getFirstNameFieldWarningAlert() {
		return elementUtilities.getElementText(firstNameFieldWarningAlert);
	}

	public String getLastNameFieldWarningAlert() {
		return elementUtilities.getElementText(lastNameWarningAlert);
	}

	public String getPhoneNumberFieldWarningAlert() {
		return elementUtilities.getElementText(phoneNumberWarningAlert);
	}

	public String getEmailFieldWarningAlert() {
		return elementUtilities.getElementText(emailWarningAlert);
	}

	public String getUserNameFieldWarningAlert() {
		return elementUtilities.getElementText(userNameWarningAlert);
	}

	public String getPasswordFieldWarningAlert() {
		return elementUtilities.getElementText(passwordWarningAlert);
	}

	public String getConfirmPasswordFieldWarningAlert() {
		return elementUtilities.getElementText(confirmPasswordWarningAlert);
	}

	public String getLocationTypeFieldWarningAlert() {
		return elementUtilities.getElementText(locationTypeWarningAlert);
	}

	public String getLocationFieldWarningAlert() {
		return elementUtilities.getElementText(locationWarningAlert);
	}

	public String getBusinessUnitFieldWarningAlert() {
		return elementUtilities.getElementText(businessUnitWarningAlert);
	}

	public String getAssignRoleFieldWarningAlert() {
		return elementUtilities.getElementText(assignRoleWarningAlert);
	}

	public String getAlertText() {
		elementUtilities.waitAndCheckElementDisplayStatus(alertTextElement, 5);
		return elementUtilities.getElementText(alertTextElement);

	}

	public String getFirstNameFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(firstNameField, "value");
	}

	public String getLastNameFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(lastNameField, "value");
	}

	public String getPhoneNumberFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(phoneNumberField, "value");
	}

	public String getEmailFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(emailFieldInEditUser, "value");
	}

	public String getUserNameFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(userNameField, "value");
	}

	public String getPasswordFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(passwordField, "value");
	}

	public String getConfirmPasswordFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(confirmPasswordField, "value");
	}

	public String getLocationTypeFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(locationTypeDropdown, "value");
	}

	public String getLocationFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(locationDropdown, "value");
	}

	public String getBusinessUnitFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(businessUnitDropdown, "value");
	}

	public String getAssignRoleFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(assignRoleDropdown, "value");
	}

	public boolean getActiveCheckboxStatus() {
		return elementUtilities.isElementSelected(activeCheckbox);
	}

	public void clickOnEditUserIcon() {
		elementUtilities.waitForElementAndClick(editUserIcon, 10);
	}

	public void enterSerachTextAndSearch(String searchText) {
		elementUtilities.enterTextIntoElement(searchUserTextField, searchText);

	}

	public String getdeleteConfirmationAlertTitleText() {
		return elementUtilities.getElementText(deleteConfirmationAlertTitleText);
	}

	public String getdeleteConfirmationAlertText() {
		return elementUtilities.getElementText(deleteConfirmationAlertText);
	}

	public String getFirstNameFieldPlaceholderText() {
		return elementUtilities.getPlaceholderValue(firstNameField);
	}

	public String getLasttNameFieldPlaceholderText() {
		return elementUtilities.getPlaceholderValue(lastNameField);
	}

	public String getPhoneNumberrFieldPlaceholderText() {
		return elementUtilities.getPlaceholderValue(phoneNumberField);
	}

	public String getEmailFieldPlaceholderText() {
		return elementUtilities.getPlaceholderValue(emailField);
	}

	public String getUserNameFieldPlaceholderText() {
		return elementUtilities.getPlaceholderValue(userNameField);
	}

	public String getPasswordFieldPlaceholderText() {
		return elementUtilities.getPlaceholderValue(passwordField);
	}

	public String getConfirmPasswordFieldPlaceholderText() {
		return elementUtilities.getPlaceholderValue(confirmPasswordField);
	}

	public String getLocationTypeFieldPlaceholderText() {
		return elementUtilities.getDropdownPlaceholder(locationTypeDropdown);
	}

	public boolean validateLocationTypeFieldPlaceholderText() {
		return elementUtilities.validateDropdownPlaceholder(locationTypeDropdown, "Please Select");
	}

	public String getLocationFieldPlaceholderText() {
		return elementUtilities.getDropdownPlaceholder(locationDropdown);
	}

	public String getBusinessUnitFieldPlaceholderText() {
		return elementUtilities.getDropdownPlaceholder(businessUnitDropdown);
	}

	public String getAssignRoleFieldPlaceholderText() {
		return elementUtilities.getDropdownPlaceholder(assignRoleDropdown);
	}

	public String getFirstNameFieldLabelText() {
		return elementUtilities.getTextFromElement(firstNameFieldLabelTextElement);
	}

	public String getLasttNameFieldLabelText() {
		return elementUtilities.getTextFromElement(lastNameFieldLabelTextElement);
	}

	public String getPhoneNumberrFieldLabelText() {
		return elementUtilities.getTextFromElement(phoneNumberFieldLabelTextElement);
	}

	public String getEmailFieldLabelText() {
		return elementUtilities.getTextFromElement(emailFieldLabelTextElement);
	}

	public String getUserNameFieldLabelText() {
		return elementUtilities.getTextFromElement(userNameFieldLabelTextElement);
	}

	public String getPasswordFieldLabelText() {
		return elementUtilities.getTextFromElement(passwordFieldLabelTextElement);
	}

	public String getConfirmPasswordFieldLabelText() {
		return elementUtilities.getTextFromElement(confirmPasswordFieldLabelTextElement);
	}

	public String getLocationTypeFieldLabelText() {
		return elementUtilities.getTextFromElement(locationTypeFieldLabelTextElement);
	}

	public String getLocationFieldLabelText() {
		return elementUtilities.getTextFromElement(locationFieldLabelTextElement);
	}

	public String getBusinessUnitFieldLabelText() {
		return elementUtilities.getTextFromElement(businessUnitFieldLabelTextElement);
	}

	public String getAssignRoleFieldLabelText() {
		return elementUtilities.getTextFromElement(assingRoleFieldLabelTextElement);
	}

	public String getActiveCheckboxLabelText() {
		return elementUtilities.getTextFromElement(ActiveCheckboxLabelTextElement);
	}

	public void pressEnterKey() {
		searchUserTextField.click();
		searchUserTextField.sendKeys(Keys.ENTER);
	}

	public String getfooterSectionText() {
		return elementUtilities.getTextFromElement(getFooterSectionTextElement());

	}

	public boolean searchRecord(String searchInputOrUserName, String firstName, String lastName, String roleName,
			String email, String status, String phoneNumber) {

		int noOfPages = getLastPageCount();
		boolean recordFound = false;

		int roleNameColumnIndex = getColumnIndex("Role Name");
		int userNameColumnIndex = getColumnIndex("User Name");
		int firstNameColumnIndex = getColumnIndex("First Name");
		int lastNameColumnIndex = getColumnIndex("Last Name");
		int emailColumnIndex = getColumnIndex("Email");
		int statusColumnIndex = getColumnIndex("Status");
		int phoneNoColumnIndex = getColumnIndex("Phone No");

		for (int p = 1; p <= noOfPages; p++) {
			for (int i = 1; i <= rows.size(); i++) {
				try {

					String actualUserName = rows.get(i - 1).findElement(By.xpath(".//td[" + userNameColumnIndex + "]"))
							.getText();
					System.out.println(actualUserName);

					if (actualUserName.equals(searchInputOrUserName)) {
						String actualRoleName = rows.get(i - 1)
								.findElement(By.xpath(".//td[" + roleNameColumnIndex + "]")).getText();
						String actualFirstName = rows.get(i - 1)
								.findElement(By.xpath(".//td[" + firstNameColumnIndex + "]")).getText();
						String actualLastName = rows.get(i - 1)
								.findElement(By.xpath(".//td[" + lastNameColumnIndex + "]")).getText();
						String actualEmail = rows.get(i - 1).findElement(By.xpath(".//td[" + emailColumnIndex + "]"))
								.getText();
						String actualStauts = rows.get(i - 1).findElement(By.xpath(".//td[" + statusColumnIndex + "]"))
								.getText();
						String actualPhoneNumber = rows.get(i - 1)
								.findElement(By.xpath(".//td[" + phoneNoColumnIndex + "]")).getText();

						if (actualFirstName.equals(firstName) && actualLastName.equals(lastName)
								&& actualRoleName.equals(roleName) && actualEmail.equals(email)
								&& actualStauts.equals(status) && actualPhoneNumber.equals(phoneNumber)) {
							recordFound = true;
							break; // Breaks out of the inner loop
						}
					}
				} catch (Exception e) {
					if (!recordFound) {
						System.out.println("Username not found in row " + i + " on page " + p);
					}
				}
			}

			if (recordFound) {
				break;
			}

			if (!recordFound && p < noOfPages) {
				goToNextPage(p + 1);
			}
		}
		return recordFound;

	}

	public boolean searchAndClickIcon(String searchInputOrUserName, String firstName, String lastName, String email,
			String iconType) {

		int noOfPages = getLastPageCount();
		boolean recordFound = false;

		int userNameColumnIndex = getColumnIndex("User Name");
		int firstNameColumnIndex = getColumnIndex("First Name");
		int lastNameColumnIndex = getColumnIndex("Last Name");
		int emailColumnIndex = getColumnIndex("Email");

		for (int p = 1; p <= noOfPages; p++) {
			for (int i = 1; i <= rows.size(); i++) {
				try {
					String actualUserName = rows.get(i - 1).findElement(By.xpath(".//td[" + userNameColumnIndex + "]"))
							.getText();
					System.out.println(actualUserName);

					if (actualUserName.equals(searchInputOrUserName)) {
						String actualFirstName = rows.get(i - 1)
								.findElement(By.xpath(".//td[" + firstNameColumnIndex + "]")).getText();
						String actualLastName = rows.get(i - 1)
								.findElement(By.xpath(".//td[" + lastNameColumnIndex + "]")).getText();
						String actualEmail = rows.get(i - 1).findElement(By.xpath(".//td[" + emailColumnIndex + "]"))
								.getText();

						if (actualFirstName.equals(firstName) && actualLastName.equals(lastName)
								&& actualEmail.equals(email)) {
							recordFound = true;
							clickIcon(i, p, iconType);
							break; // Breaks out of the inner loop
						}
					}
				} catch (Exception e) {
					if (!recordFound) {
						System.out.println("Username not found in row " + i + " on page " + p);
					}
				}
			}

			if (recordFound) {
				break;
			}

			if (!recordFound && p < noOfPages) {
				goToNextPage(p + 1);
			}
		}
		return recordFound;
	}

	public void fillUserForm(String firstName, String lastName, String phone, String email, String username,
			String password, String confirmPassword, String locationType, String location, String businessUnit,
			String assingRole) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPhoneNumber(phone);
		enterEmail(email);
		enterUserName(username);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		selectLocationType("Plant");
		selectLocation("VCPL - Panthnagar");
		selectBusinessUnit("None");
		selectAssignRole("Testing role");
		selectActiveCheckbox();
	}

}