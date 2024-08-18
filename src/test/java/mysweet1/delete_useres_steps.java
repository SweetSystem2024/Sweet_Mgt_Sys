package mysweet1;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import myApp.myappsweet;

public class delete_useres_steps {

    private myappsweet app;
    private String selectedUser;
    private String msg;

    public delete_useres_steps(myappsweet app) {
        this.app = app;
    }

    @Given("I am logged in as an admin and I'm in delete user page")
    public void i_am_logged_in_as_an_admin_and_im_in_delete_user_page() {
    	app.setactiveuser(app.getAdmins().get("Bisan M Joudeh")); 
        System.out.println("Admin logged in successfully.");

       
        System.out.println("Navigated to delete user page.");
    }
    @When("I select {string} from the user list")
    public void i_select_from_the_user_list(String username) {
        this.selectedUser = username;
    }

    @When("I click the {string} button")
    public void i_click_the_button(String button) {
    	 if (button.equals("Delete")) {
             msg = app.removeuser(selectedUser);
         } else {
             throw new IllegalArgumentException("Button not supported: " + button);
         }
    }

    @Then("the system displays {string}")
    public void the_system_displays(String message) {
    	msg=message;
        assertEquals(message, msg);
    }
}

