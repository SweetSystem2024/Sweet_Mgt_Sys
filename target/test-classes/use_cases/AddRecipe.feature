

Feature: Recipe Sharing

  Scenario: Successfully Share a New Recipe
    Given I am logged in as user "Bisan"
    And I am on the "Share Recipe" page123
    When I enter the recipe name "Donuts"
    And I add details "Delicious fried dough treats" and instructions "Mix ingredients, fry, and dust with sugar"
    And I submit the recipe
    Then I should see a message "Recipe shared successfully"
    And the recipe "Donuts" should be in the shared recipes list
    And it should be shared by "Bisan"

  Scenario: Share Recipe with Missing Name
    Given I am logged in as  user "Bisan"
    And I am on the "Share Recipe" page123
    When I leave the recipe name empty
    And I add details "A sweet, fluffy treat" and instructions "Mix ingredients and bake"
    And I submit the recipe
    Then I should see an error message12 "Recipe name is required"

  Scenario: Share Recipe with Duplicate Name
    Given I am logged in as user "Bisan"
    And I am on the "Share Recipe" page123
    And a recipe named "Cookies" already exists
    When I enter the recipe name "Cookies"
    And I add details "Crunchy and sweet" and instructions "Mix, bake, and cool"
    And I submit the recipe
    Then I should see an message12 "Recipe with this name already exists"


