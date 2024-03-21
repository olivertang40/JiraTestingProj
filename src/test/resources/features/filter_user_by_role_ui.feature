Feature: Add user to role
  Background:
    Given I am logged in as an admin user with UI with password "localhost8080"
    And I am on the project "JiraTest" page
    And I Click on the project settings
  Scenario:
    Then I click Users and Roles
    When I filter users by role "developer"
    Then I should see the filtered users of the role