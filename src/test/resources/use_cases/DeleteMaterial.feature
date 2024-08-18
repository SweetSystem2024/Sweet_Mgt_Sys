

Feature: Remove Material

Background:
  Given we have a materials table with the following columns:
  
      | Material Num | Material Name | Price | Quantity Available |
      |--------------|---------------|-------|--------------------|
      | 1            | flour         | 2.5   | 150                |
      | 2            | sugar         | 6.0   | 203                |
      | 3            | butter        | 10.5  | 96                 |


Scenario: Successfully Remove a Material


  Given I am logged in as a  raw material supplier12 
  And I am on the "Remove Material" page
  When I enter the material name "sugar" and the material number 2
  And this material "sugar" exists in the materials table
  Then this material will be removed
  And I should see a confirmation message1002 "Material removed successfully"

Scenario: Attempt to Remove a Material That Does Not Exist
  Given I am logged in as a  raw material supplier12 
  And I am on the "Remove Material" page
  When I enter the material name "not exist" and the material number 2002
  And this material does not exist in the store's materials list
  Then I have to see an error message1002 "The material does not exist"

Scenario: Remove a Material with Missing Material Number
 Given I am logged in as a  raw material supplier12 
  And I am on the "Remove Material" page
  When I enter the material name "sugar" but do not provide a material number
  Then I should see an error message1002 "Material number is required"

Scenario: Remove a Material with Missing Material Name
 Given I am logged in as a  raw material supplier12 
  And I am on the "Remove Material" page
  When I enter the material number 1 but do not provide a material name
  Then I should see an error message "Material name is required"
