Feature: Issue Assignment API

  Scenario: Assign an issue to a user
#    Given I am logged in as an admin user
    When I assign the issue to the assignee
    Then the issue should be assigned to the assignee successfully