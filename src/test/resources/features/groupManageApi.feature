@user
Feature: As an admin user, I want to manage groups

  @positive
  Scenario: Valid login
    Given I visit the home page
#    When I enter valid user credential with "admin" and "12345"
    When I enter valid user credential
    Then The response status code is 200


  @negative
  Scenario Outline: Login in as an administrator
    Given I visit the home page
    When I click User Management Button
    And  I enter password as <password>
    Then I should view the User Admin page
    When I click the groups
    And  I enter group name as <groupname>
    And  I click add group button
    And  I click edit members button
    Then I should see group member as <username>



    Examples:
      | password | groupname |  username |
      | "12345"  | "test2"   | "admin"   |