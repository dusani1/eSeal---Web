package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class LoginPage extends RootPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='email']")
	private WebElement emailField;

	@FindBy(xpath = "//*[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@name='rememberMe']")
	private WebElement rememberMeCheckbox;

	@FindBy(xpath = "//*[@name='cookieCheck']")
	private WebElement cookieCheckbox;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement submitButton;

	@FindBy(className = "text-danger")
	private WebElement warningMessage;

	@FindBy(className = "swal-text")
	private WebElement errorAlertText;

	@FindBy(className = "swal-button--confirm")
	private WebElement errorConfiratmionButton;

	@FindBy(xpath = "//*[text()='The email field is required.']")
	private WebElement emailFieldRequriedWarningAlert;
	
	@FindBy(xpath = "//*[text()='The password field is required.']")
	private WebElement passwordFieldRequriedWarningAlert;
	
	@FindBy(xpath = "//*[text()='The email must be a valid email address.']")
	private WebElement invalidEmailWarningAlert;
	
	@FindBy(xpath = "//*[text()='The password must be at least 6 characters.']")
	private WebElement passwordLengthWarningAlert;

	public void enterEmail(String emailText) {
		elementUtilities.enterTextIntoElement(emailField, emailText);
	}

	public void enterPassword(String passwordText) {
		elementUtilities.enterTextIntoElement(passwordField, passwordText);
	}

	public boolean isRememberMeCheckBoxSelected() {
		return elementUtilities.isElementSelected(rememberMeCheckbox);
	}

	public void clickOnRememberMeCheckBox() {
		elementUtilities.clickOnElement(rememberMeCheckbox);
	}

	public void checkRememberMeCheckBoxifNotSelected() {
		if (!isRememberMeCheckBoxSelected()) {
			clickOnRememberMeCheckBox();
		}
	}

	public String getRememberMeLabelText() {
		return elementUtilities.getTextFromElement(rememberMeCheckbox);
	}

	public boolean isCookieCheckBoxSelected() {
		return elementUtilities.isElementSelected(cookieCheckbox);
	}

	public void clickOnCookieCheckBox() {
		elementUtilities.clickOnElement(cookieCheckbox);
	}

	public void checkCookieCheckBoxifNotSelected() {
		if (!isCookieCheckBoxSelected()) {
			clickOnCookieCheckBox();
		}
	}

	public String getCookieLabelText() {
		return elementUtilities.getTextFromElement(cookieCheckbox);
	}

	public HomePage clickOnSubmitButton() {
		elementUtilities.clickOnElement(submitButton);
		return new HomePage(driver);
	}

	public String getErrorMessage() {
		return elementUtilities.getTextFromElement(errorAlertText);
	}

	public void clickOnOkInErrorWindow() {
		elementUtilities.clickOnElement(errorConfiratmionButton);
	}

	public WebElement getErrorAlertWindow() {
		return errorAlertText;

	}

	public boolean displayedEmailFieldRequriedWarningAlert() {
		return emailFieldRequriedWarningAlert.isDisplayed();
		
	}
	
	public boolean displayedPasswordFieldRequriedWarningAlert() {
		return passwordFieldRequriedWarningAlert.isDisplayed();
		
	}
	
	public boolean displayedinvalidEmailWarningAlert() {
		return invalidEmailWarningAlert.isDisplayed();
		
	}
	
	public boolean displayedPasswordLengthWarningAlert() {
		return passwordLengthWarningAlert.isDisplayed();
		
	}
	
	
}
