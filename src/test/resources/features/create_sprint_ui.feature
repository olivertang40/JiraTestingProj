Feature: Create new Sprint with UI

  Scenario: Admin user creates a new sprint
    Given I am logged in as an admin user with UI with password "localhost8080"
    When I click projects button
    And  I click JIRATest project
    Then I should view backlog page
    When I click create a new Sprint
    And  I click confirm create
    Then The sprint should be created successfully with UI

