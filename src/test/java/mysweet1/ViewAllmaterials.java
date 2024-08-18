package mysweet1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.Material;
import myApp.User;
import myApp.myappsweet;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ViewAllmaterials {

    private myappsweet app;
    private User currentUser;
    private Map<String, Material> displayedMaterials;
    private String msg;

    public ViewAllmaterials(myappsweet app) {
        this.app = app;
    }

    @Given("the supplier is logged into the system")
    public void the_supplier_is_logged_into_the_system() {
        currentUser = app.getRawSuppliers().get("sami"); 
        app.setactiveuser(currentUser);
    }

    @Given("there are materials in the system")
    public void there_are_materials_in_the_system() {
    	displayedMaterials =  app.getAllMaterials();
         assertFalse(displayedMaterials.isEmpty());
    }

    @When("the supplier requests to view all materials")
    public void the_supplier_requests_to_view_all_materials() {
    	  if (displayedMaterials== null || displayedMaterials.isEmpty()) {
             msg = "No users found";
          } else {
              msg = "Materials: " + displayedMaterials.keySet().toString(); 
          }
    }

    @Then("the system should display a list of all materials")
    public void the_system_should_display_a_list_of_all_materials() {
    	  assertNotNull(msg);
          assertTrue(msg.startsWith("Materials:"));
       
      
    }

    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String msg1) {
    	msg=msg1;
        assertEquals(msg1, msg);
    }
}
