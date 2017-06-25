---
layout: post
title: "Test Case Design for Money Management Application"
date: 2017-06-27
---


Welcome to our fifth blog, hope you enjoyed our previous blogs!!. In this blog we will discuss in detail about the test case design for Black box testing and White Box testing  for our application and finally last but not the least about the summary of changes.

## Black Box Testing:

Black box Testing is the testing either functional or nonfunctional without reference to the internal structure of the component or system.

![BlackBoxTesting]({{site.baseurl}}/images/BlackBox_Testing_image.jpg " BlackBoxTesting ")

This method attempts to find the errors in the following categories:

1.Incorrect or missing functions.
2.Interface Errors.
3.Errors in data structures or External database access.
4.Behavior or performance errors.

The following Table shows the five functional requirements which are considered for the Black Box Testing:


Requirement-1:
As a user I want to secure my budget planner with the passcode.

Testcase-1:

Title: Log In Activity: Authentication of the user

Description: A registered user (i.e. after setting a passcode for the application) should be able to successfully login by entering the passcode.

Precondition: User must already had set the passcode

Testing Steps:
1. Open the Money management Application.
2. In “Enter Passcode” field Enter the registered passcode.
3. Click Login Button.



Expected Result:
1. User should be able to login successfully, if the entered passcode matches with the registered passcode.
2. If the Entered passcode does not match with the registered passcode an error message should be shown “wrong password”.

Requirement-2:
I want to add my income transaction by selecting the Date, Category, Payment Type, and with some additional notes (optional).

Testcase-2:

Title: Income Transaction: Addition of new income transaction by the user.

Description: A registered user should be able to successfully add a new income transaction by choosing the date, category, payment method and with additional notes (optional).

Precondition: User has logged in successfully.


Testing Steps:
1. Open the Money management Application.
2. Log in using the passcode.
3. Click on the income icon on the startup screen to navigate to the income activity screen.
4. Select desired Date, Category and payment Type. (Mandatory).
5. Enter the amount.
6. Add additional notes for the transaction if required. (optional).
7. Click  AddIncome Button.

Expected Result:
1. New income transaction should be added successfully to the database.
2. This can be verified by clicking ViewIncome Button.

Requirement-3:
I want to add my expense transaction by selecting the Date, Category, Payment Type, and with some additional notes (optional).

Testcase-3:

Title: Expense Transaction: Addition of new income transaction by the user.

Description: A registered user should be able to successfully add a new expense transaction by choosing the date, category, payment method and with additional notes (optional).

Precondition: User has logged in successfully.


Testing Steps:
1. Open the Money management Application.
2. Log in using the passcode.
3. Click on the expense icon on the startup screen to navigate to the income activity screen.
4. Select desired Date, Category and payment Type. (Mandatory).
5. Enter the amount.
6. Add additional notes for the transaction if required. (optional).
7. Click  AddExpense Button.

Expected Result:
1. New expense transaction should be added successfully to the database.
2. This can be verified by clicking ViewExpense Button.

Requirement-4:
I want to filter my income transaction by selecting the dates, Category and payment type.

Testcase-4:

Title: Filter Transaction: Filter the income based on Date range , category and Payment method.

Description: A registered user should be able to successfully Filter the income based on Date range, category and Payment method.

Precondition: 
1. User has logged in successfully.
2. Income transactions have been added to the database.

Testing Steps:
1. Open the Money management Application.
2. Log in using the passcode.
3. Click on the menu icon on the start up screen.
4. Click on the settings and then Click on the filter Income Button
5. Choose the from date and To date from the calendar pop up to filter based on dates
6. Choose category and payment method on which the user wants to filter the income transaction.
7. Click  Filter Income Button.

Expected Result:
1. Once the Filter Income Button is clicked, the popup should show up displaying the income transactions according to the selected dates and category and payment type.


Requirement-5:
I want to see the overview of Income/Expense Transactions on the start up screen.

Testcase-5:

Title: Transaction Overview
Description: A registered user should be able to see the overview of income and expense transactions on the start up screen on click of a button.

Precondition: 
1. User has logged in successfully.
2. Income transactions have been added to the database.
3.Expense transactions have been added to the data base.

Testing Steps:
1. Open the Money management Application.
2. Log in using the passcode.
3. Click on the Income Overview Button on the startup screen to see the income transactions overview.
4. Click on the Expense Overview Button on the startup screen to see the expense transactions overview.

Expected Result:
1. Once the Income Overview Button is clicked, the popup should show up displaying the income transactions which are successfully added to the database.
2. Once the Expense Overview Button is clicked, the popup should show up displaying the expense transactions which are successfully added to the database.




White Box Testing:

Definition
Write 2 lines about flow chart.
The following Table shows the five functional requirements which are considered for the white Box Testing and the corresponding classes covered.
Add table 

