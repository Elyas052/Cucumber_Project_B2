#@B2G1-243 @B2G1-227 @wip
Feature: Wikipedia Search Functionality Feature
  User Story: As a user, when I am on the Google search page,
  I want to be able to search Wikipedia for articles.

  Background:
    Given user is on Wikipedia home page
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button

  Scenario: Wikipedia Search Functionality Title Verification
    Then user sees "Steve Jobs" is in the wiki title

  Scenario: Wikipedia Search Functionality Header Verification
    Then user sees "Steve Jobs" is in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    Then user sees "Steve Jobs" is in the image header
