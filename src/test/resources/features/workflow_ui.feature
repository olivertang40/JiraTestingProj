Feature: test workflow with different roles

  Scenario: As an admin, I can create workflow
    Given I login as an admin
    When I create a workflow
    Then  I can see four steps

  Scenario: As an admin, I can edit columns and see workflow status results
    Given I login as an admin
    When I edit columns
    Then I can see different statuses

  Scenario: As a developer, I can change workflow status
    Given I login as a dev
    When I change workflow status
    Then I can see status is changed

  Scenario: As a QA user, I can change workflow status
    Given I login as a QA user
    When I change workflow status
    Then I can see workflow has resolved and close