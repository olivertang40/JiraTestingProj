Feature: Add user to project

  @positive
  Scenario: Admin user adds a user to the new group
    When I add a user "dev" to the new group "test3"
    Then the user should be added to the group "test3" successfully