@user
Feature: As an admin user, I want to manage groups

  @positive
  Scenario: Login in as an administrator
    When I create group with name as "test3"
    Then The group should be created successfully




