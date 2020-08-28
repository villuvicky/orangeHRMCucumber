Feature: Orange HRM User details

@Login
Scenario: User Login
    Given User is on OrangeHRM Login Page
    When User enters username and password
    Then User is logged in to Home Page

@AddEmployee
   Scenario: Add User on HRM
   When User Navigates to PIM Employee list
   Then User can see Add Employee page
   Then User enters all details 
   Then user clicks on save button
   Then user gets success message
   

        @AdminLogout
 Scenario: Admin Logout
    When user clicks on logout button
    Then User is logged out
   