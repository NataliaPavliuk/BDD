Feature: Smoke
  As a user
  I want to test main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check price added to cart product
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User checks that current url contains '<keyword>'
    And User makes search filter by brand '<brand>'
    And User takes expensive item filter
    And User clicks on product
    Then User checks that price is more than <price>

    Examples:
      | homePage               | keyword  | price  | brand|
      | https://rozetka.com.ua | laptop   | 50000  | HP   |



