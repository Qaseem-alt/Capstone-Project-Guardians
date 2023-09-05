@Smoke
Feature: Retail Home Page

Background:
	Given User is on retail website
	When User click on Sign in option
	And User enter email 'Qaseem123@tekSchool.us' and password 'Tek_4321'
	And User click on login button
	Then User should be logged in into Account
	When User click on All section

@AllDepSidebar
Scenario: Verify Shop by Department sidebar
    Then below options are present in Shop by Department sidebar
    |Electronics|Computers|Smart Home|Sports|Automative|

@VerifyEachDepartment
Scenario Outline: Verify department sidebar options
    When User on '<department>'
    Then below options are present in department
    | '<optionOne>' | '<optionTwo>' |
    
    Examples:
    |'department'                |optionOne                                 |optionTwo                |
    |'Electronics'               |TV & Video                                |Video Games              |
    |'Computers'                 |Accessories                               |Networking               |
    |'Smart Home'                |Smart Home Lightning                      |Plugs and Outlets        |
    |'Sports'                    |Athletic Clothing                         |Exercise & Fitness       |
    |'Automotive'                |Automative Parts & Accessories            |MotorCycle & Powersports |
    
    
