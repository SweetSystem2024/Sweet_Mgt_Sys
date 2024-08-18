
Feature: Communication between Users and Stores

  Scenario: Sending a message to a specific Store Owner or Raw Material Supplier
    Given I am logged in as a user
    And I am on the "Messaging" page
    When I choose a specific Raw Material Supplier or Store Owner
    And I write a message
    And I send the message
    Then the Store Owner or Raw Material Supplier should receive the message
    And I should see a confirmation message "Your message sent successfully"


  Scenario: Receiving a message from a specific Store Owner or Raw Material Supplier
    Given I am logged in as a user
    And I am on the "Messaging" page
    When I choose a specific Raw Material Supplier or Store Owner
    Then I should see the message that was sent to me

    
   Scenario: Sending a message without selecting a recipient

Given I am logged in as a user
And I am on the "messaging" page
When I write a message
And I try to send it without selecting a recipient
Then I should see an error message "Please select a recipient before sending the message"


Scenario: Sending a message with an empty body

Given I am logged in as a user
And I am on the "messaging" page
And I choose a specific Raw Material Supplier or Store Owner
When I try to send an empty message
Then I should see an error message "Message body cannot be empty"





