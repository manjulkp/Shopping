Hi Sunita,

The scenarios are automated :

The output of one of the test case is :

Feature: Title of your feature
  I want to use this template for my feature file

  @tag
  Scenario: Validate the sorting of the list items      # src/test/resources/featurefile/ShoppingList.feature:27
    Given I am in the welcome screen                    # ShoppingListAdd_Step.i_am_in_the_welcome_screen()
    And I select the layout with add item at the bottom # ShoppingListAdd_Step.i_select_the_layout_with_add_item_at_the_bottom()
    Then I see my shopping  list screen                 # ShoppingListAdd_Step.i_see_my_shopping_list_screen()
    When I add a new list as "HomeList"                 # ShoppingListAdd_Step.i_add_a_new_list_as(String)
    And I add "bread" to the list                       # ShoppingListAdd_Step.i_add_to_the_list(String)
    And I add "cakes" to the list                       # ShoppingListAdd_Step.i_add_to_the_list(String)
    And I add "apple" to the list                       # ShoppingListAdd_Step.i_add_to_the_list(String)
    When I select settings                              # ShoppingListAdd_Step.i_select_settings()
    And I select "sort order" in the setting screen     # ShoppingListAdd_Step.i_select_in_the_setting_screen(String)
    And I select "alphabetical" in the sort order       # ShoppingListAdd_Step.i_select_in_the_sort_order(String)
    When select "HomeList" from the hamburger menu      # ShoppingListAdd_Step.select_from_the_hamburger_menu(String)
    Then the items are stored in alphabetical order     # ShoppingListAdd_Step.the_items_are_stored_in_alphabetical_order()

1 Scenarios (1 passed)
12 Steps (12 passed)
1m1.226s

PASSED: scenario("Validate the sorting of the list items", "Title of your feature")
        Runs Cucumber Scenarios

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


///////////////////////////////////////////////////

Limitation of the app 
1. Forced to choose as xpath for locator as the ID was not working .
2.Page fragment encapsulation was not done due to time constrain.
3.report gets generated at /shopping.com/target/cucumber-html-reports/overview-features.html


Improvement for framework 
1.Use Arquillian for better readability ,scalability .
2.Make the page to page fragment will result in less maintaince and flakiness of the framework.
3.Logging should be add if there is any failure of test case like adb logcat
4.Application state need to recognise to make the test cases run in suite .
5.Precondition and postcondition of the app needs to considered .
6.If AWS or any device farm is used ,then start of Appium needs to handled differently -right now it starts on locally .
7.Test Data configuration to framework need to though for end to end system.
8.Rich reporting tools can be plugged in .

Regards
Manjula
