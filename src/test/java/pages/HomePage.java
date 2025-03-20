package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;

public class HomePage extends RootPage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "profile-thumbnail")
	private WebElement profileIconInHomePage;

	@FindBy(xpath = "//*[@class='email-content']")
	private WebElement loginMailText;

	@FindBy(className = "logout-icon")
	private WebElement logioutIcon;
	
	@FindBy(xpath = "//*[text()='Authorization']")
	private WebElement authorizationOption;
	
	@FindBy(xpath = "//*[text()='Roles']")
	private WebElement rolesOption;
	
	@FindBy(xpath = "//*[text()='Users']")
	private WebElement usersOption;
	
	@FindBy(xpath = "//*[text()='Features']")
	private WebElement featuresOption;
	
	@FindBy(xpath ="//*[text()='Companies']")
	private WebElement companiesOption;
	
	@FindBy(xpath ="//*[text()='Transactions']")
	private WebElement transactionsOption;
	
	@FindBy(xpath ="//*[text()='Locations']")
	private WebElement locationsOption;
	
	@FindBy(xpath ="//*[text()='Products']")
	private WebElement productsOption;
	
	@FindBy(xpath ="//*[text()='Reports']")
	private WebElement reportsOption;
	
	@FindBy(xpath ="//*[text()='WMS']")
	private WebElement wmsOption;
	
	@FindBy(xpath ="//*[text()='IQC']")
	private WebElement iqcOption;
	
	@FindBy(xpath = "//*[text()='Inspect']")
	private WebElement inspectOption;
	
	public boolean isProfileDisplayedInHomePage() {
		return elementUtilities.isElementDisplayed(profileIconInHomePage);
	}

	public void clickOnProfileIcon() {
		elementUtilities.clickOnElement(profileIconInHomePage);
	}

	public String getLoggedInMail() {
		return elementUtilities.getTextFromElement(loginMailText);
	}


	public void clickOnLogoutIcon() {
		elementUtilities.clickOnElement(logioutIcon);
	}

	public void clickOnAutorizationOption() {
		elementUtilities.waitForElementAndClick(authorizationOption, 10);

	}
	
	public void clickOnCompaniesOption() {
		elementUtilities.waitForElementAndClick(companiesOption, 10);

	}
	
	public UsersPage clickOnUsersOption() {
		elementUtilities.waitForElementAndClick(usersOption, 10);
		return new UsersPage(driver);
	}
	
	public TransactionsPage clickOnTransactionsOption() {
		elementUtilities.waitForElementAndClick(transactionsOption, 10);
		return new TransactionsPage(driver);
	}
	

	
	
}
