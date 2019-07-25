
Feature: Title of your feature
  I want to use this template for my feature file
  @add
  Scenario: Verify add and delete of item and delete a list
    Given I am in the welcome screen
    And  I select the layout with add item at the bottom
    Then I see my shopping  list screen
    When I add a new list as "HomeList"
    And  I add "bread" to the list
    And I add "cakes" to the list
    And I add "biscuit" to the list
    Then the "HomeList" is added under list
    And I navigate back to shopping list screen
    When I add a new list as "KidsList"
    And  I add "toy" to the list
    And I add "pencil" to the list
    And I add "books" to the list
    Then the "KidsList" is added under list
    When I delete the "KidsList" under list
    Then I see the "KidsList" is not present under the list
    When I select "HomeList"
    And I delete an item "bread"
    Then the item "bread" is not present 
 
 @sort   
    Scenario: Validate the sorting of the list items
    Given I am in the welcome screen
    And  I select the layout with add item at the bottom
    Then I see my shopping  list screen
    When I add a new list as "HomeList"
    And  I add "bread" to the list
    And I add "cakes" to the list
    And I add "apple" to the list
    When I select settings
    And I select "sort order" in the setting screen
    And I select "alphabetical" in the sort order
    When select "HomeList" from the hamburger menu
    Then the items are stored in alphabetical order
    
    
    
    
    
    
    
    
    
    
