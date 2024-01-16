Feature: Scenario outline practice

  @googleSearchOutline
  Scenario Outline:
    Given user is on Google Search page
    When user searches for the "<country>"
    Then user should see the "<capital>" in the result
    Examples:
      | country     | capital    |
      | Azerbaijan  | Baku       |
      | Turkey      | Ankara     |
      | Ukraine     | Kyiv       |
      | Uzbekistan  | Tashkent   |
      | Afghanistan | Kabul      |
      | USA         | Washington |