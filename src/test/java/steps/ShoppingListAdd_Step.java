package steps;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ShoppingListAdd_Page;
import pages.SortList;

public class ShoppingListAdd_Step extends TestBase {
	
	
	ShoppingListAdd_Page shopList = new ShoppingListAdd_Page(driver);
	SortList sort= new SortList(driver);
	
	@Given("I am in the welcome screen")
	public void i_am_in_the_welcome_screen() {
		shopList.welcomeScreenPresent(); 
	}

	@Given("I select the layout with add item at the bottom")
	public void i_select_the_layout_with_add_item_at_the_bottom() {
	    shopList.launchMyShoppingList();
	}

	@Then("I see my shopping  list screen")
	public void i_see_my_shopping_list_screen() {
		shopList.MyShoppingListHeader();
	}

	@When("I add a new list as {string}")
	public void i_add_a_new_list_as(String newList) {
	    shopList.addNewList(newList);
	}

	@When("I add {string} to the list")
	public void i_add_to_the_list(String item) {
	   shopList.addItem(item);
	}

	@Then("the {string} is added under list")
	public void the_is_added_under_list(String list) {
		shopList.listPresent(list);
	}
	
	@Then("I navigate back to shopping list screen")
	public void i_navigate_back_to_shopping_list_screen() {
		shopList.backShoppingList();
	}

	@When("I delete the {string} under list")
	public void i_delete_the_under_list(String list) {
		shopList.deleteList(list);
	}

	@Then("I see the {string} is not present under the list")
	public void i_see_the_is_not_present_under_the_list(String list) {
		shopList.listNotPresent(list);
	}


	@When("I delete an item {string}")
	public void i_delete_an_item_from_the(String item) {
	    shopList.deleteItemsInList(item);
	}
	
	@When("I select {string}")
	public void i_select(String list) {
		shopList.selectList(list);
	}

	@Then("the item {string} is not present")
	public void the_item_is_not_present(String item) {
	    shopList.itemNotPresent(item);
	}
	
	@When("I select settings")
	public void i_select_settings() {
	    sort.selectSetting();
	}

	@When("I select {string} in the setting screen")
	public void i_select_in_the_setting_screen(String string) {
	    sort.sortSelect();
	    
	}

	@When("select {string} from the hamburger menu")
	public void select_from_the_hamburger_menu(String list) {
	    sort.selectListFromMenu(list);
	}

	@Then("the items are stored in alphabetical order")
	public void the_items_are_stored_in_alphabetical_order() {
	    sort.validateSort();
	}
	
	@When("I select {string} in the sort order")
	public void i_select_in_the_sort_order(String string) {
		sort.alphabeticalOrderSelect();
	}
	
	



}
