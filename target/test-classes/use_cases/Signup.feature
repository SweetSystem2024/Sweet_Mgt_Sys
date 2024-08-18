

Feature: Sign Up

  Scenario: Successful Sign Up as Regular User
    Given a new regular user wants to create an account in sweet_system
    When the user enters username "Bisan", password "0000", and email "bisan@gmail.com"
    Then the system should check if the username "Bisan" is already taken
    And the system should create a new regular user account
    And the system should display the message "Registration successful"

  Scenario: Successful Sign Up as Admin
    Given a new admin wants to create an account in sweet_system
    When the admin enters username "ahmad", password "0000", and email "ahmad@gmail.com"
    Then the system should check if the username "ahmad" is already taken
    And the system should create a new admin account
    And the system should display the message "Registration successful"

  Scenario: Successful Sign Up as Owner
    Given a new owner wants to create an account in sweet_system
    When the owner enters username "ali", password "0000", and email "ali@gmail.com"
    Then the system should check if the username "ali" is already taken
    And the system should create a new owner account
    And the system should display the message "Registration successful"

  Scenario: Successful Sign Up as Raw Material User
    Given a new raw material user wants to create an account in sweet_system
    When the raw material user enters username "sami", password "0000", and email "sami@gmail.com"
    Then the system should check if the username "sami" is already taken
    And the system should create a new raw material user account
    And the system should display the message "Registration successful"

  Scenario: Username Already Exists
    Given a new user wants to create an account in sweet_system
    When the user enters username "Bisan_joo", password "0000", and email "bisan@gmail.com"
    Then the system should check if the username "Bisan_joo" is already taken
    And the system should display the message "Registration failed Username 'Bisan_joo' already exists Please choose a different username"



