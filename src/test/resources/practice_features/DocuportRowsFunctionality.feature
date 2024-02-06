Feature: Validate default and updated rows per page

  @smoke
  Scenario Outline: Validate rows per page as an advisor
    Given user logs in as an "advisor"
    When user clicks to "<navigate item>"
    And user validates that rows per page is <rows by default> by default
    And user changes rows per page to <change rows to>
    Then user validates that rows per page is <rows after change> now
    Examples:
      | navigate item | rows by default | change rows to | rows after change |
      | Clients       | 10              | 5              | 5                 |
      | Users         | 10              | 5              | 5                 |
      | Leads         | 10              | 5              | 5                 |
      | Bookkeeping   | 10              | 5              | 5                 |