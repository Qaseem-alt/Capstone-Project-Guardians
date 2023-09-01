package tek.cap.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.cap.guardians.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
		// Web Elements for @UpdateProfile
	@FindBy(id = "accountLink")
	public WebElement AcountOptions;
	
	@FindBy(id = "nameInput")
	public WebElement nameInputField;
	
	@FindBy(id = "personalPhoneInput")
	public WebElement phoneInputField;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement ProUpdateBttn;
	
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement ProUpdateSuccessMsg;
	
	// Web Elemetns for @AddPayment
	
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement AddPaymentLink;
	
	@FindBy(id = "cardNumberInput")
	public WebElement CardNumberInputFeild;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement cardNameInputFeild;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement ExpirationMuonthBttn;
	
	@FindBy(id = "expirationYearInput")
	public WebElement ExpirationYearBttn;

	@FindBy(id = "securityCodeInput")
	public WebElement SecurityCodeinputFeild;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement addCardBttn;
	
	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement addCardSuccessMssg;
	
	// This is the web Elements for @UpdatePaymentInfo
	
	
	@FindBy(xpath ="//img[@class='w-full undefined']")
	public WebElement CardIcon;
	
	@FindBy(xpath = "//button[text()='Edit']")
	public WebElement CardEditBttn;
	
	@FindBy(xpath = "//h1[@class='account__payment-new-title']")
	public WebElement UpdateCardWindow;
	
	@FindBy(id ="paymentSubmitBtn")
	public WebElement updateCardBttn;
	
	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement CardUpdateSuccessMssg;
	
	//These are the webElemetn for @RemovePaymentCard
	
	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeCardButtn;
	
	//These are the web element for @AddAddress
	@FindBy(xpath ="//p[ text()='Add Address']")
	public WebElement AddAddressIcon;
	
	@FindBy(xpath = "//h1[ text()='Add A New Address']")
	public WebElement AddAdressWindow;
	
	@FindBy(id = "countryDropdown")
	public WebElement counteryDropdown;
	
	@FindBy(id = "fullNameInput")
	public WebElement fullNameaddAddress;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement phoneNumAddAddress;
	
	@FindBy(id = "streetInput")
	public WebElement streetInputFeild;
	
	@FindBy(id = "apartmentInput")
	public WebElement apartmentInputFeild;
	
	@FindBy(id = "cityInput")
	public WebElement cityInputFeild;
	
	@FindBy(xpath ="//select[@name='state']")
	public WebElement stateDropDown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeInputFeild;
	
	@FindBy(id = "addressBtn")
	public WebElement AddYourAddressBttn;
	
	@FindBy(xpath ="//div[text()='Address Added Successfully']")
	public WebElement AddAddressSuccessMssg;
	
	// These are the web Element for @UpdateAddress
	
	@FindBy(xpath = "//button[@class='account__address-btn' and text()='Edit']")
	public WebElement AddressEditBttn;
	
	@FindBy(id = "addressBtn")
	public WebElement UpdateAdressBttn;
	
	@FindBy(xpath ="//div[text()='Address Updated Successfully']")
	public WebElement UpdateAddressSuccessMssg;
	
	// These are WebElements for @RemoveExistAddress
	@FindBy(xpath ="//button[@class='account__address-btn' and text()='Remove']")
	public WebElement AddressRemoveBttn;
	
	@FindBy(xpath = "//p[text()='United States']")
	public WebElement USTag;
	
	
	
	
	
}
