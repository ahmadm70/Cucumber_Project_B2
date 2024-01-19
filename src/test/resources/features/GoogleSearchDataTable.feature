Feature: Passing multiple parameters to the same step

  @smoke @listOfMap
  Scenario: Searching multiple items
    Given user is on Google Search page
    Then user searches for the following item
      | loop academy |
      | java         |
      | selenium     |
      | cucumber bdd |
      | sql          |
      | nadir        |
      | feyruz       |
      | ahmad        |