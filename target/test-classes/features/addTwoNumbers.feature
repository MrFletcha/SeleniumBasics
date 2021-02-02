@tag1
Feature: The calculator can add two numbers together
  @tag2
  Scenario Outline: Adding two numbers to see the result
    Given I have a calculator
    When I add <number1> and <number2>
    Then I will get <Answer>
    Examples:
      | number1 | number2 | Answer |
      | 1       | 1       | 2      |
      | 3       | 4       | 7      |
      | 0       | 1       | 1      |
      | 12      | 1       | 13     |

