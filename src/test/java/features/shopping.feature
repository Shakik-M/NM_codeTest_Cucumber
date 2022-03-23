Feature: User's Shopping Journey

  @shopping
  Scenario: Shopping using standard user info
    Given I am at the SauceDemo homepage
    And I login entering valid user credentials
    When I click on Login Button
    Then I should be landing into inventory page and able to sort the items by price from Low to high
    When I click on the add to cart buttons of items
    Then I should be able to view the items in cart
    And I can remove the items from cart
    And I can add another item in cart by going back to inventory page
    And I click on the checkout button in my cart page
    And I enter my first name, last name, zipcode
    And I click on continue button
    And I can verify the purchased item and total price
    When I click on finish button
    Then I should be able to complete the shopping
