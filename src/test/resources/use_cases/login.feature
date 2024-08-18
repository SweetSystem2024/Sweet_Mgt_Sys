Feature: User Login

  Scenario: Successful Login as Regular User
    Given a registered user in the login page wants to log in to sweet_system
    When the user inputs login username "Bisan", password "0000", and email "bisan@gmail.com"
    And all the login credentials are correct
    Then the user should be logged in to sweet_system
    And the system should display the login message "Login successful. Welcome user !"

  Scenario: Successful Login as Admin
    Given a registered admin in the login page wants to log in to sweet_system
    When the admin inputs login username "ahmad", password "0000", and email "ahmad@gmail.com"
    And all the login credentials are correct
    Then the admin should be logged in to sweet_system
    And the system should display the login message "Login successful. Welcome admin !"

  Scenario: Successful Login as Owner
    Given a registered owner in the login page wants to log in to sweet_system
    When the owner inputs login username "ali", password "0000", and email "ali@gmail.com"
    And all the login credentials are correct
    Then the owner should be logged in to sweet_system
    And the system should display the login message "Login successful. Welcome, owner !"

  Scenario: Successful Login as Raw Material User
    Given a registered raw material user in the login page wants to log in to sweet_system
    When the raw material user inputs login username "sami", password "0000", and email "sami@gmail.com"
    And all the login credentials are correct
    Then the raw material user should be logged in to sweet_system
    And the system should display the login message "Login successful. Welcome, rawuser!"

  Scenario: Wrong Password
    Given a registered user in the login page wants to log in to sweet_system
    When the user inputs login username "sanaa", password "1111", and email "sanaa@gmail.com"
    And the password is incorrect
    Then the system should display the login message "Wrong password, try again."

  Scenario: Wrong Email
    Given a registered user in the login page wants to log in to sweet_system
    When the user inputs login username "amal", password "1234", and email "wrong@gmail.com"
    And the email is incorrect
    Then the system should display the login message "Wrong email, try again."

  Scenario: Username Not Registered
    Given a registered user in the login page wants to log in to sweet_system
    When the user inputs login username "wrong", password "7777", and email "wrong@gmail.com"
    And the username is not registered
    Then the system should display the login message "Username not registered. Please sign up."
