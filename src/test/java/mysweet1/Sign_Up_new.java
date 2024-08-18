
package mysweet1;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.Type;
import myApp.User;
import myApp.myappsweet;

public class Sign_Up_new {
    private myappsweet app;
    public String username;
    public String password;
    public String email;
    String msg;

    public Sign_Up_new(myappsweet app) {
        this.app = app;
    }

    @Given("a new regular user wants to create an account in sweet_system")
    public void a_new_regular_user_wants_to_create_an_account_in_sweet_system() {
    	 msg = null;
         this.username = null;
         this.password = null;
         this.email = null;
       
    }

    @When("the user enters username {string}, password {string}, and email {string}")
    public void the_user_enters_username_password_and_email(String name, String pass, String email) {
        this.username = name;
        this.password = pass;
        this.email = email;
    }

    @Then("the system should check if the username {string} is already taken")
    public void the_system_should_check_if_the_username_is_already_taken(String name) {
        if (app.userExists(name)) {
            msg = "Registration failed Username '" + username + "' already exists Please choose a different username";
        } else {
            msg = "valid username";
        }
    }

    @Then("the system should create a new regular user account")
    public void the_system_should_create_a_new_regular_user_account() {
        if ( msg.contains("valid username")) {
            User u = new User(username, password, email, Type.beneficiaryUser);
            app.addUser(u);
        
        }
        msg = "Registration successful";
    }

    @Then("the system should display the message {string}")
    public void the_system_should_display_the_message(String expectedMessage) {
        assertEquals(expectedMessage, msg);
    }

    @Given("a new admin wants to create an account in sweet_system")
    public void a_new_admin_wants_to_create_an_account_in_sweet_system() {
        msg = null;
    }

    @When("the admin enters username {string}, password {string}, and email {string}")
    public void the_admin_enters_username_password_and_email(String name, String pass, String email) {
        this.username = name;
        this.password = pass;
        this.email = email;
    }

    @Then("the system should create a new admin account")
    public void the_system_should_create_a_new_admin_account() {
        if ( msg.contains("valid username")) {
            User u = new User(username, password, email, Type.admin);
            app.addUser(u);
      
        }
        msg = "Registration successful";
    }

    @Given("a new owner wants to create an account in sweet_system")
    public void a_new_owner_wants_to_create_an_account_in_sweet_system() {
        msg = null;
    }

    @When("the owner enters username {string}, password {string}, and email {string}")
    public void the_owner_enters_username_password_and_email(String name, String pass, String email) {
        this.username = name;
        this.password = pass;
        this.email = email;
    }

    @Then("the system should create a new owner account")
    public void the_system_should_create_a_new_owner_account() {
        if ( msg.contains("valid username")) {
            User u = new User(username, password, email, Type.storeowner);
            app.addUser(u);
       
        }
        msg = "Registration successful";
    }

    @Given("a new raw material user wants to create an account in sweet_system")
    public void a_new_raw_material_user_wants_to_create_an_account_in_sweet_system() {
        msg = null;
    }

    @When("the raw material user enters username {string}, password {string}, and email {string}")
    public void the_raw_material_user_enters_username_password_and_email(String name, String pass, String email) {
        this.username = name;
        this.password = pass;
        this.email = email;
    }

    @Then("the system should create a new raw material user account")
    public void the_system_should_create_a_new_raw_material_user_account() {
        if (msg.contains("valid username")) {
            User u = new User(username, password, email, Type.rawmaterialsupplier);
            app.addUser(u);
          
        }
        msg = "Registration successful";
    }

    @Given("a new user wants to create an account in sweet_system")
    public void a_new_user_wants_to_create_an_account_in_sweet_system() {
        msg = null;
    }
}

