package tek.cap.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.cap.guardians.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	//These are the WebElements for @AddingItemToCart
	@FindBy(id = "search")
	public WebElement searchBarDepartmentsBttn;
	
	@FindBy(xpath = "//option[@class='search__select-option']")
	public WebElement DepartmentOptions;

	@FindBy(id ="searchInput")
	public WebElement itemSerchInputFeild;
	
	@FindBy(id = "searchBtn")
	public WebElement searchBttn;
	
	@FindBy(xpath = "//p[text()='Kasa Outdoor Smart Plug']")
	public WebElement KasaOutdoorIcon;
	
	@FindBy(xpath = "//select[@class='product__select']")
	public WebElement QtySelectBttn;
	
	@FindBy(id = "addToCartBtn")
	public WebElement AddToCartBttn;
	
	@FindBy(id = "cartQuantity")
	public WebElement itemQtyInCart;
	
	@FindBy(xpath = "//p[text()='Cart ']")
	public WebElement cartIcon;
	
	@FindBy(xpath = "//span[@class='cart__item-delete']")
	public WebElement KasaDeleteBttn;  
	
	@FindBy(id ="totalPrice")
	public WebElement TotalPrice; 
	
	@FindBy(xpath = "//p[text()='Apex Legends - 1,000 Apex Coins']")
	public WebElement ApexlegendsIcon;  
	
	@FindBy(id = "proceedBtn")
	public WebElement ProceedToCheckoutBttn;
	
	@FindBy(id = "addAddressBtn")
	public WebElement AddNewAdressBttnPYO;
	
	@FindBy(id = "addPaymentBtn")
	public WebElement AddPaymentBttnPYO;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement PlaceYourOderBttn;
	
	@FindBy(xpath = "//p[text()='Order Placed, Thanks']")
	public WebElement ThanksMssg;
	
	// these are the webElement for @CancelanOrder
	
	@FindBy(id = "orderLink")
	public WebElement OrdersBttn;
	
	@FindBy(xpath = "//p[@class='order__header-btn' and text()='Show Details']")
	public WebElement OrderDetailsBttn;
	
	@FindBy(id = "cancelBtn")
	public List<WebElement> CancelTheOrderBttn;
	
	@FindBy(id = "reasonInput")
	public WebElement CancelationReason;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement CancelOrderSubmitBttn;
	
	@FindBy(xpath ="//p[text()='Your Order Has Been Cancelled']")
	public WebElement CancelationSuccessMssg;
	
	@FindBy(id = "buyAgainBtn")
	public List<WebElement> BuyAgainbttn;
	
	@FindBy(id = "returnBtn")
	public List<WebElement> ReturnItemBttn;
	
	@FindBy(id ="reasonInput")
	public WebElement ReturnReason;
	
	@FindBy(id = "dropOffInput")
	public WebElement DropOffPlace;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement RetrunOrderBttn;
	
	@FindBy(xpath = "//p[text()='Return was successfull']")
	public WebElement ReturnSuccessMssg;
	@FindBy(xpath ="//a[@class='top-nav__logo' and text()='TEKSCHOOL']")
	public WebElement UIHomePage;
	
	@FindBy(id ="orderLink")
	public WebElement OrdersBttnAgain;
	
	// these are the Web Element for @AddReview
	
	@FindBy(id = "reviewBtn")
	public List<WebElement> ReviewButton;
	
	@FindBy(id ="headlineInput")
	public WebElement RevHeadlineInputFe;
	
	@FindBy(id = "descriptionInput")
	public WebElement RevBodyInputFeild;
	
	@FindBy(id = "reviewSubmitBtn")
	public WebElement ReviewSubmitBttn;
	
	@FindBy(xpath = "//div[text()='Your review was added successfully']")
	public WebElement ReviewAddedSuccessMssg;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
