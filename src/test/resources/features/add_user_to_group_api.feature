Feature: Add user to project

  @positive
  Scenario: Admin user adds a user to the new group
    When I add a user to the new group
    Then the user should be added to the group successfully