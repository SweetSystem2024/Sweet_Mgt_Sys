Feature: Admin User Management

  Scenario: Successfully Add a Beneficiary User
    Given I am logged in as an admin
    When I go to the "Add User" page
    And I enter "amal" as the username
    And I enter "0000" as the password
    And I enter "amal@gmail.com" as the email
    And I select "beneficiary user" as the type
    And I submit the form
    Then I should see "New beneficiary user added successfully"

  Scenario: Successfully Add a Raw Material Supplier
    Given I am logged in as an admin
    When I go to the "Add User" page
    And I enter "amjad" as the username
    And I enter "0000" as the password
    And I enter "amjad@gmail.com" as the email
    And I select "raw material supplier" as the type
    And I submit the form
    Then I should see "New raw material supplier added successfully"

  Scenario: Successfully Add a Store Owner
    Given I am logged in as an admin
    When I go to the "Add User" page
    And I enter "saden" as the username
    And I enter "0000" as the password
    And I enter "saden@gmail.com" as the email
    And I select "store owner" as the type
    And I submit the form
    Then I should see "New store owner added successfully"

  Scenario: Successfully Add Another Admin
    Given I am logged in as an admin
    When I go to the "Add User" page
    And I enter "Ruba" as the username
    And I enter "0000" as the password
    And I enter "Ruba@gmail.com" as the email
    And I select "admin" as the type
    And I submit the form
    Then I should see "New admin added successfully"

Scenario: Fail to Add a User with an Existing Username
  Given I am logged in as an admin
  And the user "Bisan" already exists
  When I go to the "Add User" page
  And I enter "Bisan" as the username
  And I enter "0000" as the password
  And I enter "Bisan@gmail.com" as the email
  And I select "beneficiary user" as the type
  And I submit the form
  Then I should see "Username already exists. Please choose a different username."


  Scenario: Fail to Add a User with Missing Required Fields
    Given I am logged in as an admin
    When I go to the "Add User" page
    And I enter "sara" as the username
    And I leave the password field empty
    And I enter "sara@gmail.com" as the email
    And I select "raw material supplier" as the type
    And I submit the form
    Then I should see "Password is required. Please enter a password."

  Scenario: Fail to Add a User Due to Missing Type Selection
    Given I am logged in as an admin
    When I go to the "Add User" page
    And I enter "alaa" as the username
    And I enter "0000" as the password
    And I enter "alaa@gmail.com" as the email
    And I do not select a user type
    And I submit the form
    Then I should see "User type is required. Please select a user type."






