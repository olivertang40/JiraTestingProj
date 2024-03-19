Feature: Issue Management API

  Scenario: Create an issue via API
#    Given I am authenticated as an admin
    When I create an issue with the following details
    Then the issue should be created successfully with API