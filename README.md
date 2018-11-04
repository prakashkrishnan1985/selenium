# selenium
Created on a website called https://wallethub.com/profile/test_insurance_company/ and Facebook.com

The scenarios are as follows:

Test #1:

1. Login to Facebook. Username and Password should be on a variable
2. Post a random status message

Test #2:
Create a light user account in https://wallethub.com/join/light while unchecking the checkbox to get your free credit score and report. This is the account you should be using for this test. Then simulate the following actions:
1. Go to this URL: http://wallethub.com/profile/test_insurance_company/
2. On the right part of the page, hover over the stars and click on the fourth star and :
  (1) do the hover 
  (2) make sure the stars inside get lit up when you hover over them, then 
  (3) click on the fifth star
3. On the page you get redirected to, click on the Policy dropdown and change the value to “Health”
4. Click on the link “Write a review” and write some random text (minimum of 200 characters) (Used Faker to generate random text here)
5. Press submit.
6. If you are successful you should see a confirmation screen saying you have reviewed the institution. You then have to go to your profile and confirm that a “review feed” got posted there.
7. Go to https://wallethub.com/profile/<username>/reviews/ and assertTrue() that you can see the review feed with the text you entered on the previous page.

Miscelleneous Information:

Build tool: Maven
Framework: TestNG
Patterns used: Page Factory
Source Of Data: Json files located in src/main/resources
Environment Details: Property Files located at src/main/resources
Triggering the tests:
  1. Using eclipse: Trigger the testNG files: FacebookTestNG.xml and WalletHubTestNG.xml
  2. Command Line: Use the command "mvn clean install -Dtestng.xml=FacebookTestNG.xml" OR "mvn clean install -Dtestng.xml=WalletHubTestNG.xml"


