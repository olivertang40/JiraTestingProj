Feature: Issue Assignment UI
  Background:
    Given I am logged in as an admin user with UI with password "12345"
    And I am on the project "test" page
  Scenario: Assign an issue to a user with UI
    Then I am on the issue page
    When I assign the issue to the assignee with UI
    Then the issue should be assigned to the assignee successfully with UI