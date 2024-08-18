




Feature: Supplier View Materials Management

  Background:
   Given the supplier is logged into the system

  Scenario: Supplier views all materials
    Given there are materials in the system
    When the supplier requests to view all materials
    Then the system should display a list of all materials

 
