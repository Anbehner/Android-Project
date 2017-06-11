---
layout: post
title: "Implementation and UI Design"
date: 2017-06-12
---

Hello Everyone!
Welcome to our fourth blog, hope you enjoyed our third blog!!.    In this blog we shall be discussing about Coding Conventions, Context of use , Mockup of the application and also various Design solutions.

## Coding Conventions
We are following javasoft coding standard throughout our project.

Coding Convention standard plays a vital role in Software Development Life Cycle for a number of reasons:

*Software is not maintained for its whole life by the original author.

*It improves the readability and clarity and helps other developers to understand the code quickly.

*Makes the Code maintenance easier.

We have categorized the Coding Conventions which you can find below:
**1.File Suffixes:**

Java Source files will be saved with .java file extension.

**2.File Organization:**

The Picture below depicts the Java Source file Structure.

![components of Java]({{site.baseurl}}/images/components of Java.jpeg "components of Java"){:height="768px" width="1024px"}
We are following the Java Source file Structure as shown above in the Picture.

Java Source files will have the following Ordering:

       	Beginning Comments.

       	Package and import Statements.

       	Class Declaration and Definition.

**3.Indentation:**

We are following 8 space indentation Method 

Ex:
 Private static void onClick (int a,
 	        int b, string c) {
}


**4.Commenting Convention:**

1.	We are using Block Comment Method to describe about the classes and methods.
Ex: 		/*
 		  * Description
  		*/
		
	2.     We are using single line comments to describe the variables and conditions.
	
	3.     Java Doc comments are used to describe interfaces, constructor etc	.
	
**5.Variable Declaration:**

Single Declaration  per line , which allows us to add comment for this declaration.
	      Ex:  int arraySize    // variable to hold size of an array. 

**6.Variable initialization:**

1.	Local variables would be initialized when they are declared itself.

**7.Statements:**

1.	Each line should contain a single statement.
Ex: return (a);
2.	Return Statements:
Return Statements with a value should not use parenthesis  unless they make the return value more obvious in same way.

Ex: return;  return array.size();

3.	If else & in else-if Statement:

We are making sure that If else class satatements  follow the following structure.

If (condition) {
	Statements;
}

If (condition) {
	Statements;
} else {
	Statements;
}

**8.White Spaces:**

1.	Two Blank Lines will be used between the sections of a java source file.
2.	One Blank line will be used between the methods, local variable  and conditional statements.

**9.Naming Conventions:**
The Table below shows the details about the Naming Conventions that we are using in our Project. 

![Convention name]({{site.baseurl}}/images/Convention name.jpeg "Convention name"){:height="768px" width="1024px"}

References:(http://www.diehardtechy.com/2014/02/java-naming-conventions.html)

We discussed these Coding Standards in Team meeting and each team member agreed upon to follow these coding conventions.
We make sure that before committing the code it will be reviewed by all the other team members and take get approval from them regarding these coding standards.
Thus we enforce that our code follows the coding conventions which we agreed upon as a team.


## Mock up for HACKSLASH

After we met the customer and after a detailed discussion about the requirements and the functionalities, we came up with a design of our application HACKSLASH. We sat together and decided a common design in a form of a paper prototype.

We have come up with the following Paper Prototypes for our application.

*The below activity would redirect to show enabling of the Passcode/PIN if and only if he wants to enable the security PIN to use this application 

![Prototype1]({{site.baseurl}}/images/prototype1.png "Login Action"){:height="700px" width="1024px"}

*The below activity would redirect to the Income activity where the user would input his income based on date, category and also the payment method.

![Prototype2]({{site.baseurl}}/images/prototype2.png "Income Activity"){:height="700px" width="1024px"}

*The below activity would redirect to the Expense activity where the user would input his expenditures based on date, category and also the payment method.

![Prototype3]({{site.baseurl}}/images/prototype3.png "Expense Activity"){:height="700px" width="1024px"}

## Story Board for two user stories

Storyboards are similar to scenarios: They illustrate the interaction required to achieve a goal. But instead of using a list of steps, a storyboard visualises the interaction similar to a comic strip. Here is a sample board I created to explore another interaction for our new application:

*The below storyboard describes how the persona Mary keeps a track of the money she spent during her birthday. She takes her friends for a dinner at the VAPIANO. The board consists of a series of frames. Each frame shows sample data. Underneath it, I added a brief description of what Mary does at each step.
![Storyboard1]({{site.baseurl}}/images/storyboard1.png "Adding Expense"){:height="700px" width="1024px"}
Once the above fields are completed she then clicks on “Add Expense” and then this information is stored.

*The below storyboard describes how the persona Sunil secures his HACKSLASH application so that only he would be able to view how he manages his income or expenses. Underneath it, I added a brief description of what Sunil does at each step. 
![Storyboard2]({{site.baseurl}}/images/storyboard2.png "Adding Expense"){:height="700px" width="1024px"}

## User Interface

Following two screens would be the user interface of our application:

*The Home Screen
![HomeScreen]({{site.baseurl}}/images/homescreen.png "Home Screen"){:height="400px" width="200px"}

*The Income Activity Screen
![IncomeScreen]({{site.baseurl}}/images/incomescreen.png "Income Activity Screen"){:height="400px" width="200px"}

## Summary of Changes 

We have been following our initial plan to make sure that we accomplish  all the user requirements which we proposed.

That is all for now !

<p align="center">
Thank You for visiting our Fourth blog!! Stay tuned for our next blog. 
</p>




