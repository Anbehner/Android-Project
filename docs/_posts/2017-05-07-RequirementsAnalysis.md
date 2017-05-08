---
layout: post
title: "Requirement Analysis for Money Management Application"
date: 2017-05-07
---

# Requirement Analysis

Welcome to our second blog, hope you enjoyed our first blog!!    For the past few weeks we worked on gathering the requirements then we came up with user the stories and discussed it with the customer and clarified our assumptions. In this blog we will discuss in detail about the various phases that we went through to complete this activity.

## Phase I – Team preparation for list of questionnaire to customer:

We gathered together and came up with the following questionnaire to be asked to the customer.


Questionnaire:

1. How the home screen of the application should look like?

2. Whether the customer should provide information of both income and expense, how should he provide information about that?

3. What should be the default currency?

4. What kind of information should the customer provide on the money that he wants to manage?

5. Should there be default categories provided?

6. What is the maximum limit of the categories?

7. Should there be any security measures (like passcode)?

8. What should be the default currency?

9. What must be done when the default currency is changed?

10. Should the customer have feasibility to mention the expenses in different currency values?

11. Should there be any graphical notations to represent the expenses / income that the customer carried out in the past?

12. Should there be any help menu?

13. Where should the customer select the option of setting the default currency?

14. Should there be any notification to the customer if expense is about to cross the income that he has?

15. Should the application manage the money of single customer or should it support multi user?


## Phase II – Gathering Requirements:

With this whole bunch of questionnaires, we attacked our customer :blush:. We met him in person discussed with him about our queries. Apart from the answers to our queries, he also provided us with additional requirements as below.
 
1. In the Home Screen there should be an overview of the transactions made for last 2 weeks.

2. The balance amount must be displayed in the Home Screen

3. When the user enters date for the transaction, there should be either scroll down option for the date, month and year (or) it should have a calendar popup for selection.

4. When the user enters amount for the transaction, then there should be a popup of keyboard layout which contains only the numbers (i.e., it should not contain alphabets).

5. The passcode option should be enabled / disabled as per the user preference.

### Clarifying Assumptions:

Before approaching the customer we had few assumptions regarding the application features. We as a team discussed these points with the customer and got clarification about our assumptions.

1.We initially assumed that by default the application should be secured with the passcode and each time when the application opens user has to login by entering the passcode but from the customer we came to know that there should be an option in the settings to enable or disable this feature whenever user wants.

2.We assumed that an overview display of remaining balance amount is not necessary on start screen but from customers point of view it is nice to have that display.


## Phase III – User Stories preparation:

We listed down the requirements provided by the customer as User stories, based on the requirement we mapped the User stories to the Requirements as below:

![RequirementsMapping]({{site.baseurl}}/images/RequirementsMapping.png "ReqquirementsMapping")


## Phase IV – Analyzing user stories:

We have distinguished the User Stories collected in Phase III in to Essential, Necessary and Desirable categories which helps us to priorities the tasks that we need to achieve. 

![UserStoryClassification]({{site.baseurl}}/images/UserStoryClassification.png "UserStoryClassification")


## Phase V - Finalizing user stories: 

Based on the User Stories collected form the customer in Phase II and Phase III we came up with the following Use Case Diagram.
	

![UsecaseDiagram]({{site.baseurl}}/images/UsecaseDiagram.png "UsecaseDiagram")

## Phase VI - : Managing Tasks:

After finalizing the Requirements/UserStories successfully we have listed down the tasks that are required to accomplish the use cases

The following Gantt Chart depicts the list of tasks and its associated time frames to realize that.

![GanttChart]({{site.baseurl}}/images/GanttChart.png "GanttChart")

The Roles and Responsibilities that we have defined as part of our first blog helped alot in deciding the Resource allocation for particular tasks.
The following Resource Allocation chart conveys the tasks assigned for each individual and the time frame to complete those tasks.

![ResourceAllocation]({{site.baseurl}}/images/ResourcesChart.png "ResourceAllocation")

- [RequirementAnalysis reference]({{site.baseurl}}/images/RequirementAnalysis.docx).

<p align="center">
Thank You for visiting our Second blog!! Thats all for Now. Stay tuned for our next blog. 
</p>
