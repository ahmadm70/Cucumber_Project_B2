Feature: Validate default and updated rows per page

  @wip
  Scenario Outline: Validate rows per page as an employee
    Given user logs in as an "employee"
    When user clicks to "<navigate item>"
    And user validates that rows per page is <rows by default> by default
    And user changes rows per page to <change rows to>
    Then user validates that rows per page is <rows after change> now
    Examples:
      | navigate item | rows by default | change rows to | rows after change |
      | Clients       | 10              | 5              | 5                 |
      | Users         | 10              | 5              | 5                 |

  @wip
  Scenario Outline: Validate rows per page as an supervisor
    Given user logs in as an "supervisor"
    When user clicks to "<navigate item>"
    And user validates that rows per page is <rows by default> by default
    And user changes rows per page to <change rows to>
    Then user validates that rows per page is <rows after change> now
    Examples:
      | navigate item | rows by default | change rows to | rows after change |
      | Users         | 10              | 5              | 5                 |
      | Leads         | 10              | 5              | 5                 |