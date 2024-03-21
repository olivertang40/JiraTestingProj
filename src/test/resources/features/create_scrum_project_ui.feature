Feature: Create Scrum Project with UI
  Background:
    Given I am logged in as an admin user with UI with password "12345"

  Scenario: Admin user creates a Scrum project
    When I create a Scrum project
    Then the project should be created successfully with UI