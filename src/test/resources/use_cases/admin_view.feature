Feature: Admin View Management

  Background:
    Given the admin is logged into the system

  Scenario: Admin views all users
    Given there are users in the system
    When the admin requests to view all users
    Then the system should display a list of all users

  Scenario: Admin views all recipes
    Given there are recipes in the system
    When the admin requests to view all recipes
    Then the system should display a list of all recipes


