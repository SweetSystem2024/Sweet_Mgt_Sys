



package mysweet1;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.Product;
import myApp.myappsweet;

public class UpdateProductSteps {
	boolean x;
	private myappsweet app;
	
	
	
    public UpdateProductSteps (myappsweet app) {
		super();
		this.app = app;
	}
    
	
	@Given("we have this products table")
	public void weHaveThisProductsTable(io.cucumber.datatable.DataTable dataTable) {
	    
	}

	
	
	@Given("we have a product name {string} in product table")
	public void weHaveAProductNameInProductTable(String string) {
		Product p=new Product();
		string="cake";
		   x=p.CheckIfExistToUpdate(string);
		   assertTrue(x);
	}
	
	@Given("the new entered product name {string} is available")
	public void theNewEnteredProductNameIsAvailable(String string) {
		   x=Product.CheckIfExistToUpdate(string);
		   assertFalse(x);

	}

	
	@Then("the product name {string} can be edited to {string}")
	public void theProductNameCanBeEditedTo(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
Product p=new Product();
p.UpdateNameOfProduct(string,string2);
	}

	
	@Given("we have a product name {string} and count {int}  in product table")
	public void weHaveAProductNameAndCountInProductTable(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	      Product p=new Product();
           assertTrue(p.CheckNameAndCount(string,int1));
	}

	@Given("the new entered count {int} is available")
	public void theNewEnteredCountIsAvailable(Integer int1) {
		Product p=new Product();
        assertTrue(p.CheckThenewcountispositive(int1));
	}

	
	@Then("the count {int} can be edited and become {int} and the name still {string}")
	public void theCountCanBeEditedAndBecomeAndTheNameStill(Integer int1, Integer int2, String string) {
	    // Write code here that turns the phrase above into concrete actions
		Product p=new Product();
	       assertTrue(p.SetNewCount(int1,int2,string));
	       }
	
	

	@Given("I want to change the product name {string} to {string}")
	public void iWantToChangeTheProductNameTo(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Given("the product {string} is not exist in the product table")
	public void theProductIsNotExistInTheProductTable(String string) {
		//app.getProducts().clear();;
		//boolean b=Product.CheckIfExistToUpdate(string);
		//	   assertFalse(b);
	}

	@Given("there is a product with name {string} in the product table")
	public void thereIsAProductWithNameInTheProductTable(String string) {
	    x=Product.CheckIfExistToUpdate(string);
		   assertTrue(x);
}

	@When("I attempt to update the product count to a negative value {int}")
	public void iAttemptToUpdateTheProductCountToANegativeValue(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		Product p=new Product();
        assertFalse(p.CheckThenewcountispositive(int1));	}



	
	
}
