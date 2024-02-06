Feature: Validating display items on Docuport web application

  @smoke
  Scenario Outline: Validating items for different users
    Given Login as "<User type>"
    When Click on "Received docs"
    Then Validate that items are displayed
    When Click on "My uploads"
    Then Validate that items are displayed
    Examples:
      | User type  |
      | Advisor    |
      | Client     |
      | Employee   |
      | Supervisor |