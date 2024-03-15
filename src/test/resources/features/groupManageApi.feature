@user
Feature: As an admin user, I want to manage groups

  @negative
  Scenario: Valid login
    Given I visit the home page
#    When I enter valid user credential with "admin" and "12345"
    When I enter valid user credential
    Then The response status code is 200


  @positive
  Scenario: Login in as an administrator
    When I create group with name as "test"
    And I get the group info with name
    Then The group should be created successfully


