Feature: Validating Docuport web application left navigate items

  @smoke
  Scenario Outline: Validating items for "<User type>"
    Given User navigates to Docuport webpage
    When User logs in as "<User type>"
    Then These "<Navigate items>" should be at the left navigation bar
    Examples:
      | User type  | Navigate items                                                                                               |
      | Advisor    | Home, Received docs, My uploads, Clients, Invitations, Users, Leads, Bookkeeping, 1099 Form, Reconciliations |
      | Client     | Home, Received docs, My uploads, Invitations, 1099 Form, Reconciliations                            |
      | Employee   | Home, Received docs, My uploads, Clients, Users, Bookkeeping, 1099 Form, Reconciliations                     |
      | Supervisor | Home, Received docs, My uploads, Clients, Users, Leads, Bookkeeping, 1099 Form, Reconciliations              |