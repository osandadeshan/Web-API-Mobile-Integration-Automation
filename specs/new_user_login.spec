New User Login Specification
============================
Date Created    : 03/02/2017
Version   		: 1.0.0
Owner      		: Osanda Deshan
Description  	: This is an executable specification file which follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.


tags: web_registration, api_validation, mobile_login



Register a user to the web application
--------------------------------------
* Launch the web application
* Navigate to registration page
* Web page title is "Pearson Create Account"
* Save the strings inside data stores
    |DataStore Type |Variable Name  |Value To Be Stored     |
    |---------------|---------------|-----------------------|
    |Specification  |username       |pearsonqe16            |
    |Specification  |password       |Password1              |
* Register to the application using the following details stored in data stores
    |Email Address              |Confirm Email Address      |DataStore Type |Username Variable Name In DataStore |Password Variable Name In DataStore |First Name     |Last Name      |User Role  |
    |---------------------------|---------------------------|---------------|------------------------------------|------------------------------------|---------------|---------------|-----------|
    |pearsonqe16@pearson.com    |pearsonqe16@pearson.com    |Specification  |username                            |password                            |Pearson        |Tester         |Student    |
* Message appears after the registration is "Account created"
* Quit from the web application



Validate above registered user from backend
-------------------------------------------
* Set request payload using data stores for PI authentication API
    |Attribute Name |DataStore Type |Attribute Variable Name In DataStore    |
    |---------------|---------------|----------------------------------------|
    |userName       |Specification  |username                                |
    |password       |Specification  |password                                |
* Invoke PI authentication API
* Status code for PI authentication API is "201"
* JSON Path Assertions for the PI authentication API
    |JSON Path      |JSON Path Value    |
    |---------------|-------------------|
    |status         |success            |



Login to the mobile application using the above registered user
---------------------------------------------------------------
* Launch the mobile application
* Login page title is "Login"
* Login into the application using valid username and password stored in data stores
     |DataStore Type |Username Variable Name In DataStore |Password Variable Name In DataStore |
     |---------------|------------------------------------|------------------------------------|
     |Specification  |username                            |password                            |
* Skip the welcome flow
* Tap 'Got It' button
* Page title is "Expert Decks"
* Quit from the mobile application