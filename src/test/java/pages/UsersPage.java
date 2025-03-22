package pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "(//button[@type='button' and contains(@aria-label, 'Go to page')])[last()]")
	private WebElement lastPageNumberElement;

	@FindBy(xpath = "//table//tbody//tr")
	List<WebElement> rows;

	@FindBy(xpath = "//button[@aria-label=\"Go to next page\"]")
	private WebElement nextPageIcon;

	@FindBy(xpath = "//div[@class='swal-title']")
	private WebElement deleteConfirmationAlertTitleText;

	@FindBy(xpath = "//div[@class='swal-text']")
	private WebElement deleteConfirmationAlertText;

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

	public void pressEnterKey() {
		searchUserTextField.click();
		searchUserTextField.sendKeys(Keys.ENTER);
	}

	public int getLastPageCount() {
		String count = elementUtilities.getTextFromElement(lastPageNumberElement);
		return Integer.parseInt(count.trim());
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

	private void clickIcon(int rowIndex, int pageNumber, String iconType) {
		String iconXpath = getIconXpath(rowIndex, iconType);
		System.out.println("Currently processing row " + rowIndex + " on page " + pageNumber);
		System.out.println("XPath generated for " + iconType + " icon: " + iconXpath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(iconXpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", icon);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
				icon);
		icon.click();
	}

	private String getIconXpath(int rowIndex, String iconType) {
		switch (iconType) {
		case "edit":
			return "//table//tbody//tr[" + rowIndex + "]//td//p//div//i[@class='fa fa-pencil-square-o fa-edit']";
		case "delete":
			return "//table//tbody//tr[" + rowIndex + "]//td//p//div//i[@class='fa fa-trash-o fa-delete']";
		case "updatePassword":
			return "//table//tbody//tr[" + rowIndex + "]//td//p//div//i[@class='fa fa-key']";
		default:
			throw new IllegalArgumentException("Unknown icon type: " + iconType);
		}
	}

	public void goToNextPage(int pageNumber) {
		String pageNoXpathText = "//button[@type='button' and contains(@aria-label, 'Go to page " + pageNumber + "')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// Locate the next page button
			WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pageNoXpathText)));
			// Scroll into view & click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextPageButton);
			nextPageButton.click();
			// Wait for the page to load (using any element that confirms page load)
			wait.until(ExpectedConditions.stalenessOf(nextPageButton));
		} catch (Exception e) {
			System.out.println("Exception in pagination: " + e.getMessage());
		}
	}

	public int getColumnIndex(String columnName) {
		if (columnName == null || columnName.trim().isEmpty()) {
			throw new IllegalArgumentException("Column name cannot be null or empty.");
		}

		List<WebElement> headers = driver.findElements(By.xpath("//table//thead//th"));
		int headerCount = headers.size();
		if (headerCount == 0) {
			throw new NoSuchElementException("No headers found in the table.");
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int j = 0; j < headerCount; j++) {
			WebElement header = headers.get(j);
			String headerText = header.getText().trim();

			// Use JavaScript fallback if necessary
			if (headerText.isEmpty()) {
				headerText = (String) js.executeScript("return arguments[0].textContent.trim();", header);
			}

			// Normalize header text: remove trailing numbers and spaces
			headerText = headerText.replaceAll("\\s*\\d+$", "").trim();

			// System.out.println("Normalized Header: [" + headerText + "] at index " + (j +
			// 1));

			// Case-insensitive and trimmed comparison
			if (headerText.equalsIgnoreCase(columnName.trim())) {
				return j + 1; // Return 1-based index
			}
		}

		throw new NoSuchElementException("Column '" + columnName + "' not found in the table.");
	}

}