Feature: Add user to project

  @positive
  Scenario: get users based on the roleId
    When I get users based on roleId
    Then The users should be fetched correctly