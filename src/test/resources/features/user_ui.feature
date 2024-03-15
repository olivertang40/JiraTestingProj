Feature: User functionalities UI

  Scenario: Admin user creates a new user
    Given I login as an admin
    When I create a new user
    Then I can see it in user menu

  Scenario: Admin user deactivated a user
    Given I login as an admin
    When I deactivatd the user in UI
    Then I can see the user status changed