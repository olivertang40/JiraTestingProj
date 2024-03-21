Feature: Add Comment

  Background:
    Given I am logged in as an admin user with UI with password "12345"
    And I am on the project "test" page
  Scenario:
    When I click on the issue
    Then I add a comment
    Then I should see the comment added
