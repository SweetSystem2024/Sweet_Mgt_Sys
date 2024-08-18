package mysweet1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.Product;
import myApp.myappsweet;

public class RemoveProductSteps {
     String name;
     int num;
     boolean result;
     boolean resultnot;
     Product p;
	private myappsweet app = new myappsweet();

    public RemoveProductSteps (myappsweet app) {
		super();
		this.app = app;
	}
	
	
	
	@Given("we have a products table with the following columns:")
	public void weHaveAProductsTableWithTheFollowingColumns(io.cucumber.datatable.DataTable dataTable) {
	    
	}

	@When("I enter the product name {string} and the product number {int}")
	public void iEnterTheProductNameAndTheProductNumber(String productname, Integer productnumb) {
	    name=productname;
	    num=productnumb;
	    p=new Product(name,num);
	    
	}

	
	
	@When("this product {string} exists in the products table")
	public void thisProductExistsInTheProductsTable(String string) {
		string="cakeee";
		int integer=12;
		double double2=1.00;
		int integer2=3;
		Product a=new Product(integer,string,double2,integer2);
		app.addnewProduct(a);
		result=app.checkifexisttoremove(a);
        assertTrue(result);
        System.out.println("The product is exist");
		
	}
	
	
	@Then("this product will be remove")
	public void thisProductWillBeRemove() {
	    // Write code here that turns the phrase above into concrete actions
app.RemoveProduct(p);
	
	}

	@When("this product does not exist in the store's product list")
	public void thisProductDoesNotExistInTheStoreSProductList() {
	    // Write code here that turns the phrase above into concrete actions
		Product b=new Product();
		assertFalse(app.checkifexisttoremove(b));
         
	}

	@When("I enter the product name {string} but do not provide a product number")
	public void iEnterTheProductNameButDoNotProvideAProductNumber(String string) {

   p=new Product(name,0);
   assertFalse(app.EnterAllRequieredToDelete(p));
		
	}

	@When("I enter the product number {int} but do not provide a product name")
	public void iEnterTheProductNumberButDoNotProvideAProductName(Integer int1) {
    Product pp=new Product(" ",int1);
    assertFalse(app.EnterAllRequieredToDelete(pp));
     
	}


	@Then("I have to see an error message {string}")
	public void iHaveToSeeAnErrorMessage(String string) {
		app.printproductnotexist();

}
	
	
	
	
	
	
	
	
}
