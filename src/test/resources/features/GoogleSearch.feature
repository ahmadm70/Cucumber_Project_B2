Feature: Google Search Functionality Title Validation

  @smoke
  Scenario: Search functionality result title validation
    Given user is on Google Search page
    When user types Loop Academy in the Google Search box and clicks enter
    Then user should see Loop Academy - Google Search in title

  @smoke
  Scenario: Search functionality result title validation
    Given user is on Google Search page
    When user types "Loop Academy" in the Google Search box and clicks enter
    Then user should see "Loop Academy - Google Search" in title

  @smoke
  Scenario: Search functionality result title validation
    Given user is on Google Search page
    When user types "MAN UTD" in the Google Search box and clicks enter
    Then user should see "MAN UTD - Google Search" in title