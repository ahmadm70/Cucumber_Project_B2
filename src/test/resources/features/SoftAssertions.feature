Feature: Practice soft assertions

  @softAssertion
  Scenario: Soft assertions practice
    Given User is on docuport login page
    Then User validates "Login" text is displayed
    #And User validates "Forgot password" text is displayed
    When User enters credentials
      | username | b1g2_client@gmail.com |
      | password | Group2                |
    And User validates "Choose account" text is displayed
    Then User chooses account from dropdown
    And User clicks "Continue" button
    And User clicks "Home" button
    And User clicks "Invitations" button