Feature:Send and receive real emails in Cucumber


Scenario: Send a test email from sender email and receive it in receiver account 

	Given I login with username "Test@gmail.com" and password "password" in Gmail 
	When I compose a new Email from sender account 
	And I click send button 
	And I Login into receiver email account
	Then I should receive the email with same subject in receiver inbox 
    
