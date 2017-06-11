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

1.Software is not maintained for its whole life by the original author.

2.It improves the readability and clarity and helps other developers to understand the code quickly.

3.Makes the Code maintenance easier.

We have categorized the Coding Conventions which you can find below:

### 1.File Suffixes:

Java Source files will be saved with .java file extension.

### 2.File Organization:

The Picture below depicts the Java Source file Structure.

![components_Java]({{site.baseurl}}/images/components_Java.png "components_Java"){:height="768px" width="1024px"}

We are following the Java Source file Structure as shown above in the Picture.

Java Source files will have the following Ordering:

1.Beginning Comments.
2.Package and import Statements.
3.Class Declaration and Definition.
   
   
### 3.Indentation:

We are following 8 space indentation Method. 

Example:

 Private static void onClick (int a,<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int b, string c) {<br>
}


### 4.Commenting Convention:

We are using Block Comment Method to describe about the classes and methods.

Example: 	/*<br>
 		  * Description <br>
  		*/
		
We are using single line comments to describe the variables and conditions.
Java Doc comments are used to describe interfaces, constructor etc	.
	
### 5.Variable Declaration:

Single Declaration  per line, which allows us to add comment for this declaration.

Example:  int arraySize    // variable to hold size of an array. 

### 6.Variable initialization:

Local variables would be initialized when they are declared itself.

### 7.Statements:

Each line should contain a single statement.

Example: return (a);

### Return Statements:

Return Statements with a value should not use parenthesis  unless they make the return value more obvious in same way.

Example: return;  return array.size();

### If else & in else-if Statement:

We are making sure that If else class satatements  follow the following structure.

If (condition) {<br>
::Statements;<br>
}

If (condition) {<br>
::Statements;<br>
} else {<br>
::Statements;<br>
}

### 8.White Spaces:

1.Two Blank Lines will be used between the sections of a java source file.

2.One Blank line will be used between the methods, local variable  and conditional statements.

### 9.Naming Conventions:

The Table below shows the details about the Naming Conventions that we are using in our Project. 

![Convention_name]({{site.baseurl}}/images/Convention_name.png "Convention_name"){:height="768px" width="900px"}

- [Image Reference](http://www.diehardtechy.com/2014/02/java-naming-conventions.html).


We discussed these Coding Standards in Team meeting and each team member agreed upon to follow these coding conventions.
We make sure that before committing the code it will be reviewed by all the other team members and take get approval from them regarding these coding standards.
Thus we enforce that our code follows the coding conventions which we agreed upon as a team.

## Personas for Money Management app 

If you see most people,check their smartphones at least 50 times a day – looking at everything from text messages and work emails to weather alerts and box scores. But as many have discovered, your smartphone can help you keep tabs on your finances.
With that note we bring to you our smart budget app for managing your income and expenses .
There’s no “right” way to approach money management. What works for you might not work for me, and vice versa. 
Hence we had an idea to potrait two differnt personalities and their situations ,and our app which could make the situation more approachable .

![happy-businessman-cartoon_1012-180]({{site.baseurl}}/images/happy-businessman-cartoon_1012-180.jpg "Bussiness Man")

References:(http://www.freepik.com/free-vector/happy-businessman-cartoon_834492.htm)

Now in the above case is a **Business Man** who has alot to keep in his mind . The basic necessity for him is to maintain his records on the income and the expenses spent on his clients , the raw materials, the investment on business meets , the payment to his employees ,any damage cost and so on.He should also be bale to save his money that he gets as a profit for future endeavors.
Hence this seems more goal oriented approach , goal-oriented approach to personal finance can be super effective, but only if you have a keen sense of what’s important when setting goals. An abstract goal without concrete numbers won’t help you.
“I will stash away 100 euro every month ” is a much better goal than “I want to be rich” because it’s actionable. It’s also easy to see when you’re making progress.
That is why "Money Management App" is an effective app .It is based on how you categorise your income and expense, to take a note on the overview expenditure and cut down the costs on which category you had easily spent on . This allows you to save money and handle it in a smarter way .

Now consider another case , **A Family Guy** 

![man-woman-and-child-vector-character-family-illustration_M1iTj1du_S]({{site.baseurl}}/images/man-woman-and-child-vector-character-family-illustration_M1iTj1du_S.jpg "Family Man")

References:(https://www.graphicstock.com/stock-image/husband-wife-and-child-vector-cartoon-character-family-illustration)

A  homebudgeting app should help you resolve crisis such as your monthly salary , the expenditure on groceries , monthly rents  and so on . Hence ,you have to input your income and expenses on a per-item basis, which is less convenient but comes with the benefit of making you highly aware of your financial situation.



## MOCK UP FOR Money Management Application

After we met the customer and after a detailed discussion about the requirements and the functionalities, we came up with a design of our application. We sat together and decided a common design in a form of a paper prototype.

We have come up with the following Paper Prototypes for our application.

The below activity would redirect to show enabling of the Passcode/PIN if and only if he wants to enable the security PIN to use this application 

![Prototype1]({{site.baseurl}}/images/prototype1.png "Login Action"){:height="700px" width="1024px"}

The below activity would redirect to the Income activity where the user would input his income based on date, category and also the payment method.

![Prototype2]({{site.baseurl}}/images/prototype2.png "Income Activity"){:height="700px" width="1024px"}

The below activity would redirect to the Expense activity where the user would input his expenditures based on date, category and also the payment method.

![Prototype3]({{site.baseurl}}/images/prototype3.png "Expense Activity"){:height="700px" width="1024px"}

## Story Board for two user stories

Storyboards are similar to scenarios: They illustrate the interaction required to achieve a goal. But instead of using a list of steps, a storyboard visualises the interaction similar to a comic strip. Here is a sample board I created to explore another interaction for our new application:

The below storyboard describes how the persona Mary keeps a track of the money she spent during her birthday. She takes her friends for a dinner at the VAPIANO. The board consists of a series of frames. Each frame shows sample data. Underneath it, I added a brief description of what Mary does at each step.
![Storyboard1]({{site.baseurl}}/images/storyboard1.png "Adding Expense"){:height="700px" width="1024px"}
Once the above fields are completed she then clicks on “Add Expense” and then this information is stored.

The below storyboard describes how the persona Sunil secures his HACKSLASH application so that only he would be able to view how he manages his income or expenses. Underneath it, I added a brief description of what Sunil does at each step. 
![Storyboard2]({{site.baseurl}}/images/storyboard2.png "Adding Expense"){:height="700px" width="1024px"}

## User Interface

Following two screens would be the user interface of our application:

The Home Screen

![HomeScreen]({{site.baseurl}}/images/homescreen.png "Home Screen"){:height="700px" width="900px"}

The Income Activity Screen

![IncomeScreen]({{site.baseurl}}/images/incomescreen.png "Income Activity Screen"){:height="400px" width="200px"}

## Summary of Changes 

We have been following our initial plan to make sure that we accomplish  all the user requirements which we proposed.
There has not been any changes occured in user requirements since the system design phase.

That is all for now !

<p align="center">
Thank You for visiting our Fourth blog!! Stay tuned for our next blog. 
</p>




