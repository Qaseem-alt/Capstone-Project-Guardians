@Regression
Feature: Retail Order Page

Background: User is on retail website home page
	Given User is on retail website
	When User click on Sign in option
	And User enter email 'Qaseem123@tekSchool.us' and password 'Tek_4321'
	And User click on login button
	Then User should be logged in into Account

	@AddingItemToCart
	Scenario: Verify User can add an item to cart
		And User change the category to 'Smart Home'
    And User search for an item 'Kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'
    And User click on cart options
    Then User cleck on delete button
	
	
	@PlaceOrder
	Scenario: Verify User can place an order with Shipping address and payment Method on file
		And User change the category to 'Electronics' catagory
		And User search for an item Name 'Apex Legends' 
    And User click on Search icon
    And User click on item Apex Legend
    And User select quantity '5' Qty
    And User click add to Cart button
    Then the cart icon quantity should change to '5' Qty
    And User click on cart options
  	And User click on Proceed to Checkout button
  	And User click on Add Cridit or Debit Card button
    And user fill Debit or cridit card information
		|cardNumber						|nameOnCard |expirationMonth|expirationYear|securityCode|
		|1234567891234555|Qaseem|12|2042|852|
		And User click on Add your card button 
    And User click on Add a new Address
		And User fill the information with below data
		|Country			|FullName			 |PhoneNumber|Address|AptUnitOrEtc|City|State			|ZipCode|
		|United States|QaseemGuardian|2444455647 |10433	 |fourthFloor |Kent|Washington|98032  |
		And User click on Add Your Address button
    And User click on Place Your Order
    Then a message should be displayed 'Order Placed, Thanks' at the end
    
    @CancelanOrder
    Scenario: Verify User can Cancel the Order 
    And User click on Orders section
    And User click on first order in list
    And User click on Cancel The Order button
    And User select the cancelation Reason 'Bought wrong item'
    And User click on Cancel Order button
    Then a cancelation message should be displayed 'Your Order Has Been Cancelled'
    
    
    @ReturnIteam
    Scenario: Verif User can Return The Order
		And User click on Orders section
		And User click on first order in list
		And User click on Buy again
		And User click on Place Your Order
		And User click on Orders section Again
    And User click on first order in list
    And User click on Return Items button
    And User select the Return Reason 'Item damaged'
    And User select the drop off service 'FedEx'
    And User click on Return Order button
    Then a cancelation message should be displayed 'Return was successfull' Mssg

    
    
    @AddReview
		Scenario: Verify User can Write a review on orderplaced
    And User click on Orders section
    And User click on first order in list
    And User click on Review button
    And User write Review headline 'Last test'
    And 'capiston compleated'
    And User click Add your Review button
    Then a review message should be displayed 'Your review was added successfully'
    
    

	@CleanUp
	Scenario: User clean Card and address
	Given user cklick on account Link 
	When User Slecte the card to remove
	And User click on Remove option of the card
	Then Payment Details should be removed
	And User refresh the pageA
	And User click on remove option of Address section
  And User refresh the pageb
  Then User click on Orders section
    
    
    
    
