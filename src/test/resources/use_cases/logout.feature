

Feature: Logout

Given the user "Bisan" is currently logged into the system
When the user requests to log out
Then the system should log the user out
And a message "You have successfully logged out of the system" should appear


Scenario: User cannot logout
Given the user "Ali" is not logged into the system
When the user requests to log out
Then the system should prevent the logout attempt
And a message "Logout failed. You are not logged in" should appear