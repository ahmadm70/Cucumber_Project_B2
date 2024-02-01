Feature: Scenario outline practice

  @googleSearchOutline @multiThread
  Scenario Outline: Google Search by using outline
    Given user is on Google Search page
    When user searches for the "<country>"
    Then user should see the "<capital>" in the result
    Examples:
      | country     | capital          |
      | Azerbaijan  | Baku             |
      | Turkey      | Ankara           |
      | Ukraine     | Kyiv             |
      | Uzbekistan  | Tashkent         |
      | Afghanistan | Kabul            |
      | USA         | Washington |