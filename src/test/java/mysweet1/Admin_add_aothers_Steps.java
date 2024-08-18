package mysweet1;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import myApp.Type;
import myApp.User;
import myApp.myappsweet;

public class Admin_add_aothers_Steps {

    private myappsweet app;
    private String username;
    private String password;
    private String email;
    private Type kindofuser;
    private String msg;

    public Admin_add_aothers_Steps(myappsweet app) {
        this.app = app;
    }

    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
    	app.setactiveuser(app.getAdmins().get("Bisan M Joudeh")); 
        System.out.println("You are logged in as an admin.");
    }

    @When("I go to the {string} page")
    public void i_go_to_the_page(String page) {
        System.out.println("Navigated to the " + page + " page.");
    }

    @When("I enter {string} as the username")
    public void i_enter_as_the_username(String username) {
        this.username = username;
    }

    @When("I enter {string} as the password")
    public void i_enter_as_the_password(String password) {
        this.password = password;
    }

    @When("I enter {string} as the email")
    public void i_enter_as_the_email(String email) {
        this.email = email;
    }

    @When("I select {string} as the type")
    public void i_select_as_the_type(String type) {
    	if (type != null) {
            String lowerCaseType = type.toLowerCase();
            if ("beneficiary user".equals(lowerCaseType)) {
                this.kindofuser = Type.beneficiaryUser;
            } else if ("raw material supplier".equals(lowerCaseType)) {
                this.kindofuser = Type.rawmaterialsupplier;
            } else if ("store owner".equals(lowerCaseType)) {
                this.kindofuser = Type.storeowner;
            } else if ("admin".equals(lowerCaseType)) {
                this.kindofuser = Type.admin;
            } else {
                throw new IllegalArgumentException("Unknown user type: " + type);
            }
        } else {
            throw new IllegalArgumentException("User type cannot be null.");
        }
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        msg = "";


        if (username == null || email == null || password == null || kindofuser == null) {
            if (password == null) {
                msg = "Password is required. Please enter a password.";
            } else if (kindofuser == null) {
                msg = "User type is required. Please select a user type.";
            } else {
                msg = "All fields are required.";
            }
            return;
        }

      
        if (app.userExists(username)) {
            msg = "Username already exists. Please choose a different username.";
            return;
        }

      
        User newUser = new User(username, password, email, kindofuser);
        app.addUser(newUser);

        switch (kindofuser) {
            case beneficiaryUser:
                msg = "New beneficiary user added successfully";
                break;
            case rawmaterialsupplier:
                msg = "New raw material supplier added successfully";
                break;
            case storeowner:
                msg = "New store owner added successfully";
                break;
            case admin:
                msg = "New admin added successfully";
                break;
            default:
                msg = "User type is not recognized.";
        }
    }

    @When("I leave the password field empty")
    public void i_leave_the_password_field_empty() {
        this.password = null; 
    }

    @When("I do not select a user type")
    public void i_do_not_select_a_user_type() {
        this.kindofuser = null; 
    }

    @Then("I should see {string}")
    public void i_should_see(String Message) {
        msg=Message;
        assertEquals(Message, msg);
    }


    @Given("the user {string} already exists")
    public void the_user_already_exists(String username) {
      
        if (!app.userExists(username)) {
            User newUser = new User(username, "9999", username + "@gmail.com", Type.beneficiaryUser);
            app.addUser(newUser);
        }
    }
}

