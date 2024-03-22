Feature: I can create a permission scheme
  Scenario: I can create a permission scheme
#    Given I login as an admin
    When I create a permission scheme
    Then permission scheme should be created successfully