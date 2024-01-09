Feature: Docuport Login Logout Feature

  Background:
    Given user is on Docuport login page

  @smoke @nadir @userstoy @testplan @testexecution @B2G3-197
  Scenario: Login as a client
    When user enters username for client
    And user enters password for client
    And user clicks login button
    Then user should see the home page for client

  @regression @closed @wip @smoke @nsh
  Scenario: Login as an employee
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    Then user should see the home page for employee

  @smoke
  Scenario: Login as an advisor
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    Then user should see the home page for advisor

  @smoke
  Scenario: Login as an supervisor
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks login button
    Then user should see the home page for supervisor
