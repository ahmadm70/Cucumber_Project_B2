Feature: Product data table practice

  @smoke
  Scenario: Verify each product price
    Given user is on the home page
    Then user should be able to see expected prices in following products
      | Category | Product           | Expected price |
      | Phones   | Samsung galaxy s6 | 360            |
      | Phones   | Nokia lumia 1520  | 820            |
      | Phones   | Nexus 6           | 650            |
      | Laptops  | Sony vaio i5      | 790            |
      | Laptops  | Sony vaio i7      | 790            |
      | Laptops  | MacBook air       | 700            |
      | Monitors | Apple monitor 24  | 400            |
      | Monitors | ASUS Full HD      | 230            |

  @smoke
  Scenario: Verify each product price
    Given user is on the home page
    Then user should be able to see expected prices in following products (as List<List<String>>)
      | Phones   | Samsung galaxy s6 | 360 |
      | Phones   | Nokia lumia 1520  | 820 |
      | Phones   | Nexus 6           | 650 |
      | Laptops  | Sony vaio i5      | 790 |
      | Laptops  | Sony vaio i7      | 790 |
      | Laptops  | MacBook air       | 700 |
      | Monitors | Apple monitor 24  | 400 |
      | Monitors | ASUS Full HD      | 230 |

  @smoke
  Scenario: Scenario: verify students names on Discord
    Then User should be able to see the following names in their groups
      | Group 1 | Parvana | Yuliia    | Feyruz |
      | Group 2 | Maya    | Ievgeniia | Nadir  |
      | Group 3 | Gavin   | Caglar    | Loop   |