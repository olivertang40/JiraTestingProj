Feature: As an admin user, I want to manage groups

  @positive
  Scenario Outline: Valid login
    Given I am on the login page
    When I enter the valid credential with <username> and <password>
    When I click the login button
    Then I should be directed to the dashboard page
    Examples:
      | username | password         |
      | "admin"  | "localhost8080"  |


  @positive
  Scenario Outline: Login in as an administrator
    Given I visit the home page as an admin user
    When I click User Management Button
    And  I enter password as <password>
    Then I should view the User Admin page
    When I click the groups
    And  I enter group name as <groupname>
    And  I click add group button
    And  I click edit members button
    Then I should see group member as <username>

    Examples:
      |    password      | groupname | username |
      | "localhost8080"  | "test3"   |  "dev"   |

  @positive
  Scenario: Admin filters user based on the roles
    When  I visit the project page as an admin user
    And  I filter users by project roles
    Then I should view the developer role filter
