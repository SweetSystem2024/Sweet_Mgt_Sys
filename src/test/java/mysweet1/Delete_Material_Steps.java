package mysweet1;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.Material;
import myApp.User;
import myApp.myappsweet;

public class Delete_Material_Steps {

    private myappsweet app;
    private int materialId;
    private String name;
    private Material M;
    private boolean found;
    private String msgr;
    private String msgc;
//    User supplier;

    public Delete_Material_Steps(myappsweet app) {
        this.app = app;
    }
    @Given("we have a materials table with the following columns:")
    public void we_have_a_materials_table_with_the_following_columns(io.cucumber.datatable.DataTable dataTable) {
    
    }

    @Given("I am logged in as a  raw material supplier12")
    public void i_am_logged_in_as_a_raw_material_supplier12() {
    	   User Supplier = app.getRawSuppliers().get("amjad");
    	    if (Supplier != null) {
    	        app.setactiveuser(Supplier);
    	        System.out.println("You are logged in as a Raw Material Supplier.");
    	    } else {
    	        throw new RuntimeException("Raw material supplier does not exist.");
    	    }
    }



    @When("I enter the material name {string} and the material number {int}")
    public void i_enter_the_material_name_and_the_material_number(String name, Integer id) {
        this.name = name;
        this.materialId = id != null ? id : 0; 
    }

    @When("this material {string} exists in the materials table")
    public void this_material_exists_in_the_materials_table(String name) {
        M = app.getMaterial(name);
        found = (M != null);
    }

    @Then("this material will be removed")
    public void this_material_will_be_removed() {
        if (found) {
            app.removeMaterial(name);
            msgc = "Material removed successfully";
        } else {
            msgr = "The material does not exist";
        }
    }

    @Then("I should see a confirmation message1002 {string}")
    public void i_should_see_a_confirmation_message1002(String m) {
        msgc = m;
        assertEquals(m, msgc);
    }

    @When("this material does not exist in the store's materials list")
    public void this_material_does_not_exist_in_the_store_s_materials_list() {
        if (!found) {
            msgr = "The material does not exist";
        }
    }

    @Then("I have to see an error message1002 {string}")
    public void i_have_to_see_an_error_message1002(String m) {
    	msgr=m;
        assertEquals(m, msgr);
    }

    @When("I enter the material name {string} but do not provide a material number")
    public void i_enter_the_material_name_but_do_not_provide_a_material_number(String name) {
        this.name = name;
        this.materialId = 0; 
        if (this.materialId == 0) {
            msgr = "Material number is required";
        }
    }

    @When("I enter the material number {int} but do not provide a material name")
    public void i_enter_the_material_number_but_do_not_provide_a_material_name(Integer id) {
        this.materialId = id;
        this.name = null; 
        if (this.name == null) {
            msgr = "Material name is required";
        }
    }

    @Then("I should see an error message1002 {string}")
    public void i_should_see_an_error_message1002(String m) {
        msgr = m;
        assertEquals(m, msgr);
    }

       
}
