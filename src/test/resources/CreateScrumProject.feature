Feature: Create Scrum Project

  Scenario: As an admin user, I can create a Scrum project
    Given I am logged in as an admin user
    When I create a Scrum project with given details
    Then the project should be created successfully