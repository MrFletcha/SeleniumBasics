# new feature
# Tags: optional

Feature: The Calculator can handle boundary values

  Scenario: Adding over the range of an int
    Given I have a calculator
    When I add Integer.max and Integer.max
    Then I will get -2