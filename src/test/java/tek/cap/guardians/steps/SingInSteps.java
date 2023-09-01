package tek.cap.guardians.steps;
import	tek.cap.guardians.pages.POMFactory;
import tek.cap.guardians.utilities.CommonUtility;
import tek.cap.guardians.utilities.DataGenerator;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingInSteps extends CommonUtility{
	
	POMFactory factory = new POMFactory();
	
	// bellow steps are for Sign in scenario
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		Assert.assertTrue(factory.signInPage().tekLogo.isDisplayed()); 
		logger.info("tek Log is displayed");
	}
	
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.signInPage().signInLink);
		logger.info("signIn bttn was clicked successfully");
	}
	
	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String username, String password) {
		sendText(factory.signInPage().emailField, username);
		sendText(factory.signInPage().passwordField, password);
		logger.info("email and password enterd successfully");
	}
	
	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.signInPage().loginBttn);
		logger.info("user clicked on login Bttn Successfully");
	}
	
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		String pageTitle = getDriver().getTitle();
		String Expected = "React App";
		Assert.assertEquals(Expected, pageTitle);
		logger.info("User logged in successfully");
	
	}
	
	// bellow steps are for Creat Accout scenario
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().newAccoutBttn);
		logger.info("User clicked of create New Account Successfully");
	}

	@When("User fill the signUp information with below data and {string} and {string} and {string} and {string}")
	public void userFillTheSignUpInformationWithBelowDataAndAndAndAnd(String name, String email, String password, 
			String confirmPassword) {
		sendText(factory.signInPage().nameInputFeild, name + DataGenerator.generateRandomAlphabet());
		sendText(factory.signInPage().emailInputFeild, email+ DataGenerator.randomInt()+"@tekSchool.us");
		sendText(factory.signInPage().passwordInputFeild, password);
		sendText(factory.signInPage().confirimPassInputFeild, confirmPassword);
		logger.info("Data Enterd Successfully");
		
	}
	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.signInPage().signupBttn);
		logger.info("User clicked on Sing up Bttn successfully");
	}
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(factory.signInPage().profileText.isDisplayed());;
		logger.info("User successfully logged in");
	}
	
	
}
