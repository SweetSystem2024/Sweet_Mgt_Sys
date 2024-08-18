


Feature: Admin User Profile Update

  Scenario: Admin updates profile for a store owner
    Given I am logged in as an admin196
    And there is a store owner with username "ali" in the system
    When I update the profile for the user with username "ali"
    And I change their email to "ali_new@gmail.com" and password to "1111"
    Then the system should update the profile for the user "ali"
    And I should see a confirmation message89630 "Profile updated successfully"

  Scenario: Admin updates profile for a raw material supplier
    Given I am logged in as an admin196
    And there is a raw material supplier with username "sami" in the system
    When I update the profile for the user with username "sami"
    And I change their email to "sami_new@gmail.com" and password to "1111"
    Then the system should update the profile for the user "sami"
    And I should see a confirmation message89630 "Profile updated successfully"

  Scenario: Admin updates profile for a beneficiary user
    Given I am logged in as an admin196
    And there is a beneficiary user with username "Bisan" in the system
    When I update the profile for the user with username "Bisan"
    And I change their email to "bisan_new@gmail.com" and password to "1111"
    Then the system should update the profile for the user "Bisan"
    And I should see a confirmation message89630 "Profile updated successfully"

  Scenario: Admin attempts to update profile for a non-existent user
    Given I am logged in as an admin196
    And there is no user with username "notexist" in the system
    When I attempt to update the profile for the user with username "notexist"
    Then the system should not update the profile
    And I should see an error message89630 "User not found"

  Scenario: Admin attempts to update a username to an existing username
    Given I am logged in as an admin196
    And there is a user with username "ali" in the system
    And there is another user with username "sami" in the system
    When I attempt to update the username of "ali" to "sami"
    Then the system should not update the username
    And I should see an error message89630 "Username already exists"

