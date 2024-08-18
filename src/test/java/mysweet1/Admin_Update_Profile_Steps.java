package mysweet1;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.User;
import myApp.myappsweet;

public class Admin_Update_Profile_Steps {
   myappsweet app;
   private String username;
   private String email;
   private String password;
   User u ; 
   boolean found;
   String msg1; // conf msg
   String msg2; // error msg
   
   public Admin_Update_Profile_Steps(myappsweet app) {
	   this.app = app;
   }
   
   @Given("I am logged in as an admin196")
   public void i_am_logged_in_as_an_admin196() {
       app.setactiveuser(app.getAdmins().get("Bisan M Joudeh")); 
       System.out.println("You are logged in as an admin.");
   }

   @Given("there is a store owner with username {string} in the system")
   public void there_is_a_store_owner_with_username_in_the_system(String name) {
       u = app.getUser(name);
       found = (u != null);
   }

   @When("I update the profile for the user with username {string}")
   public void i_update_the_profile_for_the_user_with_username(String string) {
       if (!found) {
           msg2 = "User not found";
       }
   }

   @When("I change their email to {string} and password to {string}")
   public void i_change_their_email_to_and_password_to(String newemail, String newpassword) {
       if (found) {
           if(newemail != null && newpassword != null) {
               u.setEmail(newemail);
               u.setPassword(newpassword);
               msg1 = "Profile updated successfully";
           }
       }
   }

   @Then("the system should update the profile for the user {string}")
   public void the_system_should_update_the_profile_for_the_user(String string) {
       assertEquals("Profile updated successfully", msg1);
   }

   @Then("I should see a confirmation message89630 {string}")
   public void i_should_see_a_confirmation_message89630(String m) {
       assertEquals(m, msg1);
   }

   @Given("there is a raw material supplier with username {string} in the system")
   public void there_is_a_raw_material_supplier_with_username_in_the_system(String name) {
       u = app.getUser(name);
       found = (u != null);
   }

   @Given("there is a beneficiary user with username {string} in the system")
   public void there_is_a_beneficiary_user_with_username_in_the_system(String name) {
       u = app.getUser(name);
       found = (u != null);
   }

   @Given("there is no user with username {string} in the system")
   public void there_is_no_user_with_username_in_the_system(String string) {
       u = app.getUser(string);
       found = (u == null);
   }

   @When("I attempt to update the profile for the user with username {string}")
   public void i_attempt_to_update_the_profile_for_the_user_with_username(String string) {
       if (!found) {
           msg2 = "User not found";
       }
   }

   @Then("the system should not update the profile")
   public void the_system_should_not_update_the_profile() {
       if (!found) {
           assertEquals("User not found", msg2);
       }
   }

   @Then("I should see an error message89630 {string}")
   public void i_should_see_an_error_message89630(String m2) {
	   msg2=m2;
       assertEquals(m2, msg2);
   }

   @Given("there is a user with username {string} in the system")
   public void there_is_a_user_with_username_in_the_system(String name) {
       u = app.getUser(name);
       found = (u != null);
   }

   @Given("there is another user with username {string} in the system")
   public void there_is_another_user_with_username_in_the_system(String name) {
       User anotherUser = app.getUser(name);
       if (anotherUser != null && !anotherUser.equals(u)) {
           msg2 = "Username already exists";
       }
   }

   @When("I attempt to update the username of {string} to {string}")
   public void i_attempt_to_update_the_username_of_to(String currentUsername, String newUsername) {
       User anotherUser = app.getUser(newUsername);
       if (anotherUser != null) {
           msg2 = "Username already exists";
       } else if (found) {
           u.setUsername(newUsername);
           msg1 = "Profile updated successfully";
       }
   }

   @Then("the system should not update the username")
   public void the_system_should_not_update_the_username() {
       assertEquals("Username already exists", msg2);
   }
}
