# new feature
# Tags: optional

Feature: CRUD Operations

  @create
  Scenario: Create
    Given I have a SpartanCrud
    When I use the Create operation in SpartanCrud
    Then I will create a spartan and add them to the repo increasing its size to 1
    @read
    Scenario: Read
      Given I have a SpartanCrud and 4 Spartans in the list
      When I use the read method to see all the spartans
      Then I should get a List of Spartans back with 4 in it

      @update
      Scenario: Update
        Given I have a Spartan with a course that is "Java"
        When I use the update method to change the course to "C#"
        Then The Spartans course will now be "C#"

        @delete
        Scenario: Delete
          Given I have a Spartan in the repo and their id is 1
          When I use the delete method
          Then There will no longer be a spartan with an id of 1 in the repo