# tweet-app
Tweet App is java console application for registered users to post new tweets, view tweets by other users.

Guest users cannot see any tweets.
The core modules of tweet app are:
1.	User registration and login
2.	Post tweet
3.	View all tweets (all from logged in users account)
4.	View users and their respective tweets
5.	Forgot password option to reset password.

**Programming Language**  : Java\
**Build Tool** :	Maven\
**Database** :	H2 Inline database\
**Code Coverage** :	SonarLint\

PRESENTATION:
1. Application shall be a java console application
2. Application must be menu driven
3. Application will comprise of two menu\
    a. Introduction menu for Non-logged in user\
    `i. Register`\
    `ii. Login`\
    `iii. Forgot Password`\
    b. Menu for logged in user\
    `i. Post a tweet`\
    `ii. View my tweets`\
    `iii. View all tweets`\
    `iv. View All Users`\
    `v. Reset Password`\
    `vi. Logout`
4. Menu must show iteratively after every operation
5. Maintain the status of currently logged in user in DB
6. Update the status when user logs out

DATABASE, STORAGE:
1.	As the twitter application I should\
      a.	Create user when valid user details are provided\
      b.	Create a tweet when user tweets\
      c.	Find all users and their tweets\
      d.	Update user’s password

DEBUGGING & TROUBLESHOOTING:

1.	As the programmer I should:
      a.	Debug & Troubleshoot the code which has bugs with breakpoints / pause
      b.	Ensure optimal resource utilization & close unneeded connections
      c.	Ensure all unhandled exceptions are addressed
      d.	Query the database only for the necessary information (user info/tweets etc) with proper indexes & order.
      