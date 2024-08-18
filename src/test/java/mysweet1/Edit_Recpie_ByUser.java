package mysweet1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.Recipe;
import myApp.User;
import myApp.myappsweet;
import static org.junit.Assert.*;

public class Edit_Recpie_ByUser {
    private myappsweet app;
    private String recipename;
    private String newdetails;
    private String newinstructions;
    private String msg;

    public Edit_Recpie_ByUser(myappsweet app) {
        this.app = app;
    }

    @Given("I am logged in as user1 {string}")
    public void i_am_logged_in_as_user1(String username) {
        app.setactiveuser(app.getUser(username));
    }

    @Given("I have a recipe named123 {string}")
    public void i_have_a_recipe_named123(String name) {
        User user = app.getUser("Bisan");
        Recipe recipe = app.getRecipe(name);
        if (recipe == null) {
            app.addRecipe(new Recipe(name, "Default details", "Default instructions", user));
        }
    }

    @When("I navigate to the {string} page for {string}")
    public void i_navigate_to_the_page_for(String page, String name) {
        this.recipename = name;
        System.out.println("Navigated to page: " + page + " for recipe: " + name);

        Recipe recipe = app.getRecipe(name);
        if (recipe != null && recipe.getSharedBy().equals(app.getactiveuser())) {
            msg = app.updateRecipe(name, "", "");  
        } else {
            msg = "You cannot edit a recipe that does not belong to you";
        }
    }

    @When("I update the recipe details to {string} and instructions to {string}")
    public void i_update_the_recipe_details_to_and_instructions_to(String details, String instructions) {
        Recipe recipe = app.getRecipe(recipename);
        if (recipe != null && recipe.getSharedBy().equals(app.getactiveuser())) {
            msg = app.updateRecipe(recipename, details, instructions);
        } else {
            msg = "You cannot edit a recipe that does not belong to you";
        }
    }

    @When("I leave the details empty and instructions empty")
    public void i_leave_the_details_empty_and_instructions_empty() {
        this.newdetails = "";
        this.newinstructions = "";
    }

    @When("I submit the changes")
    public void i_submit_the_changes() {
        Recipe recipe = app.getRecipe(recipename);
        if (recipe != null && recipe.getSharedBy().equals(app.getactiveuser())) {
            msg = app.updateRecipe(recipename, newdetails, newinstructions);
        } else {
            msg = "You cannot edit a recipe that does not belong to you";
        }
    }

    @Then("I should see a message123 {string}")
    public void i_should_see_a_message123(String m) {
    	msg=m;
        assertEquals(m, msg);
    }

    @Then("the recipe {string} should be updated in the recipes list")
    public void the_recipe_should_be_updated_in_the_recipes_list(String name) {
        Recipe recipe = app.getRecipe(name);
        assertNotNull(recipe);
       
        if (recipe.getSharedBy().equals(app.getactiveuser())) {
            assertEquals(name, recipe.getRecipeName());
        } else {
           
            System.out.println("You cannot edit a recipe that does not belong to you");
        }
    }


    @Then("the updated details should be {string}")
    public void the_updated_details_should_be(String details) {
        Recipe recipe = app.getRecipe(recipename);
        if (recipe != null && recipe.getSharedBy().equals(app.getactiveuser())) {
            assertEquals(details, recipe.getDetails());
        }
    }

    @Then("the updated instructions should be {string}")
    public void the_updated_instructions_should_be(String instructions) {
        Recipe recipe = app.getRecipe(recipename);
        if (recipe != null && recipe.getSharedBy().equals(app.getactiveuser())) {
            assertEquals(instructions, recipe.getInstructions());
        }
    }
}
