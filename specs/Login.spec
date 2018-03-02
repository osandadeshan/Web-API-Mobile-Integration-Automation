Login Specification
===================
Date Created    : 03/02/2017
Version   		: 1.0.0
Owner      		: Osanda Deshan
Description  	: This is an executable specification file which follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.


tags: login



Launch the web app
------------------
* Launch the web application



Navigate to registration page
-----------------------------
* Navigate to registration page



Resister to the web application
-------------------------------
* Register to the application using the username as "osanda12" and password as "Password1"
* Verify the "osanda12" user has successfully registered



Quit the web app
----------------
* Quit from the web application



Launch the mobile app
---------------------
* Launch the mobile application



Targeted platform information
-----------------------------
* Testing platform information



Verify that the Login page contains the Create Account button
-------------------------------------------------------------
* Verify that the Create Account button is visible



Verify that an invalid user cannot login to the application
-----------------------------------------------------------
* Verify that the Login page title is "Login"
* Verify that a user can login into the application using valid username and password
     |Username       |Password       |
     |---------------|---------------|
     |Osanda         |Password       |
* Verify that the login is fail



Clear username and password textbox contents
--------------------------------------------
* Clear text fields in Login page



Verify that a valid user can login to the application
-----------------------------------------------------
* Verify that a user can login into the application using valid username and password
     |Username       |Password       |
     |---------------|---------------|
     |osanda12       |Password1      |
* Skip the welcome flow
* Tap 'Got It' button
* Verify that the login is success



Verify that a user lands to the Expert Decks page after the login
-----------------------------------------------------------------
* Verify that the user lands to the "Expert Decks" page



Quit the mobile app
-------------------
* Quit from the mobile application