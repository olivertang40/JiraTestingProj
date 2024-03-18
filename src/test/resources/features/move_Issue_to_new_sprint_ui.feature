Feature: Move issue to new Sprint with UI

  Scenario: Admin user move issue to new Sprint
    Given I have newly created sprint
    When I create new issue in backlog
    And  I move it to current sprint
    Then The issue should be move successfully to the new sprint

    