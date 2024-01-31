#@B2G1-244 @B2G1-227
@wip
Feature: Create a new client as an advisor

  Scenario: Create and validate a new client
    Given user is on Docuport login page
    Then user enters again credentials for login
      | user     | b1g1_advisor@gmail.com |
      | password | Group1                 |
    And user come to Clients tab
    And user enter information for new personal
      | First name | Elon            |
      | Last name  | Musk            |
      | Email      | tesla12@tesla.com |
      | Phone      | +12345678901    |
      | Password   | Group1          |
    Then user validate that new client "tesla12@tesla.com" created
    And user logout and login as a new person
      | user     | tesla12@tesla.com |
      | password | Group1          |
