

Feature: Discount on Sales

  Actor: Store Owners and Raw Material Suppliers

  Background:
    Given I am logged in as a store owner or raw material supplier

  Scenario: Successfully get a discount
    Given I am on the "Discount on Sales" page
    When a user buys at least one product
    Then a discount should be generated
    And I should see a confirmation message123 "Congratulations, you got a discount"

  Scenario: Unsuccessfully get a discount
    Given I am on the "Discount on Sales" page
    When a user does not buy any product
    Then a discount should not be generated
    And I should see a message456 "Sorry, but you should buy something to get a discount"

  
  
    
    
    