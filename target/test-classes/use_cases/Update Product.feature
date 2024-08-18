


Feature: Update Product  
Actor:Store owner and raw material supplier

Background:
Given we have this products table
| Product Num | Product Name | Price | Product Count |
|             |              |       |               |
| 1           | cake         | 2.5   | 150           |
| 2           | tarte        | 6.0   | 203           |
| 3           | kunafa       | 10.5  | 96            |
 
 
   Scenario: update product name is successful
  
   Given I am logged in as a store owner or raw material supplier
   And I am on the "Update Product" page
 	And  we have a product name "cake" in product table
 	And the new entered product name "vanilla cake" is available 
 	Then the product name "cake" can be edited to "vanilla cake"
 	
 	Scenario: update product count is successful
  
   Given I am logged in as a store owner or raw material supplier
   And I am on the "Update Product" page
 	And  we have a product name "cake" and count 150  in product table
 	And the new entered count 160 is available 
 	Then the count 150 can be edited and become 160 and the name still "cake"

 	
 	

 	
    Scenario: update product is unsuccessful because it is not exist
   
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Update Product" page
   And I want to change the product name "cake" to "vanilla cake"
   And the product "cake" is not exist in the product table
   Then I should see a confirmation message "The product which you want to update it is not found"
   
   
    Scenario: Update Product with Invalid Data
    Given I am logged in as a store owner or raw material supplier
    And I am on the "Update Product" page
    And there is a product with name "cake" in the product table
    When I attempt to update the product count to a negative value -10
    Then I should see an error message "Invalid product count. Please enter a valid number."
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   