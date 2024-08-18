package mysweet1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.myappsweet;
import myApp.Recipe;
import static org.junit.Assert.*;

public class search_filter__recipe_steps {

    private myappsweet app;
    private String message;

    public search_filter__recipe_steps(myappsweet app) {
        this.app = app;
    }

    @Given("I am logged in as user77 {string}")
    public void i_am_logged_in_as_user77(String username) {
        app.setactiveuser(app.getUser(username));
    }

    @When("I search for a recipe named {string}")
    public void i_search_for_a_recipe_named(String recipeName) {
        Recipe recipe = app.searchRecipe(recipeName);
        if (recipe == null) {
            message = "Recipe not found";
        } else {
            message = recipe.getRecipeName();
        }
    }

    @Then("I should see the recipe {string} in the search results")
    public void i_should_see_the_recipe_in_the_search_results(String Name) {
        assertEquals(Name, message);
    }

    @Given("I have a recipe named {string} with details {string}")
    public void i_have_a_recipe_named_with_details(String recipeName, String details) {
        app.addRecipe(new Recipe(recipeName, details, "Mix ingredients", app.getUser("Bisan")));
    }

    @When("I filter recipes by {string}")
    public void i_filter_recipes_by(String keyword) {
        app.filterRecipe(keyword);
    }

    @Then("I should see recipes categorized as {string} in the results")
    public void i_should_see_recipes_categorized_as_in_the_results(String keyword) {
    	boolean found = false;
    	for (Recipe recipe : app.getFilteredRecipes()) {
    	    if (!recipe.getDetails().toLowerCase().contains(keyword.toLowerCase())) {
    	        found = true;
    	        break; // Exit the loop once a match is found
    	    }
    	}

        assertFalse("Should find recipes that do not contain keyword: " + keyword, found);
    }

    @Then("I should see a message88 {string}")
    public void i_should_see_a_message88(String expectedMessage) {
        assertEquals(expectedMessage, message);
    }
    
    @Given("I have a recipe named {string}")
    public void iHaveARecipeNamed(String string) {
        
    }
    
    
}

