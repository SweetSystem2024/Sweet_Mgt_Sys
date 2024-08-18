Feature: Recipe Feedback

  Scenario: Add feedback to a recipe successfully
    Given I am logged in as user20 "Bisan"
    And I have a recipe named "cake with milk"
    When I add feedback "Delicious and easy to make!" to the recipe "cake with milk"
    Then the recipe "cake with milk" should have feedback "Delicious and easy to make!"

  Scenario: Add feedback to a non-existent recipe
    Given I am logged in as user20 "Bisan"
    When I add feedback "This recipe does not exist." to the recipe "non-existent recipe"
    Then I should see a message100 "Recipe not found. Feedback cannot be added."



  Scenario: Add feedback to a recipe with no feedback
    Given I am logged in as user20 "Bisan"
    And I have a recipe named "cake with milk"
    When I add feedback "This recipe is wonderful!" to the recipe "cake with milk"
    Then the recipe "cake with milk" should have feedback "This recipe is wonderful!"

  Scenario: Add feedback with empty text
    Given I am logged in as user20 "Bisan"
    And I have a recipe named "cake with milk"
    When I add feedback "" to the recipe "cake with milk"
    Then I should see a message100 "Feedback cannot be empty."

