#@user
Feature: I want to test CRUD functionalities of User API

  Scenario: After I create a user, I can fetch the info of that user using key
    When I create a user with info
    Then The user should be created successfully

  Scenario: I can deactivated the user and I can check it
    When I deactivate the user "charlie"
    Then The user status should be false

  Scenario: I can update current user to a new group
    When I update current user group to test
    Then I find user in the group

