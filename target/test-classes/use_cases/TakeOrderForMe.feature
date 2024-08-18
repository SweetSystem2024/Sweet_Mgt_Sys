

Feature: Order placement

Scenario: Successfully order product

  Given I am logged in as a user
  And I am in the order page
  And I want to order a product with name "cake" and with count 2
  And the product "cake" is exist
  Then i will buy "cake" and the number of product  will decrease and become 148
  And I should see a confirmation message "Order done"
  
  
  Scenario: order product and the product is sold out
  
   Given I am logged in as a user
  And I am in the order page
  And I want to order a product with name "cake" and with count 2
  And the product "cake" is sold out
  Then I should see a confirmation message "Sorry the product is sold out"
  
  Scenario: order product and the product not exist
  
   Given I am logged in as a user
  And I am in the order page
  And I want to order a product with name "cake" and with count 2
  And the product "cake" is not exist
  Then I should see a confirmation message "Sorry we do not make this product"
  
  
Scenario: Order Product with Invalid Quantity
Given I am logged in as a user
And I am on the "Order" page
And I want to order a product with name "cake" without specifying the quantity
Then I should see an error message "Quantity is required to place an order."
And the order should not be placed
  



