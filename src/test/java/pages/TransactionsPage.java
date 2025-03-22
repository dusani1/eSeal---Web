package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import root.RootPage;

public class TransactionsPage extends RootPage {
	ExtentTest extentTest;

	public TransactionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[text()='Transaction']")
	private WebElement transactionsPageHeading;

	@FindBy(xpath = "//p[normalize-space()='Transaction']")
	private WebElement addTransactionButton;

	@FindBy(xpath = "//input[@placeholder='Transaction Name']")
	private WebElement transactionNameField;

	@FindBy(xpath = "//input[@placeholder='Description']")
	private WebElement descriptionField;

	@FindBy(xpath = "//input[@placeholder='Action Code']")
	private WebElement actionCodeField;

	@FindBy(xpath = "//*[text()='Source Location Action*']/following-sibling::div/div/select")
	private WebElement sourceLocationActionDropdown;

	@FindBy(xpath = "//*[text()='Destination Location Action*']/following-sibling::div/div/select")
	private WebElement destinationLocationActionDropdown;

	@FindBy(xpath = "//*[text()='Intransit action*']/following-sibling::div/div/select")
	private WebElement intransitActionDropdown;

	@FindBy(xpath = "//input[@placeholder='Feature Code']")
	private WebElement featureCodeField;

	@FindBy(xpath = "//input[@placeholder='Group']")
	private WebElement groupField;

	@FindBy(xpath = "//h4[text()='Add']")
	private WebElement addTransactionWindow;

	@FindBy(xpath = "//h4[text()='Edit']")
	private WebElement ediTranactionWindow;

	@FindBy(xpath = "//*[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[text()='Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//span[@class=\"close-icon-custom\"]")
	private WebElement closeIcon;

	@FindBy(xpath = "//input[@placeholder='Transaction Name']//following-sibling::span")
	private WebElement transactionNameFieldWarningAlert;

	@FindBy(xpath = "//input[@placeholder='Description']//following-sibling::span")
	private WebElement descriptionFieldWaningAlert;

	@FindBy(xpath = "//input[@placeholder='Action Code']//following-sibling::span")
	private WebElement actionCodeFieldWaningAlert;

	@FindBy(xpath = "//*[text()='Source Location Action*']/following-sibling::div/div/select//following-sibling::span")
	private WebElement sourceLocationActionFieldWaningAlert;

	@FindBy(xpath = "//*[text()='Destination Location Action*']/following-sibling::div/div/select//following-sibling::span")
	private WebElement destinationLocationActionFieldWaningAlert;

	@FindBy(xpath = "//*[text()='Intransit action*']/following-sibling::div/div/select//following-sibling::span")
	private WebElement intransitActionFieldWaningAlert;

	@FindBy(xpath = "//input[@placeholder='Feature Code']//following-sibling::span")
	private WebElement featureCodeFieldWaningAlert;

	@FindBy(xpath = "//input[@placeholder='Group']//following-sibling::span")
	private WebElement groupFieldWaningAlert;

	@FindBy(xpath = "//table//tbody//tr[1]//td//p//div//i[@class='fa fa-pencil-square-o fa-edit']")
	private WebElement editUserIcon;

	@FindBy(xpath = "//table//tbody//tr[1]//td//p//div//i[@class='fa fa-trash-o fa-delete']")
	private WebElement deleteIcon;

	@FindBy(xpath = "//input[contains(@placeholder, 'Search Transaction')]")
	private WebElement searchTransactionTextField;

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

	public String transactionsPageHeading() {
		String pageHeading = elementUtilities.getElementText(transactionsPageHeading);
		return pageHeading;
	}

	public void clickOnAddTransactionButton() {
		elementUtilities.clickOnElement(addTransactionButton);
	}

	public void enterTransactionName(String tranactionName) {
		elementUtilities.enterTextIntoElement(transactionNameField, tranactionName);

	}

	public void enterDescription(String description) {
		elementUtilities.enterTextIntoElement(descriptionField, description);

	}

	public void enterActionCode(String actionCode) {
		elementUtilities.enterTextIntoElement(actionCodeField, actionCode);

	}

	public void enterFeatureCode(String featureCode) {
		elementUtilities.enterTextIntoElement(featureCodeField, featureCode);

	}

	public void enterGroup(String group) {
			elementUtilities.enterTextIntoElement(groupField, group);
		
	}

	public void selectSourceLocationAction(String sourceLocationAction) {
			elementUtilities.selectOptionFromDropdownFieldUsingVisibleText(sourceLocationActionDropdown,
					sourceLocationAction);
	
	}

	public void selectDestinationLocationAction(String destinationLocationAction) {
		
			elementUtilities.selectOptionFromDropdownFieldUsingVisibleText(destinationLocationActionDropdown,
					destinationLocationAction);
		
	}

