package tek.cap.guardians.steps;

import tek.cap.guardians.utilities.CommonUtility;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tek.cap.guardians.pages.*;
public class HomeSteps extends CommonUtility {
	
	private POMFactory factory = new POMFactory();
	
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allSectionBttn);
		logger.info("User click on All Section Bttn Successfully");
		
	}
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> SideBarOptions = dataTable.asLists(String.class);
		for(int i = 0; i < SideBarOptions.get(0).size(); i++) {
		Assert.assertTrue(isElementDisplayed(getDriver()
				.findElement(By.xpath("//div[@class='sidebar_content-item']//span[text()='" + SideBarOptions.get(0).get(i)+ "']"))));
				logger.info("Options" + SideBarOptions.get(0).get(i) + "are displayed");
	}
}
	
	@When("User on {string}")
	public void userOn(String department) {
		List<WebElement> Department = factory.homePage().SidebarOptions;
		for(int i = 0; i < Department.size(); i++) {
			if(Department.get(0).getText().equalsIgnoreCase(department)) {
				Department.get(i).click(); 
			}break;
			
		}
		

	}
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> dpartmentsOptions = dataTable.asLists(String.class);
		 List<WebElement> options = factory.homePage().SidebarAllOptions;
		 for(int i = 0; i < dpartmentsOptions.get(0).size(); i++) {
			 for(WebElement elements : options) {
				 if(elements.getText().equalsIgnoreCase(dpartmentsOptions.get(0).get(i)));
				 	Assert.assertTrue(elements.isDisplayed());
				 	logger.info("the Option " + elements.getText() + "are displayed");
					 
				 			}
			 	 		}
			 		 
					}
		 
	

	}
	
	
	
	
	
