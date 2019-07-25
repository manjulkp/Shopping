package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SortList extends ScreenBase {

	public SortList(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]")
	public MobileElement settings;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sort order\"]")
	public MobileElement sortOrder;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"alphabetical\"]")
	public MobileElement alphabeticalOrder;
	
	public void selectSetting()
	{
		clickAble(driver, ShoppingListAdd_Page.moreOption);
		clickAble(driver, settings);
	}
	
	public void sortSelect()
	{
		clickAble(driver, sortOrder);
	}
	
	public void alphabeticalOrderSelect()
	{
		clickAble(driver, alphabeticalOrder);
		driver.navigate().back();
	}
	
	public void selectListFromMenu(String list)
	{
		clickAble(driver, ShoppingListAdd_Page.hamburgerMenu);
		ShoppingListAdd_Page.selectList(list);
		
		
	}
	
	public boolean sortInAlphabeticalOrder(String names[])
	{
		int n = names.length;
		boolean sortWasNotDone = true;
		
		for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (names[i].compareTo(names[j])>0) 
                {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                    sortWasNotDone = false;
            		  
                }
            }
        }
		return sortWasNotDone;
	}
	
	
	
	public String[] storeItems(List<WebElement> itemsInList)
	{
		String[] itemArr = new String[itemsInList.size()] ;
		int i =0;
		for(WebElement ele : itemsInList)
		{
			itemArr[i] = ele.getText();
			i++;
		}
		return itemArr;
	}
	
	public void validateSort()
	{
		String[] array = storeItems(ShoppingListAdd_Page.itemsInList);
		boolean isSorted = sortInAlphabeticalOrder(array);
		Assert.isTrue(isSorted,"The items are sorted");
	}
	
	
	
	
	
	

}
