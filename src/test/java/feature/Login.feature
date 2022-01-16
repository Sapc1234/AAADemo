Feature: Login into Application
Scenario Outline: Positive test validating login
Given Initialize the bowser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And click on login page to land on secure login page
When user enters <username> and <password> and logs in
Then verify that user is Successfully logged in

Examples:
|username                     |password|
|sharanpadashetty637@gmail.com|sapc@258|
|sharanpadashetty637@gmail.com|Sapc@2110|