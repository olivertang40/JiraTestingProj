Feature: Create a new issue UI
  Background:
    Given I am logged in as an admin user with UI with password "12345"
    And I am on the project "test" page
  Scenario: As a team leader user, I can create an issue
    When I create an issue
    Then the issue should be created successfully with UI

