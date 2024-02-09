Feature: Search for type of article

  Scenario Outline: Search for a specific product type and check availability
    Given User is on the homepage
    When Search for product "<productType>"
    Then The number of available items should be greater than <expectedQuantity>
    Examples:
      | productType | expectedQuantity |
      | jersey      | 200              |

