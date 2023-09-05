package tek.cap.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.cap.guardians.pages.POMFactory;
import tek.cap.guardians.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	
	// These are steps for @AddingItemToCart
	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String ExpectedDepartment) {

		selectByVisibleText(factory.orderPage().searchBarDepartmentsBttn, ExpectedDepartment);
//		Assert.assertEquals(ExpectedDepartment,factory.orderPage().searchBarDepartmentsBttn.getText());
		logger.info("User select the" + ExpectedDepartment + "Department Successfully");
	}
	@When("User search for an item {string}")
	public void userSearchForAnItem(String itemName) {
		sendText(factory.orderPage().itemSerchInputFeild, itemName);
		logger.info("Iteam Name Enterd in serchbar Successfylly");
	}
	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.orderPage().searchBttn);
		logger.info("User Clicked on Search Button Successfully");
	}
	@When("User click on item")
	public void userClickOnItem() {
		waitTillClickable(factory.orderPage().KasaOutdoorIcon);
		click(factory.orderPage().KasaOutdoorIcon);
		logger.info("User select the Iteam Successfully");
	}
	@When("User select quantity {string}")
	public void userSelectQuantity(String ExpectedQTY) {
		click(factory.orderPage().QtySelectBttn);
		selectByVisibleText(factory.orderPage().QtySelectBttn,ExpectedQTY);
		logger.info("User selected the Quantity Secessfully");
	}
	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.orderPage().AddToCartBttn);
		logger.info("User clicked on Add To Cart Button Successfully");
	}
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String ExpItemsInCart) {
		waitTillClickable(factory.orderPage().itemQtyInCart);
		Assert.assertEquals(ExpItemsInCart, factory.orderPage().itemQtyInCart.getText());
		logger.info("Iteam added to the cart Successfully");
 	}
	@Then("User click on cart options")
	public void userClickOnCartOptions() {
		click(factory.orderPage().cartIcon);
	}
	@Then("User cleck on delete button")
	public void userCleckOnDeleteButton() {
		waitTillClickable(factory.orderPage().KasaDeleteBttn);
		click(factory.orderPage().KasaDeleteBttn);
		waitTillPresence(factory.orderPage().TotalPrice);
		getDriver().navigate().refresh();
		waitTillPresence(factory.orderPage().TotalPrice);
		Assert.assertEquals("$NaN", factory.orderPage().TotalPrice.getText());
		
	}
	
	
	
	//THese are steps for @PlaceOrder
	@Then("User change the category to {string} catagory")
	public void userChangeTheCategoryToCatagory(String Catagory) {
		waitTillPresence(factory.orderPage().searchBarDepartmentsBttn);
		selectByVisibleText(factory.orderPage().searchBarDepartmentsBttn, Catagory);
		logger.info("User Clicked on Department Options Successfully");
		
	}
	@Then("User search for an item Name {string}")
	public void userSearchForAnItemName(String ItemApex) {
		sendText(factory.orderPage().itemSerchInputFeild, ItemApex);
		logger.info("User Enterd the Iteam Name Successfully");
	}
	@Then("User click on item Apex Legend")
	public void userClickOnItemApexLegend() {
		click(factory.orderPage().ApexlegendsIcon);
		logger.info("User clicked on Apex Legends Icon Successfully");
	}
	@Then("User select quantity {string} Qty")
	public void userSelectQuantityQty(String ExpQty) {
		waitTillClickable(factory.orderPage().QtySelectBttn);
		selectByVisibleText(factory.orderPage().QtySelectBttn, ExpQty);
		logger.info("User Select the Quantity Successfully");
	}
	@Then("the cart icon quantity should change to {string} Qty")
	public void theCartIconQuantityShouldChangeToQty(String ExpTotalQty) {
		waitTillPresence(factory.orderPage().itemQtyInCart);
		Assert.assertEquals(ExpTotalQty, factory.orderPage().itemQtyInCart.getText());
		logger.info("Iteam Added to the cart successfully");
		
	}
	/*@Then("User click on Cart options")
	public void userClickOnCartOptions() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	*/
	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		 click(factory.orderPage().ProceedToCheckoutBttn);
		 logger.info("User clicked on Proced to check out button Successfully");
	}
	@Then("User click on Add Cridit or Debit Card button")
	public void userClickOnAddCriditOrDebitCardButton() {
		waitTillClickable(factory.orderPage().AddPaymentBttnPYO);
		click(factory.orderPage().AddPaymentBttnPYO);
		logger.info("User added a new Payment");
	}
	@Then("user fill Debit or cridit card information")
	public void userFillDebitOrCriditCardInformation(DataTable cardInfo) {
		List<Map<String, String>> cardData = cardInfo.asMaps(String.class,String.class);
		sendText(factory.accountPage().CardNumberInputFeild, cardData.get(0).get("cardNumber"));
		sendText(factory.accountPage().cardNameInputFeild, cardData.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().ExpirationMuonthBttn, cardData.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().ExpirationYearBttn, cardData.get(0).get("expirationYear"));
		sendText(factory.accountPage().SecurityCodeinputFeild, cardData.get(0).get("securityCode"));
		logger.info("Card Information entered successfully");
			}
	
	
	@Then("User click on Add a new Address")
	public void userClickOnAddANewAddress() {
		refresh();
		waitTillPresence(factory.orderPage().AddNewAdressBttnPYO);
		waitTillClickable(factory.orderPage().AddNewAdressBttnPYO);
		click(factory.orderPage().AddNewAdressBttnPYO);
		logger.info("User added a new address");
	}

	
	
	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		waitTillClickable(factory.orderPage().PlaceYourOderBttn);
		click(factory.orderPage().PlaceYourOderBttn);
		logger.info("User clicked on Place your order successfully");
		
	}
	@Then("a message should be displayed {string} at the end")
	public void aMessageShouldBeDisplayedAtTheEnd(String ThanksMssg) {
		waitTillPresence(factory.orderPage().ThanksMssg);
		Assert.assertEquals(ThanksMssg,factory.orderPage().ThanksMssg.getText());
		logger.info("Order placed Successfully");
		
	}
	
	//These are the steps for @CancelanOrder
	
	@Then("User click on Orders section")
	public void userClickOnOrdersSection() {
		waitTillClickable(factory.orderPage().OrdersBttn);
		click(factory.orderPage().OrdersBttn);
		logger.info("User Clicked on Orders Link Successfully");
	}
	
	@Then("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		waitTillClickable(factory.orderPage().OrderDetailsBttn);
		click(factory.orderPage().OrderDetailsBttn);
		logger.info("User clicked on First Order detail");
		
	}
	
	@Then("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		List<WebElement> CancelBttns = factory.orderPage().CancelTheOrderBttn;
		click(CancelBttns.get(0));
		logger.info("User clicked on cancel the order button");
		
	}
	
	@Then("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String cancelationReason) {  
	waitTillClickable(factory.orderPage().CancelationReason);
	selectByVisibleText(factory.orderPage().CancelationReason, cancelationReason);
	logger.info("User Selected the cancelation resaon successfully");
	
	}
	
	@Then("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orderPage().CancelOrderSubmitBttn);
		logger.info("User clicked on Cancel order submit button");
	}
	
	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String CancelationMssg) {
		waitTillPresence(factory.orderPage().CancelationSuccessMssg);
		Assert.assertEquals(CancelationMssg, factory.orderPage().CancelationSuccessMssg.getText());
		logger.info("Order Canceled Successfully");
	}
	
	// These are the steps for @ReturnItem
	
	@Then("User click on Buy again")
	public void userClickOnBuyAgain() {
		List<WebElement> BuyAgainBttn = factory.orderPage().BuyAgainbttn;
		click(BuyAgainBttn.get(0));
		logger.info("An Iteam Added to the Cart");
	
		
	}
	@Then("User click on Orders section Again")
	public void userClickOnOrdersSectionAgain() {
		click(factory.orderPage().UIHomePage);
		waitTillClickable(factory.orderPage().OrdersBttnAgain);
		click(factory.orderPage().OrdersBttnAgain);
		logger.info("User clicked on ordersbutton Aggain");
	}
	    
	@Then("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		List<WebElement> ReturnBttn = factory.orderPage().ReturnItemBttn;
		click(ReturnBttn.get(0));
	}
	@Then("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String ReturnReason) {
		selectByVisibleText(factory.orderPage().ReturnReason, ReturnReason);
		logger.info("User selected on Return reson Successfully");
		
	}
	@Then("User select the drop off service {string}")
	public void userSelectTheDropOffService(String DropOffPlace) {
		selectByVisibleText(factory.orderPage().DropOffPlace, DropOffPlace);
		logger.info("User selected the Drop Off Service Successfully");
	}
	@Then("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.orderPage().RetrunOrderBttn);
		logger.info("User click on return order button successfully");
	}
	@Then("a cancelation message should be displayed {string} Mssg")
	public void aCancelationMessageShouldBeDisplayedMssg(String returnSuccessMSSG) {
		waitTillPresence(factory.orderPage().ReturnSuccessMssg);
		Assert.assertEquals(returnSuccessMSSG, factory.orderPage().ReturnSuccessMssg.getText());
		logger.info("Item returned Successfully");
	}

	// These are the steps for @AddReview
	
	@Then("User click on Review button")
	public void userClickOnReviewButton() {
		List<WebElement> ReviewBttn = factory.orderPage().ReviewButton;
		click(ReviewBttn.get(0));
		logger.info("User Clicked on review Button Successfully");
	}
	@Then("User write Review headline {string}")
	public void userWriteReviewHeadline(String headLineMssg) {
		waitTillPresence(factory.orderPage().RevHeadlineInputFe);
		sendText(factory.orderPage().RevHeadlineInputFe, headLineMssg);
		logger.info("User Enterd the Review HeadLine Successfully");
	}
	@Then("{string}")
	public void string(String BodyMssg) {
		waitTillPresence(factory.orderPage().RevBodyInputFeild);
		sendText(factory.orderPage().RevBodyInputFeild, BodyMssg);
		logger.info("User Enterd the Review Body Text Successfully");
	}
	@Then("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.orderPage().ReviewSubmitBttn);
		logger.info("User clicked on Review submitt button Successfully");
	}
	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String RSuccessMssg) {
		waitTillPresence(factory.orderPage().ReviewAddedSuccessMssg);
		Assert.assertEquals(RSuccessMssg, factory.orderPage().ReviewAddedSuccessMssg.getText());
		logger.info("Review Added Successfully");
	}
	@Then("User refresh the pageA")
	public void userRefreshThePageA() {
	    refresh();
	    logger.info("User refreshed the page");
	}
	@Then("User refresh the pageb")
	public void userRefreshThePageb() {
	    refresh();
	    logger.info("User refreshed the page");
	}

	
}






