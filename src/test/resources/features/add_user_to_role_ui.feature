Feature: Add user to role
  Background:
    Given I am logged in as an admin user with UI
    And I am on the project page
    And I Click on the project settings
  Scenario:
    Then I click Users and Roles
    When I click Add Users to a Role
    Then I should see the user added to the role