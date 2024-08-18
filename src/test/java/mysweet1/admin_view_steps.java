package mysweet1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import myApp.Type;
import myApp.User;
import myApp.Recipe;
import myApp.myappsweet;

public class admin_view_steps {
    private myappsweet app;
    private String Message;
    private Map<String, User> users;
    private Map<String, Recipe> recipes;

    public admin_view_steps(myappsweet app) {
        this.app = app;
    }

    @Given("the admin is logged into the system")
    public void the_admin_is_logged_into_the_system() {
        
        app.setactiveuser(app.getAdmins().get("Ruba")); 
        assertNotNull(app.getactiveuser());
        assertEquals(Type.admin, app.getactiveuser().getKindofuser());
    }

    @Given("there are users in the system")
    public void there_are_users_in_the_system() {
        users = app.getUsers();
        assertFalse(users.isEmpty());
    }

    @When("the admin requests to view all users")
    public void the_admin_requests_to_view_all_users() {
        if (users == null || users.isEmpty()) {
            Message = "No users found";
        } else {
            Message = "Users: " + users.keySet().toString(); 
        }
    }

    @Then("the system should display a list of all users")
    public void the_system_should_display_a_list_of_all_users() {
        assertNotNull(Message);
        assertTrue(Message.startsWith("Users:"));
    }

    @Given("there are recipes in the system")
    public void there_are_recipes_in_the_system() {
        recipes = app.getAllRecipe();
        assertFalse(recipes.isEmpty());
    }

    @When("the admin requests to view all recipes")
    public void the_admin_requests_to_view_all_recipes() {
        if (recipes == null || recipes.isEmpty()) {
            Message = "No recipes found";
        } else {
           Message = "Recipes: " + recipes.keySet().toString();
        }
    }

    @Then("the system should display a list of all recipes")
    public void the_system_should_display_a_list_of_all_recipes() {
        assertNotNull(Message);
        assertTrue(Message.startsWith("Recipes:"));
    }

   
    @Then("the system should display a message {string}")
    public void the_system_should_display_a_message(String expected) {
        assertEquals(expected, Message);
    }

   
}