We selected the test cases to achieve maximum code coverage in each functional blocks.
Requirement-1:
Secure Application with Passcode



Testcase-1:

Title: Create Passcode

Testing Steps:
1. Open the Money management Application.
2. In “Enter Passcode” field Enter the passcode.
3. In “Confirm Passcode” field Enter the same passcode again.
4. Click Login Button.

Expected Result:
1. User should be able to login successfully, if the passcode entered in In “Enter Passcode” and “Confirm Passcode” field matches.

Testcase-2:

Title: Confirm Passcode
This test case is added to cover all if else condition statements in CreatePassword

Testing Steps:
1. Open the Money management Application.
2. In “Enter Passcode” field Enter the passcode.
3. In “Confirm Passcode” field Enter the different passcode.
4. Click Login Button.

Expected Result:
1. An error message should be shown saying Passcode Does not match.



Requirement-2:
Login with the Passcode


Testcase-1:

Title: LogIn Activity
Precondition: User had already set the passcode.
Testing Steps:
1. Open the Money management Application.
2. In “Enter Passcode” field Enter the passcode.
3. Click Login Button.

Expected Result:
1. User should be able to login successfully, if the passcode entered in In “Enter Passcode” matches with the passcode registered by the user.

Testcase-2:

Title: Validate Passcode
This test case is added to cover all if else condition statements in EnterPassword Class

Precondition: User had already set the passcode.

Testing Steps:
1. Open the Money management Application.
2. In “Enter Passcode” field Enter the different passcode than the registered passcode.
3. Click Login Button.

Expected Result:
1.	An error message should be shown saying Wrong Passcode.
Requirement-3:
Add new income transaction


Testcase-1:

Title: Income transaction.
Precondition: User has logged in successfully.
Testing Steps:
1. Open the Money management Application.
2.Log in to the app using passcode
3. Click on Income Button on Start screen to navigate to income activity page.
4.Enter amount and select  date , category and payment type.( mandatory)
5. Add additional notes (optional)
6.Click Addincome button

Expected Result:
1. New income transaction should be added successfully to the database.


Testcase-2:

Title: Validate mandatory fields.
This test case is added to cover all if else condition statements in IncomeActivity Class

Precondition: User has logged in successfully.
Testing Steps:
1. Open the Money management Application.
2.Log in to the app using passcode
3. Click on Income Button on Start screen to navigate to income activity page.
4.Enter amount, select  date  and  click on add income button.
5. Enter amount, select  category  and  click on add income button.
6. Enter amount, select  payment type  and  click on add income button.


Expected Result:
1.An Error message should be shown saying “ please select all mandatory fields”.

Requirement-4:
Add new expense transaction


Testcase-1:

Title: Expense transaction.
Precondition: User has logged in successfully.
Testing Steps:
1. Open the Money management Application.
2. Log in to the app using passcode
3. Click on Expense Button on Start screen to navigate to expense activity page.
4. Enter amount and select  Date , category and payment type.( mandatory)
5. Add additional notes (optional)
6. Click  Add Expense button

Expected Result:
1. New Expense transaction should be added successfully to the database.


Testcase-2:

Title: Validate mandatory fields.
This test case is added to cover all if else condition statements in ExpenseActivity Class

Precondition: User has logged in successfully.
Testing Steps:
1. Open the Money management Application.
2. Log in to the app using passcode
3. Click on Expense Button on Start screen to navigate to expense activity page.
4. Enter amount, select  date  and  click on addExpense button.
5. Enter amount, select  category  and  click on addExpense button.
6. Enter amount, select  payment type  and  click on addExpense button.


Expected Result:
1.An Error message should be shown saying “ please select all mandatory fields”.

Requirement-5:
Filter Income Transactions.


Testcase-1:

Title: Filter transactions.
Precondition:
1. User has logged in successfully.
2. Atleast one income transaction is added to the database.

Testing Steps:
1. Open the Money management Application.
2. Log in to the app using passcode
3. Click on Menu button on start screen and select settings.
4. Click on “Income Filter” button to navigate to income filter page.
5. select from Date and To date form the calendar popup
6. select payment Type and category.
7. Click “Filter Income” button .

Expected Result:

1. Income transactions should be displayed according to the selected date range, category and payment type.


Testcase-2:

Title: Filter transactions.
Precondition:
1. User has logged in successfully.
2. Atleast one income transaction is added to the database.


Testing Steps:
1. Open the Money management Application.
2. Log in to the app using passcode
3. Click on Menu button on start screen and select settings.
4. Click on “Income Filter” button to navigate to income filter page.
5. select from Date and To date form the calendar popup and Click “Filter Income” button.
6. select payment Type  and Click “Filter Income” button.
7. select Category  and Click “Filter Income” button.


Expected Result:

1. For all the above cases Income transactions should be displayed according to the selected date range, category and payment type.


