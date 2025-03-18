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

	@FindBy(xpath = "(//label)[1]")
	private WebElement rememberMeLableText;

	@FindBy(xpath = "//*[@name='cookieCheck']")
	private WebElement cookieCheckbox;

	@FindBy(xpath = "(//label)[2]")
	private WebElement coockieLableText;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement submitButton;

	@FindBy(className = "text-danger")
	private WebElement warningMessage;

	@FindBy(className = "swal-text")
	private WebElement errorAlertText;

	@FindBy(className = "swal-button--confirm")
	private WebElement errorConfiratmionButton;

	@FindBy(xpath = "//input[@name='email']//following::p[@class='text-danger']")
	private WebElement emailFielddWarningAlert;

	@FindBy(xpath = "//input[@name='password']//following::p[@class='text-danger']")
	private WebElement passwordFieldWarningAlert;

	@FindBy(xpath = "//div[@class='forgot-password']")
	private WebElement forgotPasswordText;

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

	public String getEmailFieldWarningAlert() {
		return elementUtilities.getElementText(emailFielddWarningAlert);
	}

	public String getPasswordFieldWarningAlert() {
		return elementUtilities.getElementText(passwordFieldWarningAlert);
	}

	public String getEmailFieldLabelText() {
		return elementUtilities.getElementDomAttribute(emailField, "placeholder");
	}

	public String getPasswordFieldLabelText() {
		return elementUtilities.getElementDomAttribute(passwordField, "placeholder");
	}

	public String getRememberMeCheckBoxLabelText() {
		return elementUtilities.getTextFromElement(rememberMeLableText);
	}

	public String getCookieCheckBoxLabelText() {
		return elementUtilities.getTextFromElement(coockieLableText);
	}

	public String getSignInButtonText() {
		return elementUtilities.getElementText(submitButton);
	}

	public String getForgotPasswordText() {
		return elementUtilities.getElementText(forgotPasswordText);
	}

}
