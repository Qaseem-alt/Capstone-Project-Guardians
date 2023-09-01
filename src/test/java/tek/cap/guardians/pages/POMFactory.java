package tek.cap.guardians.pages;

import tek.cap.guardians.base.BaseSetup;

public class POMFactory extends BaseSetup{
	
		private RetailHomePage homePage;
		private RetailSignInPage signInPage;
		private RetailAccountPage accountPage;
		private RetailOrderPage orderPage;
		
		
		
		
		
		public POMFactory() {
			this.homePage = new RetailHomePage();
			this.signInPage = new RetailSignInPage();
			this.accountPage = new RetailAccountPage();
			this.orderPage = new RetailOrderPage();
			
			
		}
		
		public RetailHomePage homePage() {
			return this.homePage;
			
		}
		public RetailSignInPage signInPage() {
			return this.signInPage;
			
		}
		public RetailAccountPage accountPage() {
			return this.accountPage;
		}
		public RetailOrderPage orderPage() {
			return this.orderPage;
		}
	}
	
	//The above Step will repeat for each page of the Application UI.
//For example, if we have RetailLoginPage class we need to repeat the same steps for that class too.  


