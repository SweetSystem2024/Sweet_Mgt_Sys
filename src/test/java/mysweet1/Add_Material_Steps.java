package mysweet1;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.Material;
import myApp.User;
import myApp.myappsweet;

public class Add_Material_Steps {

    private myappsweet app;
    private int materialId;
    private String name;
    private double price;
    private int quantityAvailable;
    private Material M;
    private boolean found;
    private boolean isPriceBlank;
    private String msg1; 
    private String msg2;  

    public Add_Material_Steps(myappsweet app) {
        this.app = app;
        this.msg1 = null;
        this.msg2 = null;
    }

    @Given("we have a Materials table")
    public void we_have_a_materials_table(io.cucumber.datatable.DataTable dataTable) {
      
    }

    @Given("I am logged in as a raw material supplier")
    public void i_am_logged_in_as_a_raw_material_supplier() {
    	  User Supplier = app.getRawSuppliers().get("amjad");
  	    if (Supplier != null) {
  	        app.setactiveuser(Supplier);
  	        System.out.println("You are logged in as a Raw Material Supplier.");
  	    } else {
  	        throw new RuntimeException("Raw material supplier  does not exist.");
  	    }
    }

    @When("I enter the material name {string}")
    public void i_enter_the_material_name(String name) {
        this.name = name;
    }

    @When("I enter the material price {double}")
    public void i_enter_the_material_price(Double price) {
        this.price = price;
        this.isPriceBlank = false;
    }

    @When("I leave the material price blank")
    public void i_leave_the_material_price_blank() {
        this.isPriceBlank = true;
        this.price = 0;
    }

    @When("I enter the material number {int}")
    public void i_enter_the_material_number(Integer id) {
        this.materialId = id;
    }

    @When("I enter the quantity available {int}")
    public void i_enter_the_quantity_available(Integer quantity) {
        this.quantityAvailable = quantity;
    }

    @When("the material {string} does not exist in the table")
    public void the_material_does_not_exist_in_the_table(String name) {
        M = app.getMaterial(name);
        found = (M == null);
    }

    @When("the material {string} exists")
    public void the_material_exists(String name) {
        M = app.getMaterial(name);
        found = (M != null);
    }

    @Then("the material will be added")
    public void the_material_will_be_added() {
        if (found) {
            msg1 = "This material already exists";
        } else {
            if (isPriceBlank) {
                msg1 = "Material price is required";
            } else {
                M = new Material(materialId, name, price, quantityAvailable);
                app.addMaterial(M);
                msg2 = "Material added successfully";
            }
        }
    }

    @Then("I should see an error message7770 {string}")
    public void i_should_see_an_error_message7770(String m) {
    	msg1=m;
        assertEquals(m, msg1);
    }

    @Then("I should see a confirmation message7770 {string}")
    public void i_should_see_a_confirmation_message7770(String m) {
    	msg2=m;
        assertEquals(m, msg2);
    }
}
