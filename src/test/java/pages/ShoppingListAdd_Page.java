package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ShoppingListAdd_Page extends ScreenBase {

	public ShoppingListAdd_Page(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	

	@AndroidFindBy(id = "org.openintents.shopping:id/layout_choice_bottom")
	public MobileElement layouSelectWithAddItemBottom;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My shopping list']")
	public MobileElement MyShoppingListHeader;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	public static MobileElement hamburgerMenu;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New list']")
	public MobileElement newList;

	@AndroidFindBy(id = "org.openintents.shopping:id/edittext")
	public MobileElement enterNewList;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	public MobileElement okButton;

	@AndroidFindBy(id = "org.openintents.shopping:id/autocomplete_add_item")
	public MobileElement addItemField;

	@AndroidFindBy(id = "org.openintents.shopping:id/button_add_item")
	public MobileElement addButton;

	@AndroidFindBys({
			@AndroidBy(xpath = "//android.widget.FrameLayout/android.widget.TextView[@resource-id='org.openintents.shopping:id/text1']") })
	public static List<WebElement> listInShopping;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
	public static MobileElement moreOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete list']")
	public MobileElement deleteList;

	@AndroidFindBys({ @AndroidBy(id = "org.openintents.shopping:id/name") })
	public static List<WebElement> itemsInList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Clean up list\"]")
	public MobileElement delete;

	@AndroidFindBys({
			@AndroidBy(xpath = "//android.widget.CheckBox[@resource-id='org.openintents.shopping:id/check']") })
	public static List<WebElement> checkBox;

	

	public void welcomeScreenPresent() {
		Assert.assertTrue(isElementPresent(layouSelectWithAddItemBottom), "The Welcome is not loaded");
	}

	public void MyShoppingListHeader() {
		Assert.assertTrue(isElementPresent(MyShoppingListHeader), "The MyShoppingListHeader is not loaded");
	}

	public void launchMyShoppingList() {
		clickAble(driver, layouSelectWithAddItemBottom);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addNewList(String listName) {
		clickAble(driver, hamburgerMenu);
		clickAble(driver, newList);

		enterText(enterNewList, listName, driver);
		clickAble(driver, okButton);

	}

	public void addItem(String item) {
		enterText(addItemField, item, driver);
		clickAble(driver, addButton);
	}

	public void listPresent(String list) {
		clickAble(driver, hamburgerMenu);
		Assert.assertTrue(elementPresentInList(list, listInShopping), "The element not is present");
	}

	public void backShoppingList() {
		clickAble(driver, hamburgerMenu);
	}

	public void deleteList(String list) {
		clickAble(driver, moreOption);
		clickAble(driver, deleteList);
		clickAble(driver, okButton);

	}

	public void listNotPresent(String list) {
		Assert.assertFalse(elementNotPresentInList(list, listInShopping), "The element is present");
	}

	public void deleteItemsInList(String item) {
		System.out.println("mamjula");
		int index = 0;

		for (WebElement ele : itemsInList) {
			if (ele.getText().equals(item)) {
				clickAble(driver, checkBox.get(index));
				clickAble(driver, delete);
			} else
				index++;
		}

	}

	public static void selectList(String list) {

		for (WebElement ele : listInShopping) {
			if (ele.getText().equals(list)) {
				clickAble(driver, ele);
				break;
			}

		}
	}

	public void itemNotPresent(String item) {
		Assert.assertFalse(elementNotPresentInList(item, itemsInList), "The element is present");
	}

}
