package mysweet1;
import myApp.Message;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.Message;
import myApp.Type;
import myApp.User;
import myApp.myappsweet;



public class CommunicationWithOthersSteps {

	
	
	

    private myappsweet app;

	public CommunicationWithOthersSteps(myappsweet app) {
        this.app = app;
    }
	
	@When("I choose a specific Raw Material Supplier or Store Owner")
	public void iChooseASpecificRawMaterialSupplierOrStoreOwner() {
	    // Write code here that turns the phrase above into concrete actions
		String reciver="ali@gmail.com";
	assertTrue(Message.ichooseacoorectOwner(reciver));
	}

	@When("I write a message")
	public void iWriteAMessage() {
	    	}

	@When("I send the message")
	public void iSendTheMessage() {
		Message m=new Message();
		Message.SendMessage(m);
	
	}

	@Then("the Store Owner or Raw Material Supplier should receive the message")
	public void theStoreOwnerOrRawMaterialSupplierShouldReceiveTheMessage() {
	}

	@Then("I should see the message that was sent to me")
	public void iShouldSeeTheMessageThatWasSentToMe() {
		myappsweet ap=new myappsweet();
	   // User u=new User("Bisan","0000","bisan@gmail.com",Type.beneficiaryUser);
	    assertTrue(app.ViewMessageSetToMe("ali@gmail.com"));
	}

	@When("I try to send it without selecting a recipient")
	public void iTryToSendItWithoutSelectingARecipient() {
	    
		Message m=new Message("bbb","","kkk");
		assertFalse(Message.checkifiselectareciption(m));
		
	}

	/*@Given("I choose a specific Raw Material Supplier or Store Owner")
	public void iChooseASpecificRawMaterialSupplierOrStoreOwner() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/

	@When("I try to send an empty message")
	public void iTryToSendAnEmptyMessage() {
		Message m=new Message("bbb","kkk","");
		assertFalse(Message.checkifienteramessage(m));
	}



	
	
	
	
}