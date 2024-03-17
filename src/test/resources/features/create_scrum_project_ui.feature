Feature: Create Scrum Project with UI

  Scenario: Admin user creates a Scrum project
    Given I am logged in as an admin user with UI
    When I create a Scrum project
    Then the project should be created successfully with UI