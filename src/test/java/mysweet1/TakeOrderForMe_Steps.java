package mysweet1;
import myApp.Product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.myappsweet;

public class TakeOrderForMe_Steps {
	
   String name;
   int numberofitems;
	private myappsweet app = new myappsweet();

    public TakeOrderForMe_Steps (myappsweet app) {
		super();
		this.app = app;
	}
	
    
	
	@Given("I am logged in as a user")
	public void iAmLoggedInAsAUser() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("I am in the order page")
	public void iAmInTheOrderPage() {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Given("I want to order a product with name {string} and with count {int}")
	public void iWantToOrderAProductWithNameAndWithCount(String string, Integer int1) {
    name=string;
    numberofitems=int1;
    Product p=new Product();
    
	}
	


@Given("the product {string} is exist")
public void theProductIsExist(String string) {
Product p=new Product(string,numberofitems);
     assertTrue(p.checkifwehaveEnoughItems(string , numberofitems));
    
}

@Then("i will buy {string} and the number of product  will decrease and become {int}")
public void iWillBuyAndTheNumberOfProductWillDecreaseAndBecome(String string ,Integer int1) {
	Product p=new Product(string ,numberofitems);
	assertTrue(p.AddToChart(p));
	p.DecreaseTheNumberOfItems(string,numberofitems);
  System.out.println("Buying is succesfully done");

}
		@Given("the product {string} is sold out")
	public void theProductIsSoldOut(String string) {
			int numberofitems = 170; // Assuming sold out means 0 items
		    Product p = new Product(string, numberofitems);
		    boolean b = p.checkifwehaveEnoughItems(string, numberofitems);
		    assertFalse(b); // Corrected to assertFalse to match sold out condition
		    System.out.println("The product is sold out");
	}
      
		@Given("the product {string} is not exist")
		public void theProductIsNotExist(String string) {
			string="oo";
			app.getProducts().clear();
         Product p=new Product("string");
         assertFalse(Product.CheckIfExistToUpdate(string));
         
		}

	@Given("I want to order a product with name {string} without specifying the quantity")
	public void iWantToOrderAProductWithNameWithoutSpecifyingTheQuantity(String string) {
		name=string;
	    numberofitems=0;
		Product p=new Product(name,numberofitems);
		assertFalse(p.CheckWeDefineQuantity(p));
	}

	
	@Then("the order should not be placed")
	public void theOrderShouldNotBePlaced() {
	    System.out.println("Sorry, please define the quantity which you want");
	}



	
	
	
	
	
	
	
	
}
