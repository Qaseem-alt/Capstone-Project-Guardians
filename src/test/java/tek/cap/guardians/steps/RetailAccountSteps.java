package tek.cap.guardians.steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.cap.guardians.pages.POMFactory;
import tek.cap.guardians.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {
	
	POMFactory factory = new POMFactory();
	
	// steps for @UpdateProfile
	@Given("user cklick on account Link")
	public void userCklickOnAccountLink() {
		click(factory.accountPage().AcountOptions);
		logger.info("User clicked on Account Option Link Successfully");
	}
	
	@When("User User update {string} And {string} values")
	public void userUserUpdateAndValues(String Name, String Phone) {
	
		clearTextUsingSendKeys(factory.accountPage().nameInputField);
		sendText(factory.accountPage().nameInputField, Name);
		clearTextUsingSendKeys(factory.accountPage().phoneInputField);
		sendText(factory.accountPage().phoneInputField, Phone);
		logger.info("Phone and Name value enterd successfully");
	}
	@When("user click on update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().ProUpdateBttn);
		logger.info("User clicked on update button Successfully");
	}
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().ProUpdateSuccessMsg);
		Assert.assertTrue(factory.accountPage().ProUpdateSuccessMsg.isDisplayed());
		logger.info("User Profile Updated Successdully");
}
	// steps for @AddPayment
	@When("User click on add a paymnet method")
	public void userClickOnAddAPaymnetMethod() {
		waitTillPresence(factory.accountPage().AddPaymentLink);
	//	click(factory.accountPage().AddPaymentLink);
		logger.info("User clicked on Add a payment method Successfully");
	}
	@When("user fill Debit or cridit card information")
	public void userFillDebitOrCriditCardInformation(DataTable dataTable) {
	    //  List<Map<K,V>>,
		List<Map<String, String>> cardData = dataTable.asMaps(String.class,String.class);
		sendText(factory.accountPage().CardNumberInputFeild, cardData.get(0).get("cardNumber"));
		sendText(factory.accountPage().cardNameInputFeild, cardData.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().ExpirationMuonthBttn, cardData.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().ExpirationYearBttn, cardData.get(0).get("expirationYear"));
		sendText(factory.accountPage().SecurityCodeinputFeild, cardData.get(0).get("securityCode"));
		logger.info("Card Information entered successfully");
		

	}
	@When("User click on Add your card")
	public void userClickOnAddYourCard() {
		waitTillClickable(factory.accountPage().addCardBttn);
		click(factory.accountPage().addCardBttn);
		logger.info("User Clicked on Add your card button Successfully");
	}
	@Then("A massege Should be displayed {string}")
	public void aMassegeShouldBeDisplayed(String Expected) {
		
		if (Expected.contains("Payment method Added succe")) {
		waitTillPresence(factory.accountPage().addCardSuccessMssg);
		Assert.assertEquals(Expected, factory.accountPage().addCardSuccessMssg.getText());
		logger.info("Payment method Added successfully");
		
	} else if (Expected.contains("Address Updated Succe")) {
		waitTillPresence(factory.accountPage().UpdateAddressSuccessMssg);
		Assert.assertEquals(Expected, factory.accountPage().UpdateAddressSuccessMssg.getText());
		logger.info("Address Updated Successfully");
	}
		
		
	}
		
	// this is the steps for @UpdatePaymentInfo 
	
	@Given("User click on edit Option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().CardIcon);
		logger.info("User Clicked On Exited card Icon Succeessfully");
	}
	@Given("User click on Edit option")
	public void userClickOnEditOption() {
		waitTillPresence(factory.accountPage().CardEditBttn);
		click(factory.accountPage().CardEditBttn);
		logger.info("User clicked on Card Edite Button Successfully");
	}
	@Given("Update Debit or Cridit cart window PopUp")
	public void updateDebitOrCriditCartWindowPopUp() {
		waitTillPresence(factory.accountPage().UpdateCardWindow);
		Assert.assertTrue(factory.accountPage().UpdateCardWindow.isDisplayed());
		logger.info("Update Window Opened Successfyllu");
	}
	@Given("User edit information with below inforation")
	public void userEditInformationWithBelowInforation(DataTable dataTable) {
		List<Map<String, String>> updateData = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.accountPage().CardNumberInputFeild);
		sendText(factory.accountPage().CardNumberInputFeild, updateData.get(0).get("cardNumber"));
		clearTextUsingSendKeys(factory.accountPage().cardNameInputFeild);
		sendText(factory.accountPage().cardNameInputFeild, updateData.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().ExpirationMuonthBttn, updateData.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().ExpirationYearBttn, updateData.get(0).get("expirationYear"));
		clearTextUsingSendKeys(factory.accountPage().SecurityCodeinputFeild);
		sendText(factory.accountPage().SecurityCodeinputFeild, updateData.get(0).get("securityCode"));
		logger.info("New Card Information Enterd Successfully");
	}

	@Given("user click on update your card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().updateCardBttn);
		logger.info("User clicked on Update your Card Button Successfully");
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String ExpectedText) {
		waitTillPresence(factory.accountPage().CardUpdateSuccessMssg);
		Assert.assertEquals(ExpectedText, factory.accountPage().CardUpdateSuccessMssg.getText());
		logger.info("Card Updated Successfully");
		
	}
	
	// These are the steps for @RemovePaymentCard
	
	@When("User Slecte the card to remove")
	public void userSlecteTheCardToRemove() {
		waitTillClickable(factory.accountPage().CardIcon);
		click(factory.accountPage().CardIcon);
		logger.info("User clicked on Exiting card Icon Successfully");
	}
	@When("User click on Remove option of the card")
	public void userClickOnRemoveOptionOfTheCard() {
		waitTillClickable(factory.accountPage().removeCardButtn);
		click(factory.accountPage().removeCardButtn);
		logger.info("User clicked on remove button successfully");
	}
	@Then("Payment Details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		waitTillPresence(factory.accountPage().addCardBttn);
		Assert.assertEquals(true, (factory.accountPage().addCardBttn).isDisplayed());
		logger.info("Selected Payment card removed Successfylly");
	}
	
	// These are the steps for @AddAddress
	
	@When("User click on Add Address Icon")
	public void userClickOnAddAddressIcon() {
		
		waitTillPresence(factory.accountPage().AddAddressIcon);
		click(factory.accountPage().AddAddressIcon);	
		logger.info("User Clicked on Add Adress Icon successfully");
	}
	@When("User fill the information with below data")
	public void userFillTheInformationWithBelowData(DataTable dataTable) {
		waitTillPresence(factory.accountPage().counteryDropdown);
		List<Map<String, String>> AdressApdateinfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().counteryDropdown, AdressApdateinfo.get(0).get("Country"));
		clearTextUsingSendKeys(factory.accountPage().fullNameaddAddress);
		sendText(factory.accountPage().fullNameaddAddress, AdressApdateinfo.get(0).get("FullName"));
		clearTextUsingSendKeys(factory.accountPage().phoneNumAddAddress);
		sendText(factory.accountPage().phoneNumAddAddress, AdressApdateinfo.get(0).get("PhoneNumber"));
		clearTextUsingSendKeys(factory.accountPage().streetInputFeild);
		sendText(factory.accountPage().streetInputFeild, AdressApdateinfo.get(0).get("Address"));
		clearTextUsingSendKeys(factory.accountPage().apartmentInputFeild);
		sendText(factory.accountPage().apartmentInputFeild,AdressApdateinfo.get(0).get("AptUnitOrEtc"));
		clearTextUsingSendKeys(factory.accountPage().cityInputFeild);
		sendText(factory.accountPage().cityInputFeild, AdressApdateinfo.get(0).get("City"));
		selectByVisibleText(factory.accountPage().stateDropDown, AdressApdateinfo.get(0).get("State"));
		clearTextUsingSendKeys(factory.accountPage().zipCodeInputFeild);
		sendText(factory.accountPage().zipCodeInputFeild, AdressApdateinfo.get(0).get("ZipCode"));

		logger.info("User enterd Add adress data successfully");
	}
	@When("User click on Add Your Address button")
	public void userClickOnAddYourAddressButton() {
	click(factory.accountPage().AddYourAddressBttn);
	logger.info("User clicked on Add your address button successfully");
		 
	}
	@Then("Address Added Successfully Massage popUp")
	public void addressAddedSuccessfullyMassagePopUp() {
		waitTillPresence(factory.accountPage().AddAddressSuccessMssg);
		Assert.assertTrue(factory.accountPage().AddAddressSuccessMssg.isDisplayed());
		logger.info("User added an address Successfully");
  	}

	//These are the steps for @UpdateAddress 
	
	@Given("User click on edit address option")
	public void userClickOnEditAddressOption() {
		waitTillClickable(factory.accountPage().AddressEditBttn);
		click(factory.accountPage().AddressEditBttn);
		logger.info("User clicked on address Edit buttom Successfully");
	}
	@Given("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		waitTillPresence(factory.accountPage().counteryDropdown);
		List<Map<String, String>> AdressApdateinfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().counteryDropdown, AdressApdateinfo.get(0).get("Country"));
		clearTextUsingSendKeys(factory.accountPage().fullNameaddAddress);
		sendText(factory.accountPage().fullNameaddAddress, AdressApdateinfo.get(0).get("FullName"));
		clearTextUsingSendKeys(factory.accountPage().phoneNumAddAddress);
		sendText(factory.accountPage().phoneNumAddAddress, AdressApdateinfo.get(0).get("PhoneNumber"));
		clearTextUsingSendKeys(factory.accountPage().streetInputFeild);
		sendText(factory.accountPage().streetInputFeild, AdressApdateinfo.get(0).get("Address"));
		clearTextUsingSendKeys(factory.accountPage().apartmentInputFeild);
		sendText(factory.accountPage().apartmentInputFeild,AdressApdateinfo.get(0).get("AptUnitOrEtc"));
		clearTextUsingSendKeys(factory.accountPage().cityInputFeild);
		sendText(factory.accountPage().cityInputFeild, AdressApdateinfo.get(0).get("City"));
		selectByVisibleText(factory.accountPage().stateDropDown, AdressApdateinfo.get(0).get("State"));
		clearTextUsingSendKeys(factory.accountPage().zipCodeInputFeild);
		sendText(factory.accountPage().zipCodeInputFeild, AdressApdateinfo.get(0).get("ZipCode"));
	}
	@Given("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
	    	click(factory.accountPage().UpdateAdressBttn);
	    	logger.info("User clicked on Update Your Address Successfully");
	}
	
	// These Steps are for @RemoveExistAddress
	
	@Given("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		waitTillPresence(factory.accountPage().AddressRemoveBttn);
		click(factory.accountPage().AddressRemoveBttn);
		logger.info("Address Remove Bttn clicked successfyllu");
		
	}
	
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() throws InterruptedException {
		waitTillClickable(factory.accountPage().AddAddressIcon);
		Assert.assertEquals(true, (factory.accountPage().AddressRemoveBttn.isDisplayed()));
		logger.info("Adress  removed Successfully");
	}
	
	
}