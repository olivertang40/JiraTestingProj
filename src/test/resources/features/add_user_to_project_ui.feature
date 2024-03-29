Feature: Add User to Project

  Background:
    Given I am logged in as an admin user with UI with password "12345"
    And I am on the project "test" page

  Scenario: Add User to Project
    And I Click on the project settings
    And I Click on the users and roles
    And I Click on the Add Users to Role
    Then the user should be added to the project successfully with UI