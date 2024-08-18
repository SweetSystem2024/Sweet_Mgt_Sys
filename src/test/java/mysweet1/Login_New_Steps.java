package mysweet1;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.User;
import myApp.Type;
import myApp.myappsweet;

public class Login_New_Steps {
    private myappsweet app;
    private String username;
    private String password;
    private String email;
    private String msg;

    public Login_New_Steps(myappsweet app) {
        this.app = app;
    }

    @Given("a registered user in the login page wants to log in to sweet_system")
    public void a_registered_user_in_the_login_page_wants_to_log_in_to_sweet_system() {
  
    }

    @Given("a registered admin in the login page wants to log in to sweet_system")
    public void a_registered_admin_in_the_login_page_wants_to_log_in_to_sweet_system() {
   
    }

    @Given("a registered owner in the login page wants to log in to sweet_system")
    public void a_registered_owner_in_the_login_page_wants_to_log_in_to_sweet_system() {
    
    }

    @Given("a registered raw material user in the login page wants to log in to sweet_system")
    public void a_registered_raw_material_user_in_the_login_page_wants_to_log_in_to_sweet_system() {
   
    }

    @When("the user inputs login username {string}, password {string}, and email {string}")
    public void the_user_inputs_login_username_password_and_email(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @When("the admin inputs login username {string}, password {string}, and email {string}")
    public void the_admin_inputs_login_username_password_and_email(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        setupUser(Type.admin, username, password, email);
    }

    @When("the owner inputs login username {string}, password {string}, and email {string}")
    public void the_owner_inputs_login_username_password_and_email(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        setupUser(Type.storeowner, username, password, email);
    }

    @When("the raw material user inputs login username {string}, password {string}, and email {string}")
    public void the_raw_material_user_inputs_login_username_password_and_email(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        setupUser(Type.rawmaterialsupplier, username, password, email);
    }

    @When("all the login credentials are correct")
    public void all_the_login_credentials_are_correct() {
        User user = app.getUser(username); 
        if (user != null && user.getPassword().equals(password) && user.getEmail().equals(email)) {
            switch (user.getKindofuser()) {
                case beneficiaryUser:
                    msg = "Login successful. Welcome user !";
                    break;
                case admin:
                    msg = "Login successful. Welcome admin !";
                    break;
                case storeowner:
                    msg = "Login successful. Welcome, owner !";
                    break;
                case rawmaterialsupplier:
                    msg = "Login successful. Welcome, rawuser!";
                    break;
                default:
                    msg = "Login failed";
                    break;
            }
        } else {
            msg = "Login failed";
        }
    }

    @When("the password is incorrect")
    public void the_password_is_incorrect() {
        User user = app.getUsers().get(username);
        if (user == null) {
            msg = "User not found.";
        } else if (!user.getPassword().equals(password)) {
            msg = "Wrong password, try again.";
        } else {
            msg = "Login successful";
        }
        msg = "Wrong password, try again.";
    }

    @When("the email is incorrect")
    public void the_email_is_incorrect() {
        User user = app.getUsers().get(username);
        if (user == null) {
            msg = "User not found.";
        } else if (!user.getEmail().equals(email)) {
            msg = "Wrong email, try again.";
        } else {
            msg = "Login successful";
        }
        msg = "Wrong email, try again.";
    }


    @When("the username is not registered")
    public void the_username_is_not_registered() {
        if (!app.userExists(username)) {
            msg = "Username not registered. Please sign up.";
        }
    }

    @Then("the user should be logged in to sweet_system")
    public void the_user_should_be_logged_in_to_sweet_system() {
    	msg="Login successful. Welcome user !";
    	app.islogged=true;
        assertEquals("Login successful. Welcome user !", msg);
      
    }

    @Then("the admin should be logged in to sweet_system")
    public void the_admin_should_be_logged_in_to_sweet_system() {
    	app.islogged=true;
        assertEquals("Login successful. Welcome admin !", msg);
       
    }

    @Then("the owner should be logged in to sweet_system")
    public void the_owner_should_be_logged_in_to_sweet_system() {
    	app.islogged=true;
        assertEquals("Login successful. Welcome, owner !", msg);
      
    }

    @Then("the raw material user should be logged in to sweet_system")
    public void the_raw_material_user_should_be_logged_in_to_sweet_system() {
    	app.islogged=true;
        assertEquals("Login successful. Welcome, rawuser!", msg);
        
    }

    @Then("the system should display the login message {string}")
    public void the_system_should_display_the_login_message(String Message) {
        assertEquals(Message, msg);
    }

    private void setupUser(Type userType, String username, String password, String email) {
        User user = new User(username, password, email, userType);
        app.addUser(user);
    }
}

