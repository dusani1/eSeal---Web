package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class CommonUtils {

	public String getClientName() {
		Properties prop = new Properties();
		try (FileReader fr = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resource\\Common.properties")) {
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("client"); // Retrieves the value of "client" from Common.properties
	}

	public static Properties loadProperties() {
		Properties prop = new Properties();
		try {
			// Retrieve the client name
			String clientName = new CommonUtils().getClientName();
			// Construct the file path dynamically
			String filePath = System.getProperty("user.dir") + "\\src\\test\\resource\\" + clientName + ".properties";
			try (FileReader fr = new FileReader(filePath)) {
				prop.load(fr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static void waitForSeconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int convertToInteger(String text) {
		return Integer.parseInt(text);
	}

	public static boolean areItemsInListAreInAscendingOrder(List<String> list) {
		List<String> sortedList = list;
		Collections.sort(sortedList);
		return list.equals(sortedList);
	}

	public static String generateBrandNewEmail() {

		Date date = new Date();
		String dateString = date.toString();
		String dateStringWithoutSpaces = dateString.replaceAll("\\s", "");
		String dateStringWithoutSpacesAndColons = dateStringWithoutSpaces.replaceAll("\\:", "");
		String brandNewEmail = dateStringWithoutSpacesAndColons + "@gmail.com";
		return brandNewEmail;

	}

	public static String generateNewEmail() {
		return System.currentTimeMillis() + "@gmail.com";
	}

	public static Object[][] getTestData(MyXLSReader xls_received, String testName, String sheetName) {

		MyXLSReader xls = xls_received;

		String testCaseName = testName;

		String testDataSheet = sheetName;

		int testStartRowNumber = 1;

		while (!(xls.getCellData(testDataSheet, 1, testStartRowNumber).equals(testCaseName))) {

			testStartRowNumber++;

		}

		int columnStartRowNumber = testStartRowNumber + 1;
		int dataStartRowNumber = testStartRowNumber + 2;

		int rows = 0;
		while (!(xls.getCellData(testDataSheet, 1, dataStartRowNumber + rows).equals(""))) {

			rows++;

		}

		// Total number of columns in the required test
		int columns = 1;

		while (!(xls.getCellData(testDataSheet, columns, columnStartRowNumber).equals(""))) {

			columns++;

		}

		Object[][] obj = new Object[rows][1];

		HashMap<String, String> map = null;

		// Reading the data in the test
		for (int i = 0, row = dataStartRowNumber; row < dataStartRowNumber + rows; row++, i++) {

			map = new HashMap<String, String>();

			for (@SuppressWarnings("unused")
			int j = 0, column = 1; column < columns; column++, j++) {

				String key = xls.getCellData(testDataSheet, column, columnStartRowNumber);

				String value = xls.getCellData(testDataSheet, column, row);

				map.put(key, value);

			}

			obj[i][0] = map;

		}

		return obj;

	}

	public static ExtentReports getExtentReports() {

		ExtentReports extentReport = new ExtentReports();

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\Reports\\ExtentReport.html");
		ExtentSparkReporterConfig sparkReporterConfig = sparkReporter.config();
		sparkReporterConfig.setReportName("eSeal Automation Results");
		sparkReporterConfig.setDocumentTitle("eSeal Test Report");

		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("Seleium Version", "4.28.1");
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReport;

	}

	/*
	 * private static final Map<String, Map<String, String>> columnMappings = new
	 * HashMap<>(); static { loadMappings(); }
	 */
	/*
	 * private static void loadMappings() { try (BufferedReader br = new
	 * BufferedReader(new FileReader(System.getProperty("user.dir")+
	 * "\\src\\test\\resource\\gridColumnsMapping"))) { String line; while ((line =
	 * br.readLine()) != null) { if (line.trim().isEmpty()) continue; // Skip empty
	 * lines String[] moduleData = line.split(":"); if (moduleData.length < 2) {
	 * System.out.println("Invalid line in configuration: " + line); continue; //
	 * Skip invalid lines } String moduleName = moduleData[0].trim(); String[]
	 * mappings = moduleData[1].split(","); Map<String, String> mappingMap = new
	 * HashMap<>(); for (String mapping : mappings) { String[] keyValue =
	 * mapping.split("="); if (keyValue.length < 2) {
	 * System.out.println("Invalid mapping: " + mapping); continue; }
	 * mappingMap.put(keyValue[0].trim(), keyValue[1].trim()); }
	 * columnMappings.put(moduleName, mappingMap); } } catch (Exception e) { throw
	 * new RuntimeException("Error loading column mappings from file: " +
	 * e.getMessage(), e); } }
	 */
	/*
	 * public static Map<String, String> getColumnMappings(String moduleName) {
	 * return columnMappings.getOrDefault(moduleName, null); }
	 */

	/*
	 * public static Properties loadProperties() { Properties prop = new
	 * Properties(); FileReader fr; try { fr = new
	 * FileReader(System.getProperty("user.dir") +
	 * "\\src\\test\\resource\\ProjectData.properties"); prop.load(fr); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * return prop; }
	 */

	/*
	 * public class ConfigReader { private static ThreadLocal<Properties> prop =
	 * ThreadLocal.withInitial(() -> { Properties properties = new Properties(); try
	 * (FileInputStream fis = new
	 * FileInputStream("src/test/resources/config.properties")) {
	 * properties.load(fis); } catch (IOException e) { throw new
	 * RuntimeException("Configuration file could not be loaded."); } return
	 * properties; });
	 * 
	 * public static String getProperty(String key) { return
	 * prop.get().getProperty(key); } }
	 */

}