	public void selectIntransitAction(String intransitAction) {
		
			elementUtilities.selectOptionFromDropdownFieldUsingVisibleText(intransitActionDropdown, intransitAction);
		
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

	public boolean addTransactionWindowHeading() {
		return elementUtilities.waitAndCheckElementDisplayStatus(addTransactionWindow, 5);
	}

	public boolean editTransactionWindowHeading() {
		return elementUtilities.waitAndCheckElementDisplayStatus(ediTranactionWindow, 5);
	}

	public String getTransactionNameFieldWarningAlert() {
		return elementUtilities.getElementText(transactionNameFieldWarningAlert);
	}

	public String getDescriptionFieldWarningAlert() {
		return elementUtilities.getElementText(descriptionFieldWaningAlert);
	}

	public String getActionCodeFieldWarningAlert() {
		return elementUtilities.getElementText(actionCodeFieldWaningAlert);
	}

	public String getSourceLocationFieldWarningAlert() {
		return elementUtilities.getElementText(sourceLocationActionFieldWaningAlert);
	}

	public String getDestinationLocationFieldWarningAlert() {
		return elementUtilities.getElementText(destinationLocationActionFieldWaningAlert);
	}

	public String getIntransitActionFieldWarningAlert() {
		return elementUtilities.getElementText(intransitActionFieldWaningAlert);
	}

	public String getFeatureCodeFieldWarningAlert() {
		return elementUtilities.getElementText(featureCodeFieldWaningAlert);
	}

	public String getGroupFieldWarningAlert() {
		return elementUtilities.getElementText(groupFieldWaningAlert);
	}

	public String getAlertText() {
		elementUtilities.waitAndCheckElementDisplayStatus(alertTextElement, 5);
		return elementUtilities.getElementText(alertTextElement);

	}

	public String getTransactionNameFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(transactionNameField, "value");
	}

	public String getDescriptionFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(descriptionField, "value");
	}

	public String getActionFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(actionCodeField, "value");
	}

	public String getSourceLocationActionFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(sourceLocationActionDropdown, "value");
	}

	public String getDestinationLocationActionFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(destinationLocationActionDropdown, "value");
	}

	public String getIntransitActionFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(intransitActionDropdown, "value");
	}

	public String getFeatureCodeFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(featureCodeField, "value");
	}

	public String getGroupFieldDoMValue() {
		return elementUtilities.getElementDomAttribute(groupField, "value");
	}

	public void enterSerachTextAndSearch(String searchText) {
		elementUtilities.enterTextIntoElement(searchTransactionTextField, searchText);

	}

	public String getdeleteConfirmationAlertTitleText() {
		return elementUtilities.getElementText(deleteConfirmationAlertTitleText);
	}

	public String getdeleteConfirmationAlertText() {
		return elementUtilities.getElementText(deleteConfirmationAlertText);
	}

	public void pressEnterKey() {
		searchTransactionTextField.click();
		searchTransactionTextField.sendKeys(Keys.ENTER);
	}

	public int getLastPageCount() {
		String count = elementUtilities.getTextFromElement(lastPageNumberElement);
		return Integer.parseInt(count.trim());
	}

	public boolean searchRecord(String searchInputOrTransactionName, String actionCode, String featureCode) {
		int noOfPages = getLastPageCount();
		boolean recordFound = false;
		outerloop: for (int p = 1; p <= noOfPages; p++) {
			for (int i = 1; i <= rows.size(); i++) {
				try {
					String actualUserName = rows.get(i - 1).findElement(By.xpath(".//td[1]")).getText();
					if (actualUserName.equals(searchInputOrTransactionName)) {

						String actualActionCode = rows.get(i - 1).findElement(By.xpath(".//td[2]")).getText();
						String actualFeatureCode = rows.get(i - 1).findElement(By.xpath(".//td[3]")).getText();
						System.out.println(actualUserName + "  " + actualActionCode + "  " + actualFeatureCode);
						if (actualActionCode.equals(actionCode) && actualFeatureCode.equals(featureCode)) {
							System.out.println("All details match: actionCode, featureCode");
							recordFound = true;
							break outerloop;
						}

					}
				} catch (Exception e) {
					System.out.println("Transaction Name not found in row " + i + " on page " + p);

				}
			}
			if (!recordFound && p < noOfPages) {
				goToNextPage(p + 1);
			}
		}
		return recordFound;

	}

	public boolean searchAndClickIcon(String searchInputOrTransactionName, String featureCode, String iconType) {
		int noOfPages = getLastPageCount();
		boolean recordFound = false;

		for (int p = 1; p <= noOfPages; p++) {
			for (int i = 1; i <= rows.size(); i++) {
				try {
					String actualUserName = rows.get(i - 1).findElement(By.xpath(".//td[1]")).getText();
					if (actualUserName.equals(searchInputOrTransactionName)) {
						String actualFeatureCode = rows.get(i - 1).findElement(By.xpath(".//td[3]")).getText();
						if (actualFeatureCode.equals(featureCode)) {
							recordFound = true;
							clickIcon(i, p, iconType);
							break;
						}
					}
				} catch (Exception e) {
					if (!recordFound) {
						System.out.println("Transaction not found in row " + i + " on page " + p);
					}
				}
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

}