$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/featurefile/ShoppingList.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate the sorting of the list items",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am in the welcome screen",
  "keyword": "Given "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_am_in_the_welcome_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select the layout with add item at the bottom",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_select_the_layout_with_add_item_at_the_bottom()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see my shopping  list screen",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_see_my_shopping_list_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add a new list as \"HomeList\"",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_add_a_new_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add \"bread\" to the list",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_add_to_the_list(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add \"cakes\" to the list",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_add_to_the_list(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add \"apple\" to the list",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_add_to_the_list(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select settings",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_select_settings()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \"sort order\" in the setting screen",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_select_in_the_setting_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \"alphabetical\" in the sort order",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingListAdd_Step.i_select_in_the_sort_order(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select \"HomeList\" from the hamburger menu",
  "keyword": "When "
});
formatter.match({
  "location": "ShoppingListAdd_Step.select_from_the_hamburger_menu(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the items are stored in alphabetical order",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingListAdd_Step.the_items_are_stored_in_alphabetical_order()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});