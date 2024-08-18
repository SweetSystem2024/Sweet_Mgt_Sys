
   
Feature: Add Product

  Background:
    Given we have a products table
| Product Num | Product Name | Price | Product Count |
|             |              |       |               |
| 1           | cake         | 2.5   | 150           |
| 2           | tarte        | 6.0   | 203           |
| 3           | kunafa       | 10.5  | 96            |

  Scenario: Successfully add a new product
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Add Product" page
    When I enter the product name "cake"
    And I enter the product price 2.5
    And I enter the product number 1
    And I enter the product count 150
    And the product "cake" not exist in table
    Then the product will be added
    And I should see a confirmation message "Product added successfully"

  Scenario: Add a product with missing details
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Add Product" page
    When I enter the product name "brownie"
    And I enter the product number 5
    And I enter the product count 150
    And I leave the product price blank
    Then I should see an error message "Product price is required"

  Scenario: Add product that already exists in store's product list
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Add Product" page
    When I enter the product name "cake"
    And I enter the product price 3.0
    And I enter the product number 1
    And I enter the product count 150
    And the product "cake" exist
    Then I should see an error message "This product already exists"

          
          