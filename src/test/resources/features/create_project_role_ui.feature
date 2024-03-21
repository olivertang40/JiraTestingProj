Feature: Create Project Role
  Background:
    Given I am logged in as an admin user with UI with password "12345"
  Scenario: Create a new project role
    Given I am on the project role management page
    When I should create project role
    Then I should see the project role created