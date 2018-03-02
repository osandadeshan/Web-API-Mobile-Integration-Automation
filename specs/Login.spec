Login Specification
===================
Date Created    : 03/02/2017
Version   		: 1.0.0
Owner      		: Osanda Deshan
Description  	: This is an executable specification file which follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.


tags: web_registration, mobile_login



Register a user to the web application
--------------------------------------
* Launch the web application
* Navigate to registration page
* Register to the application using the username as "osanda12" and password as "Password1"
* Verify the "osanda12" user has successfully registered
* Quit from the web application



Login to the mobile appplication using the above registered user
----------------------------------------------------------------
* Launch the mobile application
* Verify that the Login page title is "Login"
* Verify that a user can login into the application using valid username and password
     |Username       |Password       |
     |---------------|---------------|
     |osanda12       |Password1      |
* Skip the welcome flow
* Tap 'Got It' button
* Verify that the login is success
* Quit from the mobile application