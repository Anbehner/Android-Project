---
layout: post
title: "System Design"
date: 2017-05-29
---

Hello Everyone!
Welcome to our third blog, hope you enjoyed our second blog!!.    Over the past few weeks we have been working out on our project with respect to the System Design. With respect to all the user stories which we have mentioned in our previous blog, we have come up with the following Interaction Diagrams and Class Diagrams which would help you all understand our project in a better way. We Shall be discussing about the Development strategies as well.

## Interaction Diagrams

The purpose of the Interaction Diagram is 

* To capture the dynamic behaviour of the system

* To describe the message flow in the system

* To describe the structural organization of the objects 

* To describe the interaction among objects

Keeping all the above points into consideration, we have come up with the below Sequence Diagrams for two of the user stories.

**Sequence Interaction Diagram for Login Activity**

![InteractionDiagram1]({{site.baseurl}}/images/Interaction_Diagram_for_Login_Activity-1.png "InteractionDiagram1"){:height="768px" width="1024px"}


**Sequence Interaction Diagram for Income Transaction**

![InteractionDiagram2]({{site.baseurl}}/images/InteractionDiagram_for_Income_transaction-1.png "InteractionDiagram2"){:height="768px" width="1024px"}


**Class Diagram**
![ClassDiagram]({{site.baseurl}}/images/ClassDiagram.png "ClassDiagram"){:height="768px" width="1024px"}


## MainActivity - Attributes
![MainActivity-Attributes]({{site.baseurl}}/images/Main_Activity-Attributes.png "MainActivity-Attributes")


## MainActivity - Methods
![MainActivity-Methods]({{site.baseurl}}/images/Main_Activity-Methods.png "MainActivity-Methods")


## IncomeActivity - Attributes
![IncomeActivity-Attributes]({{site.baseurl}}/images/Income_Activity-Attributes.png "IncomeActivity-Attributes")


## IncomeActivity - Methods
![IncomeActivity-Methods]({{site.baseurl}}/images/Income_Activity-Methods.png "IncomeActivity-Methods")


## ExpenseActivity - Attributes
![ExpenseActivity-Attributes]({{site.baseurl}}/images/Expense_Activity-Attributes.png "ExpenseActivity-Attributes")


## ExpenseActivity - Methods
![ExpenseActivity-Methods]({{site.baseurl}}/images/Expense_Activity-Methods.png "ExpenseActivity-Methods")


## Transactions - Attributes
![Transactions-Attributes]({{site.baseurl}}/images/Transaction-Attributes.png "Transactions-Attributes")


## Transactions - Methods
![Transactions-Methods]({{site.baseurl}}/images/Transaction-Methods.png "Transactions-Methods")


## SettingsActivity - Attributes
![SettingsActivity-Attributes]({{site.baseurl}}/images/Settings_Activity-Attributes.png "SettingsActivity-Attributes")


## SettingsActivity - Methods
![SettingsActivity-Methods]({{site.baseurl}}/images/Settings_Activity-Methods.png "SettingsActivity-Methods")


## FilterTransaction - Attributes
![FilterTransaction-Attributes]({{site.baseurl}}/images/FilterTransaction_Activity-Attributes.png "FilterTransaction-Attributes")


## FilterTransaction - Methods
![FilterTransaction-Methods]({{site.baseurl}}/images/FilterTransaction_-Methods.png "FilterTransaction-Methods")


## Log-inActivity - Attributes
![Log-inActivity-Attributes]({{site.baseurl}}/images/Login_Activity-Attributes.png "Log-inActivity-Attributes")


## Log-inActivity - Methods
![Log-inActivity-Methods]({{site.baseurl}}/images/Login_Activity-Methods.png "Log-inActivity-Methods")


## SQLDBHelper - Attributes
![SQLDBHelper-Attributes]({{site.baseurl}}/images/SQLDBHelper-Attributes.png "SQLDBHelper-Attributes")


## SQLDBHelper - Methods
![SQLDBHelper-Methods]({{site.baseurl}}/images/SQLDBHelper-Methods.png "SQLDBHelper-Methods")


## Design Pattern

Design patterns are commonly used solutions that can be used again for solving complex software problems.There are lot of design patterns that can be used for android . There are a few design pattern that we have made use in the code , but the major design pattern our team decided to follow was the Model View Controller Design Pattern.We chose the MVC pattern as the pattern refers to current reigning architectural pattern across several platforms.

We have currently decided to follow the MVC pattern for future progresses. One of the examples is illustrated below:

![MVCDiagram]({{site.baseurl}}/images/design_pattern-1.png "MVCDiagram"){:height="500px" width="700px"}


## Development strategies

According to the SCRUM’s founder “the team is utterly self-managing”.
The process of Development involves the below Work Flow.

![workflow]({{site.baseurl}}/images/Workflow1.png "workflow")

- [Reference:(https://www.google.de/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=0ahUKEwjtwu6vmY7UAhVEfywKHRGQBt8QjRwIBw&url=https%3A%2F%2Fkrify.co%2Fsteps-to-follow-to-avoid-mistakes-during-mobile-app-development%2F&psig=AFQjCNEU3uAQWGVe1Am3uHx6GdKA4ZgWag&ust=1495909804752959)].

This will have to be monitored in number of ways where in each person in the team makes sure that he/she completes their task which has been assigned to them and also makes sure that they continuously monitor the team’s overall performance. This makes sure that there would be no discrepancies in the later stages and also would help maintain clean SCRUM methodology. 

To Keep a Track of all the work which has already been completed, those which are in progress and also which are yet to be implemented we use **ZENHUB** dashboard. This is more sufficient way to know the progress of the project.

![zenhub]({{site.baseurl}}/images/Zenhub.png "zenhub"){:height="600px" width="1000px"}

- [Reference:(https://github.com/DBSE-teaching/isee2017-hackslash#boards?repos=87943612)]. 
			
## Summary of Changes 

We have been following our initial plan to make sure that we accomplish  all the user requirements which we proposed. We met the customer in person and discussed about our implementation plans and also our initial step towards developing the application.
After he reviewed our application, he provided us his feedback and asked us to make few changes which are listed below:

* The filter options would be rather be in "Settings" than in the "Menu"" since this would again depend on the customer. This can be used only if he wants to filter the expense/income accordingly with respect to different categories or the date or might be with respect to the income type. An additional field should also be mentioned in the filter option so that it would be helpful for him if he has to retrieve information of his choice.

* The Amount that the user enters as his income/expense should set to a default currency type and should also be displayed as Three letter word and not the currency symbol.i.e. for EURO we would have to give it as EUR. This will also be more easy to understand since the users might not be aware of all the currency notations.

* The notes section would rather be a text field which should be able to take maximum characters. This would again be user friendly.

* An overview of the past data should also be a part of the home screen. This would help the user to track  his recent expenses.

We are now more inclined towards making our final product a successful one and also would consider the above feed back and would work on it accordingly.

That is all for now !:)

<p align="center">
Thank You for visiting our Third blog!! Stay tuned for our next blog. 
</p>





