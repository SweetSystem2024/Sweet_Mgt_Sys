Feature: Add Raw Material




  Background:
    Given we have a Materials table
      | Material Num | Material Name | Price | Quantity Available |
      |--------------|---------------|-------|--------------------|
      | 1            | flour         | 2.5   | 150                |
      | 2            | sugar         | 6.0   | 203                |
      | 3            | butter        | 10.5  | 96                 |

  Scenario: Successfully add a new raw material
    Given I am logged in as a raw material supplier
    And I am on the "Add Material" page
    When I enter the material name "cocoa powder"
    And I enter the material price 5.0
    And I enter the material number 4
    And I enter the quantity available 200
    And the material "cocoa powder" does not exist in the table
    Then the material will be added
    And I should see a confirmation message7770 "Material added successfully"

  Scenario: Add a raw material with missing details
    Given I am logged in as a raw material supplier
    And I am on the "Add Material" page
    When I enter the material name "cocoa powder"
    And I enter the material number 5
    And I enter the quantity available 200
    And I leave the material price blank
    Then I should see an error message7770 "Material price is required"

  Scenario: Add a material that already exists in supplier's material list
    Given I am logged in as a raw material supplier
    And I am on the "Add Material" page
    When I enter the material name "sugar"
    And I enter the material price 6.0
    And I enter the material number 2
    And I enter the quantity available 203
    And the material "sugar" exists
    Then I should see an error message7770 "This material already exists"

