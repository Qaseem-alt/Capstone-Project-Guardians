@SmokeSignIn
Feature: Sign in Feature
​
Background: Retail Website Sign in
	Given User is on retail website
	When User click on Sign in option

@SignIn
Scenario: Verify user can sign in into Retail Application
	And User enter email 'Qaseem123@tekSchool.us' and password 'Tek_4321'
	And User click on login button
	Then User should be logged in into Account

@CreatAccout
Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data and '<name>' and '<email>' and '<password>' and '<confirmPassword>'
    And User click on SignUp button
		Then User should be logged into account page
		
		Examples: 
    | name | email | password | confirmPassword |
    | student| Qaseem12 | Tek_4321 | Tek_4321 |
    
    
    