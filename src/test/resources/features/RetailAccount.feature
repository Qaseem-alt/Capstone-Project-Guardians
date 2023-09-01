@SmokeAccount
Feature: Retail Account Page

Background: User is sgined in at Retail account
	Given User is on retail website
	When User click on Sign in option
	And User enter email 'Qaseem123@tekSchool.us' and password 'Tek_4321'
	And User click on login button
	Then User should be logged in into Account
	Given user cklick on account Link 
	
	@UpdateProfile 
Scenario: Verify user can update profiele Information
When User User update '<Name>' And '<Phone>' values
And user click on update button 
Then user profile information should be updated
Examples: Name and phone values
|	Name				|			Phone|
|Ahmmad Qaseem|2067106666|
|Qaseem				|2067106500|

@AddPayment
Scenario: Verify User can Edit Debit or Cridit card
When User click on add a paymnet method
And user fill Debit or cridit card information
|cardNumber|nameOnCard|expirationMonth|expirationYear|securityCode|
|1234567891234567|Qaseem|12|2042|852|
And User click on Add your card 
Then A massege Should be displayed 'Payment Method added sucessfully'

@UpdatePaymentInfo
Scenario: Verify User can edit Debit or Criedit card
And User click on edit Option of card section
And User click on Edit option
And Update Debit or Cridit cart window PopUp
And User edit information with below inforation
|cardNumber|nameOnCard|expirationMonth|expirationYear|securityCode|
|1234567891234568|QaseemA|11|2041|258|
And user click on update your card button
Then a message should be displayed 'Payment Method updated Successfully'

 
@RemovePaymentCard
Scenario: Verify User can Remove Debit or Cridit card
When User Slecte the card to remove
And User click on Remove option of the card
Then Payment Details should be removed


	@AddAddress
Scenario: Verify User can add an Address add Address
When User click on Add Address Icon
And User fill the information with below data
|Country			|FullName			 |PhoneNumber|Address|AptUnitOrEtc|City|State			|ZipCode|
|United States|QaseemGuardian|2444455647 |10433	 |fourthFloor |Kent|Washington|98032  |
And User click on Add Your Address button
Then Address Added Successfully Massage popUp

@UpdateAddress
Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And user fill new address form with below information
    |Country			|FullName			 |PhoneNumber|Address|AptUnitOrEtc|City|State			|ZipCode|
    |United States|Qaseem Guardian|2444455256 |10433	 |secondFloor |Kent|Washington|98030  |
    And User click update Your Address button
    Then A massege Should be displayed 'Address Updated Successfully'

@RemoveExistAddress
Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
