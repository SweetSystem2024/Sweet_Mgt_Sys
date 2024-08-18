Feature: Admin can delete any type of user

  Background:
    Given I am logged in as an admin and I'm in delete user page

  Scenario: Admin deletes a beneficiary user
    When I select "alaaa" from the user list
    And I click the "Delete" button
    Then the system displays "User has been successfully deleted"

  Scenario: Admin deletes a store owner
    When I select "alia" from the user list
    And I click the "Delete" button
    Then the system displays "Store owner has been successfully deleted"

  Scenario: Admin deletes a raw material supplier
    When I select "salwa" from the user list
    And I click the "Delete" button
    Then the system displays "Raw material supplier has been successfully deleted"

  Scenario: Admin tries to delete a non-existent user
    When I select "huda" from the user list
    And I click the "Delete" button
    Then the system displays "This User does not exist"

