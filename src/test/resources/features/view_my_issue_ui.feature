Feature: View My Issue
  Background:
    Given I am logged in as an admin user with UI with password "12345"
    And I am on the project "test" page
  Scenario:
    When I click on the only my issue
    Then I should see all the issues that are assigned to me