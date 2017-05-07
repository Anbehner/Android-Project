---
layout: post
title: "Requirement Analysis for Money Management Application"
date: 2017-05-07
---

# Requirement Analysis

Welcome to our second blog, hope you enjoyed our first blog!!    For the past, few weeks we worked on gathering the requirements, then we came up with user stories and discussed it with the customer and clarified our assumptions. In this blog, we will discuss in detail about the various phases that we went through to complete this activity.

## Phase I – Team preparation for list of questionnaires to customer:

We gathered together and came up with the following questionnaires to be asked to the customer, here we provide you with few set of questions that we have listed down during our discussion.

![Questionnaire]({{site.baseurl}}/images/Questionnaire.png "Questionnaire")

## Phase II – Gathering Requirements:

With this whole bunch of questionnaires, we attacked our customer :blush:. We met him in person discussed with him about our queries. Apart from the answers to our queries, he also provided us with additional requirements as below.

1. As a security measure there should be an option to have a passcode before entering to the application.
2. The passcode option could be enabled or disabled by the user.
3. An option to enter the amount (expense/income) in different currencies where the current value for that currency is to be fetched from internet. This could be a nice to have feature.
4. An option where the user can see the income/expenditure for a particular time period ( Ex: for previous week).
5. The time frame selection could be done by either having a calendar popup or by entering the date by selecting from dropdown.
6. There should be an overview of the transactions made for last 2 weeks on the start screen of the application.
7. The start screen should display the remaining balance amount.

Before approaching the customer we had few assumptions regarding the application features. We as team discussed these points with the customer and got clarification about our assumptions.

1. We initially assumed that by default the application should be secured with the passcode and each time when the application opens user has to login by entering the passcode but from the customer we came to know that there should be an option in the settings to enable or disable this feature whenever user wants.

2. We assumed that an overview display of remaining balance amount is not necessary on start screen but from customers point of view it is nice to have that display.


## Phase III – User Stories preparation:

We listed down the requirements provided by the customer as User stories, based on the requirement we mapped the User stories to the Requirements as below:

![RequirementsMapping]({{site.baseurl}}/images/RequirementsMapping.png "ReqquirementsMapping")


## Phase IV – Analyzing user stories:

We have distinguished the User Stories collected in Phase III in to Essential, Necessary and Desirable categories which helps us to priorities the tasks that we need to achieve. 

![UserStoryClassification]({{site.baseurl}}/images/UserStoryClassification.png "UserStoryClassification")


## Phase V - Finalizing user stories: 

Based on the User Stories collected form the customer  in Phase II and Phase III we came up  with the following Use Case Diagram.
	

![UsecaseDiagram]({{site.baseurl}}/images/UsecaseDiagram.png "UsecaseDiagram")

## Phase VI - : Managing Tasks:
After finalizing the Requirements/UserStories successfully we have listed down the tasks that are required to accomplish the use cases

The following Gantt Chart depicts the list of tasks and its associated time frames to realize that.

![GanttChart]({{site.baseurl}}/images/GanttChart.png "GanttChart")

The Roles and Responsibilities that we have defined as part of our first blog helped alot in deciding the Resource allocation for particular tasks.
The following Resource Allocation chart conveys the tasks assigned for each individual and the time frame to complete those tasks.

![ResourceAllocation]({{site.baseurl}}/images/ResourcesChart.png "ResourceAllocation")

