Feature: Cart functionality

  Scenario: Add different products to cart and check total
    Given User is on the home page
    When Add the following products to the cart:
      | 4957031 |
      | 4807284 |
    Then Cart page is opened
    And Total value of order on the cart page is equal to 30