Feature: Recipe Search and Filtering

  Scenario: Search for a recipe that does not exist
    Given I am logged in as user77 "Bisan"
    When I search for a recipe named "rrr"
    Then I should see a message88 "Recipe not found"

  Scenario: Search for a recipe that exists
    Given I am logged in as user77 "Bisan"
    And I have a recipe named "cake with milk"
    When I search for a recipe named "cake with milk"
    Then I should see the recipe "cake with milk" in the search results

  Scenario: Filter recipes based on dietary needs and see results
    Given I am logged in as user77 "Bisan"
    When I filter recipes by "suger free"
    Then I should see recipes categorized as "suger free" in the results

 