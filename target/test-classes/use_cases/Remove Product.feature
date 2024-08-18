Feature: Remove Product

Background:
  Given we have a products table with the following columns:
| Product Num | Product Name | Price | Product Count |
|             |              |       |               |
| 1           | cake         | 2.5   | 150           |
| 2           | tarte        | 6.0   | 203           |
| 3           | kunafa       | 10.5  | 96            |

  Scenario: Successfully Remove a Product
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Remove Product" page
    When I enter the product name "cake" and the product number 1
    And this product "cake" exists in the products table
    Then this product will be remove
    And I should see a confirmation message "Product remove successfully"

  Scenario: Attempt to Remove a Product That Does Not Exist
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Remove Product" page
    When I enter the product name "cake22" and the product number 1
    And this product does not exist in the store's product list
    Then I have to see an error message "The product does not exist"

  Scenario: Remove a Product with Missing Product Number
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Remove Product" page
    When I enter the product name "cake" but do not provide a product number 
    Then I should see an error message "Product number is required"

  Scenario: Remove a Product with Missing Product Name
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Remove Product" page
    When I enter the product number 1 but do not provide a product name
    Then I should see an error message "Product name is required"
