Feature: User functionalities UI

  Scenario: Admin user creates a new user
    Given I login as an admin
    When I create a new user
    Then I can see it in user menu

  Scenario: Admin user deactivated a user
    Given I login as an admin
    When I deactivate the user in UI
    Then I can see the user status changed

  Scenario: Admin user assign current user to a group
    Given I login as an admin
    When I assign current user to a group
    Then I can see the user in the new group