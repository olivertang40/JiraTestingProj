Feature: Move issue to new Sprint with UI

#  Background:

  Scenario Outline: Admin user move issue to new sprint
    Given I log in and am on backlog page
    When I create new issue in backlog with <message>
    And  I move it to current sprint
    And  I create another issue and move to current sprint
    Then The issue should be move successfully to the new sprint
    Examples:
      | message    |
      | "issue 1"  |

  Scenario: Developer user view all issues in current sprint
    When I log in as developer user
    And  I come to backlog page
    Then I view all issues in the current sprint

  Scenario: Team lead user end active sprint and download chart
    When I log in as team lead user
    And  I come to active sprint page
    And  I end the current active sprint
    Then I view the sprint in completed state
    When I switch to Velocity Chart
    And  I apply 6-month report and download

    