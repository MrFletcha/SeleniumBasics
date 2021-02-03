# new feature
# Tags: optional

Feature: Spartan Add

  Scenario: Adding a spartan
    Given I have a Spartan
    When I can use the crud operations to add them to the repo
    Then I will get a new repo size of 1

    Scenario Outline: Adding multiple
      Given I have a <name> and a <course> and an <id>
      When I create a Spartan
      Then They have the correct values <v1> and <v2> and <v3>
      Examples:
        | name | course | id | v1   | v2    | v3 |
        | ida  | Java   | 1  | Ida  | Java  | 1  |
        | Noel | C#     | 2  | Noel | C#    | 2  |




