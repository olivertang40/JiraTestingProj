Feature: Add user to project

  Scenario: Admin user adds a user to the current project
    When I add a user to the current project
    Then the user should be added to the project successfully