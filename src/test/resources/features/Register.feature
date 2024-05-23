Feature: Register functionality

Scenario: User creates an account only with madatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|Govind|
|lastName|Gupta|
|telephone|9876543211|
|password|9876543211|
And User selects privacy button
And User clicks on Continue button
Then User account should be created successfully


Scenario: User creates an account only with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|Govind|
|lastName|Gupta|
|telephone|9876543211|
|password|9876543211|
And User selects Yes for Newsletterm
And User selects privacy button
And User clicks on Continue button
Then User account should be created successfully


Scenario: User creates a duplicate account
Given User navigates to Register Account page
When User enters the details into below fields with duplicate email 
|firstName|Govind|
|lastName|Gupta|
|email|govindgupta2209@gmail.com|
|telephone|9876543211|
|password|9876543211|
And User selects Yes for Newsletterm
And User selects privacy button
And User clicks on Continue button
Then User should get a proper warning about duplicate email



Scenario: User creates an account without filling an details
Given User navigates to Register Account page
When User dont enters any details into fields
And User clicks on Continue button
Then User should get proper warning messages for every mandatory field

