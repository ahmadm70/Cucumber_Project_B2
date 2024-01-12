Feature: Wikipedia Search Functionality Validation

  Background:

    Given user is on Wikipedia home page
    When user types "Steve Jobs" in the wiki search box
    When user clicks wiki search button

  @smoke
  Scenario: Wikipedia search functionality result title validation
    Then user sees "Steve Jobs" is in the wiki title

  @smoke
  Scenario: Wikipedia search functionality result main header validation
    Then user sees "Steve Jobs" is in the main header

  @smoke
  Scenario: Wikipedia search functionality result image header validation
    Then user sees "Steve Jobs" is in the image header