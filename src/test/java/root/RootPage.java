package root;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ElementUtilities;

public class RootPage {
	
	public WebDriver driver;
	public ElementUtilities elementUtilities;
	
	public RootPage(WebDriver driver) {
		this.driver = driver;
		elementUtilities = new ElementUtilities(driver);
	}
	
	@FindBy(xpath = "(//button[@type='button' and contains(@aria-label, 'Go to page')])[last()]")
	private WebElement lastPageNumberElement;
	
	
	@FindBy(xpath = "//p[@class='pull-right-ica']")
	private WebElement footerSectionTextElement;
	
	public WebElement getFooterSectionTextElement() {
		return footerSectionTextElement;
	}
	
	
	
	public int getLastPageCount() {
		String count = elementUtilities.getTextFromElement(lastPageNumberElement);
		return Integer.parseInt(count.trim());
	}
	
	public void clickIcon(int rowIndex, int pageNumber, String iconType) {
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

	public String getIconXpath(int rowIndex, String iconType) {
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
