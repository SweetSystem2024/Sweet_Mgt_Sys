package mysweet1;
import myApp.Product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.myappsweet;
import myApp.Product;

public class GettingDiscountSteps {
	private myappsweet app = new myappsweet();

	
	public GettingDiscountSteps (myappsweet app) {
		super();
		this.app = app;
	}
	
	

	@When("a user buys at least one product")
	public void aUserBuysAtLeastOneProduct() {
		Product p=new Product();
		//p.AddToChart(p);
	    Product.itemsbuy.put("HH", p);
	   assertTrue(p.checkiftheuserBuySth());
		
	}
	

	@Then("a discount should be generated")
	public void aDiscountShouldBeGenerated() {
        Product p=new Product();
		p.HaveA10Discount();
		
	}
	

	@When("a user does not buy any product")
	public void aUserDoesNotBuyAnyProduct() {
	    Product.itemsbuy.clear();
		Product p=new Product();
		   assertFalse(p.checkiftheuserBuySth());


	}

	@Then("a discount should not be generated")
	public void aDiscountShouldNotBeGenerated() {

	}

	@Then("I should see a confirmation message123 {string}")
	public void iShouldSeeAConfirmationMessage123(String string) {
	    System.out.println("Sorry , please buy at least one item to get a discount");
	}
	
	@Then("I should see a message456 {string}")
	public void iShouldSeeAMessage456(String string) {
	    
	}


}
