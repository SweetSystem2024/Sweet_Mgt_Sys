Feature: Recipe Editing

  Scenario: Successfully Edit a Recipe
    Given I am logged in as user1 "Bisan"
    And I have a recipe named123 "cake with coffee"
    When I navigate to the "Edit Recipe" page for "cake with coffee"
    And I update the recipe details to "Updated details" and instructions to "Updated instructions"
    Then I should see a message123 "Recipe updated successfully"
    And the recipe "cake with coffee" should be updated in the recipes list
    And the updated details should be "Updated details"
    And the updated instructions should be "Updated instructions"

  Scenario: Edit Recipe with Missing Details
    Given I am logged in as user1 "Bisan"
    And I have a recipe named123 "cake with coffee"
    When I navigate to the "Edit Recipe" page for "cake with coffee"
    And I leave the details empty and instructions empty
    And I submit the changes
    Then I should see a message123 "Recipe details and instructions are required"


  Scenario: Edit Non-Existent Recipe
    Given I am logged in as user "Bisan"
    When I navigate to the "Edit Recipe" page for "NonRecipe"
    Then I should see a message123 "Recipe not found"


