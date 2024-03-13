Feature: As an admin user, I want to manage groups

  Scenario Outline: Login in as an administrator
    Given I visit the home page
    When I click User Management Button
    And  I enter password as <password>
    Then I should view the User Admin page
    When I click the groups
    And  I enter group name as <groupName>
    And  I click add group button
    And  I click edit members button
    Then I should see group member as <userName>



    Examples:
      | password | groupName |  userName |
      | "12345"  | "test2"   | "userName"|