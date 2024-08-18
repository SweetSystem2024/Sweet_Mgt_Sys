package mysweet1;



import myApp.myappsweet;
import myApp.StoreOwnerOrRawSupplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import myApp.Product;
import myApp.StoreOwnerOrRawSupplier;
import myApp.myappsweet;

import org.picocontainer.*;
public class StepsOfAddproductFeature  {
	int num_product;
	double price;
	String name;
	int count;
	boolean result;
    private myappsweet app ;

    public StepsOfAddproductFeature (myappsweet app) {
		super();
		this.app = app;
	}




@Given("we have a products table")
public void weHaveAProductsTable(io.cucumber.datatable.DataTable dataTable) {
	app.isproductFilled=true;
	assertTrue(app.isproductFilled);
	
	}



@Given("I am logged in as a store owner or raw material supplier")
public void iAmLoggedInAsAStoreOwnerOrRawMaterialSupplier() {
	 // check if i am a storeowner or raw material supplier
	StoreOwnerOrRawSupplier op=new StoreOwnerOrRawSupplier();
	result=StoreOwnerOrRawSupplier.logedIn(op);
	assertEquals("You enter as owner or raw",false,result);
     
}

@Given("I am on the {string} page")
public void iAmOnThePage(String string) {
app.printpagename();
}

@When("I enter the product name {string}")
public void iEnterTheProductName(String string) {
name=string;
}

@When("I enter the product price {double}")
public void iEnterTheProductPrice(Double x) {
price=x;

}

@When("I enter the product number {int}")
public void iEnterTheProductNumber(Integer y) {
	num_product=y;
}

@When("I enter the product count {int}")
public void iEnterTheProductCount(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
	count=int1;
}

@When("the product {string} not exist in table")
public void theProductNotExistInTable(String string) {

if(!app.checkifexist(string));
	System.out.println("The product not exist");
}


@Then("the product will be added")
public void theProductWillBeAdded() {
Product p=new Product(num_product,name,price,count);
app.addnewProduct(p);
	   }

@Then("I should see a confirmation message {string}")
public void iShouldSeeAConfirmationMessage(String string) {
app.printDone();
}

@Then("the new product {string} should appear in the store's products table")
public void theNewProductShouldAppearInTheStoreSProductsTable(String string) {
app.viewlistofproducts();
}

@When("I leave the product price blank")
public void iLeaveTheProductPriceBlank() {
	Product P=new Product();
	app.checkifpricefill(P);
}




@Then("I should see an error message {string}")
public void iShouldSeeAnErrorMessage(String string) {
app.printerrormessage();
	
}


@When("the product {string} exist")
public void theProductExist(String string) {
	if(app.checkifexist(string));
	System.out.println("The product  exist");

}




@Then("the new product {string} should not appear in the store's products table")
public void theNewProductShouldNotAppearInTheStoreSProductsTable(String string) {

}



	
}
