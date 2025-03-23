package base;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.CommonUtils;

public class Base {

	WebDriver driver;
	public Properties prop;
	// public HeaderOptions headerOptions;
	public LoginPage loginPage;
	public Actions actions;
	public static final Logger logger = LogManager.getLogger(Base.class);

	public WebDriver openBrowserAndApplicationURL() {

		prop = CommonUtils.loadProperties();
		String browser = prop.getProperty("browserName");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(getExpectedPageURL("loginPageUrl"));
		// driver.get(prop.getProperty("applicationURL"));

		return driver;

	}

	public void quitBrowser(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}

	public void refreshAndNavigateToPage(WebDriver driver, String pageURL) {
		refreshPage(driver);
		navigateToPage(pageURL);
	}

	public void navigateToPage(String pageURL) {
		driver.navigate().to(pageURL);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void navigateBackInBrowser(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public Actions getActions(WebDriver driver) {
		Actions actions = new Actions(driver);
		return actions;
	}

	public Actions clickKeyboradKeyMultipleTimes(WebDriver driver, Keys keyName, int noOfTimes) {
		actions = getActions(driver);
		for (int i = 1; i <= noOfTimes; i++) {
			actions.sendKeys(keyName).perform();
		}
		return actions;
	}

	public Actions clickKeyboradKeyMultipleTimes(Actions actions, Keys keyName, int noOfTimes) {
		for (int i = 1; i <= noOfTimes; i++) {
			actions.sendKeys(keyName).perform();
		}
		return actions;
	}

	public void pressTwoKeysTogether(WebDriver driver, Keys keyNameOne, Keys keyNameTwo) {
		actions = getActions(driver);
		actions.keyDown(keyNameOne).sendKeys(keyNameTwo).keyUp(keyNameOne).keyUp(keyNameTwo).build().perform();
	}

	public Actions typeTextUsingActions(Actions actions, String text) {
		actions.sendKeys(text).perform();
		return actions;
	}

	public String getBaseURL() {
		return prop.getProperty("appURL");
	}

	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public String getUrl() {
		String pageUrl = driver.getCurrentUrl();
		return pageUrl;
	}

	public String getExpectedPageURL(String pageName) {
		//System.out.println("Base URL: " + prop.getProperty("baseUrl"));
		//System.out.println("Login Page URL: " + prop.getProperty("loginPageUrl"));
		//System.out.println("URL is :"+prop.getProperty("baseUrl") + prop.getProperty(pageName));
		return prop.getProperty("baseUrl") + prop.getProperty(pageName);
		
	}

}
