Feature: Client Management

  @smoke
  Scenario: Creating personal client
    Given User logs in as an advisor and clicks on the "Clients" link
    When User creates a new "personal" client with the following data:
      | column           | information                 |
      | First name       | Leonardo                    |
      | Last name        | Da Vinci                    |
      | Email address    | leonardo_da_vinci@gmail.com |
      | Advisor          | Batch1 Group2               |
      | Phone number     | +8658656565                 |
      | Password         | daVinci1452                 |
      | Confirm password | daVinci1452                 |
    And User validates the new "personal" client and logs out as an advisor
    Then Users should be able to log in as the new "personal" client

  @smoke
  Scenario: Creating business client
    Given User logs in as an advisor and clicks on the "Clients" link
    When User creates a new "business" client with the following data:
      | column           | information            |
      | Company name     | Florence Art Comp      |
      | First name       | Leonardo               |
      | Last name        | Da Vinci               |
      | Email address    | florence_art@gmail.com |
      | Advisor          | Batch1 Group2          |
      | Phone number     | +8658658665            |
      | Password         | monaLisa1503           |
      | Confirm password | monaLisa1503           |
    And User validates the new "business" client and logs out as an advisor
    Then Users should be able to log in as the new "business" client