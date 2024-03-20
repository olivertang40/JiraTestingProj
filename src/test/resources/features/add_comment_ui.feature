Feature: Add Comment

  Background:
    Given I am logged in as an admin user with UI
    And I am on the project page
  Scenario:
    When I click on the issue
    Then I add a comment
    Then I should see the comment added
