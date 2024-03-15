@user
  Feature: I want to create a user

    Scenario Outline: After I create a user, I can fetch the info of that user using key
      When I create a user with <name>, <password>, <emailAddress>, <displayName> and <applicationKeys>
      And I get the user info with key
      Then The user info should match the <name>, <emailAddress> and <displayName>

      Examples:
        | name  | password |    emailAddress   | displayName | applicationKeys  |
        | "ben" | "ben"    |   "ben@test.com"  |    "ben"    | "[jira-software]"|