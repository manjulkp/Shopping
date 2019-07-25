package base;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static utility.CommonUtils.*;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import utility.CommonUtils;

/**
 * The `ScreenBase` class in the base class for all the `Page` classes within
 * the app. The `Page` classes inherit the AppiumDriver driver instance from
 * this class.
 *
 * This class contains helper/common methods that are inherited and can be used
 * from within the `Page` classes.
 *
 */
public class ScreenBase {

	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	public static String bundleIdAndroid;

	public ScreenBase(AppiumDriver<MobileElement> driver) {
		ScreenBase.driver = driver;

	}

	public static WebElement waitForElement(WebElement arg) {
		Reporter.log("The webElement " + arg + "is waiting ");
		waitForPageToLoad(arg);
		WebElement el = arg;
		return el;
	}

	public static void waitForPageToLoad(WebElement id) {
		Reporter.log("The webElement " + id + "is waiting  for 20 seconds");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}

	public static void waitForPageToLoad(WebElement id, int time) {
		Reporter.log("The webElement " + id + "is waiting  for " + time + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}

	public static boolean isElementPresent(WebElement webElement) {
		try {
			boolean isPresent = webElement.isDisplayed();
			System.out.println("The webElement is present is " + webElement);
			return isPresent;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Click an element
	public static void clickAble(AppiumDriver<MobileElement> driver, WebElement webElement) {
		try {
			if (isElementPresent(webElement)) {
				(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
				webElement.click();
				System.out.println("The webElement is clicked " + webElement);
			}
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			if (isElementPresent(webElement)) {
				webElement.click();
			}
		}
	}

	// Trying to find an element
	public boolean retryingFindClick(WebElement webElement) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				webElement.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	// Click back button
	public void clickBackButton() {
		Reporter.log("The click of back button");
		driver.navigate().back();
	}

	// Retrieve the text from an element
	public static String GetText(WebElement element) {
		Reporter.log("The text is been retrieved");
		return element.getText();
	}

	// Clear the text
	public static void ClearText(WebElement element) {
		Reporter.log("The text is been cleared");
		element.clear();
	}

	// Enter any text
	public static void enterText(WebElement element, String text, AppiumDriver<MobileElement> driver) {
		Reporter.log("The string " + " text " + "is entered in the field");
		clickAble(driver, element);
		element.sendKeys(text);
	}

	// Retrieve the text
	public static String GetScreenTitle(WebElement ele) {
		Reporter.log("The string " + " text " + "is entered in the field");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By) ele));
		return ele.getText();
	}

	// Element existence check
	public static boolean IsExists(WebElement element) {
		Reporter.log("The string " + " text " + "is entered in the field");
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	// Element enabled check
	public static boolean IsEnabled(WebElement element) {
		Reporter.log("Check for element being enabled or not ");
		return (element.isEnabled()) ? true : false;
	}

	// Element selected check
	public static boolean IsSelected(WebElement element) {
		Reporter.log("Check for element being isSelected or not ");
		return (element.isSelected()) ? true : false;
	}

	// check for actual verses with expected
	public static void verifyScreen(String screen, WebElement ele) {
		String actual = ele.getText();
		Reporter.log("Check for actual text" + actual + " with expected text" + screen);
		System.out.println("The actual text " + actual);
		System.out.println("The actual text " + screen);
		verifyEquals(screen, actual);
	}

	// check for actual verses with expected with assertEqual being called
	public static void verifyEquals(String expected, String actual) {
		try {
			Assert.assertEquals(actual, expected);
			Reporter.log("The actual text" + actual + " with expected to match the text" + expected);
		} catch (Throwable t) {
			// Need to add log
		}
	}


	

	// Click on specific Element in MenuList View
	public static void clickElementInMenu(String str, List<WebElement> option) {
		System.out.println("The element to be clicked has a size : " + option.size());
		try {

			for (WebElement ele : option) {
				System.out.println("The element to be clicked : " + ele.getAttribute("name"));
				if (ele.getAttribute("name").equalsIgnoreCase(str)) {
					System.out.println("The element to be clicked is found : " + ele.getAttribute("name"));
					ele.click();
					break;
				}
			}
		} catch (Exception e) {
			Reporter.log("Unable to click the element " + str + " in screen" + e.getMessage());
			System.out.println("The element did not  clicked : ");
		}
	}

	public static void clickElementInMenuText(String str, List<WebElement> option) {
		System.out.println("The element to be clicked has a size : " + option.size());
		try {
			for (WebElement ele : option) {
				System.out.println("The element to be clicked : " + ele.getText());
				if (ele.getText().equalsIgnoreCase(str) || ele.getText().contains(str)) {
					System.out.println("The element to be clicked is found : " + ele.getText());
					ele.click();
					break;
				}
			}
		} catch (Exception e) {
			Reporter.log("Unable to click the element " + str + " in screen" + e.getMessage());
			System.out.println("The element did not  clicked : ");
		}
	}

	// Checking two list are matching
	public static boolean arraysMatch(List<String> actualListFromDataTable, List<WebElement> options) {
		// Optional quick test since size must match
		System.out.println("The size of actualListFromDataTable " + actualListFromDataTable.size());
		System.out.println("The size of options in app  " + options.size());
		if (actualListFromDataTable.size() != options.size()) {
			return false;
		}

		List<String> expectedHelpText = new ArrayList<String>();
		for (WebElement ele : options) {
			System.out.println("The value in the list is " + ele.getAttribute("label"));
			expectedHelpText.add(ele.getAttribute("label"));
		}

		for (String element : actualListFromDataTable) {

			System.out.println("The value to be removed from list is " + element);
			if (!expectedHelpText.remove(element)) {
				return false;
			}
		}
		return expectedHelpText.isEmpty();
	}


	// Killing the app
	public void sendAppToBackground() throws InterruptedException {
		sleepTimer(3);
		if (platform.equals("ios")) {
			// driver.terminateApp("com.kwiff.kwiffTest");
			driver.terminateApp(BUNDLE_ID);
		} else {
			System.out.println("The app is geting closed");
			driver.closeApp();
		}
		sleepTimer(2);
	}

	public static boolean elementNotPresentInList(String name, List<WebElement> options) {
		boolean test = false;
		for (WebElement element : options) {
			System.out.println("The element is the list is " + element.getText());
			if (element.getText().contains(name)) {
				test = true;
				break;
			}
		}
		return test;

	}

	public static boolean textPresent(String text, WebElement ele) {
		if (ele.isDisplayed()) {
			ele.getText().contains(text);
			return true;
		}
		return false;
	}

	//Element present in List
		public static boolean elementPresentInList(String str, List<WebElement> option) {
			System.out.println("The element to be clicked has a size : " + option.size());
			try {

				for (WebElement ele : option) {
					System.out.println("The element to be clicked : " + ele.getAttribute("text"));
					if (ele.getAttribute("text").equalsIgnoreCase(str)) {
						return true;
						
					}
				}
			} catch (Exception e) {
				Reporter.log("Unable to click the element " + str + " in screen" + e.getMessage());
				System.out.println("The element did not  clicked : ");
			}
			return false;
		}
}
