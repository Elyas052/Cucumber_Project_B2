#@B2G1-244 @B2G1-227 @wip
Feature: SmartBear Order Feature
  User Story: As a user, when I am on the Google search page,
  I want to be able to place an order on the SmartBear page, and the order should be seen on the page.

  Scenario: user should be able to place order and order should be seen in page
    Given user is already logged in and navigated to order page
    When user selects product type "FamilyAlbum"
    And user enters
      | quantity          | 2                |
      | customer name     | Chuck Norris     |
      | street            | 1100 Long way dr |
      | city              | Chantilly        |
      | state             | Virginia         |
      | zip               | 22011            |
      | credit car number | 1111222233334444 |
      | expiration date   | 12/25            |
    And user selects credit card type "American Express"
    And user enters process order button
    Then user should see "Chuck Norris" in the first row of the table
