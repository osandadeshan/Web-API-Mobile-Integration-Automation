New User Login Specification
============================
Date Created    : 03/02/2017
Version   		: 1.0.0
Owner      		: Osanda Deshan
Description  	: This is an executable specification file which follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.


tags: web_registration, mobile_login



Register a user to the web application
--------------------------------------
* Launch the web application
* Navigate to registration page
* Save the strings inside data stores
    |DataStore Type |Variable Name  |Value To Be Stored     |
    |---------------|---------------|-----------------------|
    |Specification  |username       |pearsonqe5             |
    |Specification  |password       |Password1              |
* Register to the application using the following details stored in data stores
    |Email Address              |Confirm Email Address      |Username Variable Name In DataStore |Password Variable Name In DataStore |First Name     |Last Name      |User Role  |
    |---------------------------|---------------------------|------------------------------------|------------------------------------|---------------|---------------|-----------|
    |pearsonqe5@pearson.com     |pearsonqe5@pearson.com     |username                            |password                            |Pearson        |Tester         |Student    |
* Verify that the user has successfully registered
* Quit from the web application



Login to the mobile application using the above registered user
---------------------------------------------------------------
* Launch the mobile application
* Verify that the Login page title is "Login"
* Verify that a user can login into the application using valid username and password stored in data stores
     |Username Variable Name In DataStore |Password Variable Name In DataStore |
     |------------------------------------|------------------------------------|
     |username                            |password                            |
* Skip the welcome flow
* Tap 'Got It' button
* Verify that the login is success
* Quit from the mobile application