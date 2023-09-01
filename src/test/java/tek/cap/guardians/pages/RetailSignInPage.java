package tek.cap.guardians.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.cap.guardians.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {

	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);

	}
	
// elements for Sign in scenario	
	@FindBy(css = "a.top-nav__logo.active[aria-current='page']")
	public WebElement tekLogo;
	
	@FindBy(id = "signinLink") 
	public WebElement signInLink;
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "loginBtn")
	public WebElement loginBttn;
	
// elemetns for Creat accoutn scenario
	
	@FindBy(id = "newAccountBtn")
	public WebElement newAccoutBttn;
	
	@FindBy(id = "nameInput")
	public WebElement nameInputFeild;
	
	@FindBy(id = "emailInput")
	public WebElement emailInputFeild;
	
	@FindBy(id = "passwordInput")
	public WebElement passwordInputFeild;
	
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirimPassInputFeild;
	
	@FindBy(id = "signupBtn")
	public WebElement signupBttn;
	
	@FindBy(xpath = "//h1[@class='account__personal-title']")
	public WebElement profileText;
	
	
	
}
