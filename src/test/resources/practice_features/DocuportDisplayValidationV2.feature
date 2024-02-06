Feature: Validating display items on Docuport web application V2

  @wip
  Scenario Outline: Validating items for different users V2
    Given Login as "<User type>" V2
    Then Click on left navigate items and validate that items are displayed
    Examples:
      | User type  |
      | Advisor    |
      | Client     |
      | Employee   |
      | Supervisor |