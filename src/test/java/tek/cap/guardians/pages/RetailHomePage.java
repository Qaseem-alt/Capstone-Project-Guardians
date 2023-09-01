package tek.cap.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.cap.guardians.base.BaseSetup;

public class RetailHomePage extends BaseSetup {
	
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
		
		
	}
	
	//@FindBy(locatorType= "Locator Value") accessModifier WebElement ElementName;
	//@FindBy(id = "signinbtn")
	//public WebElement singinBttn;

		@FindBy(id = "hamburgerBtn")
		public WebElement allSectionBttn;
		
		@FindBy(xpath ="//div[@class='sidebar_content-item']//span")
		public List<WebElement> SidebarOptions;
		
		@FindBy(xpath ="//div[@class='sidebar_content-item']//span")
		public List<WebElement> SidebarAllOptions;
			
}
