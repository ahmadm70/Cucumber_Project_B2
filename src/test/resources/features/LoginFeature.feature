Feature: Docuport Login/Logout Feature

  Background:
    Given user is on Docuport login page

  @smoke @userStory @testPlan @testExecution @advisor
  Scenario: Login as an advisor
    When user enters username for advisor
    And user enters password for advisor
    And user clicks to login button
    Then user should see the home page for advisor

  @regression @closed @wip @smoke @client
  Scenario: Login as an client
    When user enters username for client
    And user enters password for client
    And user clicks to login button
    Then user should see the home page for client

  @smoke @employee
  Scenario: Login as an employee
    When user enters username for employee
    And user enters password for employee
    And user clicks to login button
    Then user should see the home page for employee

  @smoke @supervisor
  Scenario: Login as an supervisor
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks to login button
    Then user should see the home page for supervisor