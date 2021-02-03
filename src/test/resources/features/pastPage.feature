# new feature
# Tags: optional

Feature: Past page functionality

  @pageCheck
  Scenario: Checking correct date displayed on initial open
    Given I have a WebDriver
    When I open the "past" page
    Then The date displayed in the header will be equal to yesterdays date

    @dateCheck
    Scenario Outline: Checking each link on Past page displays correct date
      Given I am on "https://news.ycombinator.com/front" page
      When I click on the linked list text <linkedText>
      Then The date should be <Date>
      Examples:
        | linkedText     | Date         |
        | "day"          | "2021-02-01" |
        | "month"        | "2021-01-02" |
        | "year"         | "2020-02-02" |

      @totalRatingsOnPage
      Scenario: Check correct ratings are on page
        Given I am on "https://news.ycombinator.com/front" page
        When I count the number of ratings on the page
        Then The count should always be 30