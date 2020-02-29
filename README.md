This file describes the phpTravelsTest automation suite written using Selenium tool with Java as the programming language and TestNG as the framework
The framework follows Page Object Model and uses data driven approach.


"src" folder includes
- "pages" package - has objects for the pages needed for the tests (following POM model)
- "reusable" package - has modules that are reused (hides logic details from user who would create test scripts)
- "test" package - has actual tests with 4 files for each of the 4 use cases (LoginTest, SubscriptionTest, FlightSearch, FeaturedTours)
- "utilities" packages - has constants

"utilities" folder includes files that are needed
- chromedriver.exe - for running in chrome browser
- loginCredentials.xlsx - login credentials for LoginTest

testng.xml
- has the tests that are to be run

Notes:
1) Test case 4 could not be covered as "Featured tour" is not available.
https://www.phptravels.net/tours/egypt/alexandria/Spectaculars-Of-The-Nile-3-Nights?date=27/01/2020&adults=2 gives: 
404
Oops!! Page not found

Though test 1 to 3 should highlight data parameterization, modularization, execution in parallel, POM model, coding standards,...

2) Test case 1
Uses loginCredentials.xlsx for login credentials. Since newly created users are not present after sometime, used user@phptravels.com/demouser to demonstrate Dataproviders for all users

3) FlightSearchTests
Flight search assumes a specific output on filter. But this keeps changing. Hence the count may not match during actual run

Steps to run the test:
1) Pls downloaded external libraries and add to the project
- Selenium Java client jars
- Apache POI jars
- xmlbeans
- TestNG jars

2) Build the project

3) On any IDE where the project is loaded, right click on testng.xml and run all the tests