# tweet-app
Tweet App is java console application for registered users to post new tweets, view tweets by other users.

Guest users cannot see any tweets.
The core modules of tweet app are:
1.	User registration and login
2.	Post tweet
3.	View all tweets (all from logged in users account)
4.	View users and their respective tweets
5.	Forgot password option to reset password.

**Programming Language**  : Java
**Build Tool** :	Maven
**Database** :	H2 Inline database and MySQL
**Code Coverage** :	SonarLint

###PRESENTATION:
1. Application shall be a java console application
2. Application must be menu driven
3. Application will comprise of two menu
    a. Introduction menu for Non-logged in user
    `i. Register`
    `ii. Login`
    `iii. Forgot Password`
    b. Menu for logged in user
    `i. Post a tweet`
    `ii. View my tweets`
    `iii. View all tweets`
    `iv. View All Users`
    `v. Reset Password`
    `vi. Logout`
4. Menu must show iteratively after every operation
5. Maintain the status of currently logged in user in DB
6. Update the status when user logs out

###DATABASE OPERATIONS:
1.	As the twitter application I should
      a.	Create user when valid user details are provided
      b.	Create a tweet when user tweets
      c.	Find all users and their tweets
      d.	Update user’s password
      
      
###SAMPLE COMMAND LINE OUTPUT 
```
________________________________________________________________________________________
				Welcome to Tweet App
----------------------------------------------------------------------------------------
1) Register
2) Login
3) Forgot Password
4) Exit

Enter Your Choice: 1

________________________________________________________________________________________
				User Registration Form:
----------------------------------------------------------------------------------------
Enter First Name(Required): vishnu
Enter Last Name(Optional): revula
Enter Gender(Required) [male/female]: male
Enter Date of Birth(Optional) [dd-MM-yyyy]: 14-09-1999
Enter Email(Required): vishnu@gmail.com
Enter Password(Required): vishnu
Enter Mobile Number(Required): 9440833421

	User Registration Successful.

________________________________________________________________________________________
				Welcome to Tweet App
----------------------------------------------------------------------------------------
1) Register
2) Login
3) Forgot Password
4) Exit

Enter Your Choice: 2

________________________________________________________________________________________
                                    User Login Form:
----------------------------------------------------------------------------------------
Enter Email: vishnu@gmail.com
Enter Password: vishnu

    User Logged in Successfully.

________________________________________________________________________________________
				Logged In as vishnu@gmail.com
----------------------------------------------------------------------------------------
1) Post a Tweet
2) View my Tweets
3) View all Tweets
4) View Tweets of users
5) Change Password
6) Logout
   Enter Your Choice: _1_

________________________________________________________________________________________
                                    Post a Tweet
----------------------------------------------------------------------------------------
Enter Your Tweet(Max 300 chars): [PRESS ENTER TO POST YOUR TWEET]
Madness is like gravity. All it needs is a little push!!! - Joker %)
________________________________________________________________________________________
				Logged In as vishnu@gmail.com
----------------------------------------------------------------------------------------
1) Post a Tweet
2) View my Tweets
3) View all Tweets
4) View Tweets of users
5) Change Password
6) Logout
   Enter Your Choice: 2

________________________________________________________________________________________
				Your Tweets are
----------------------------------------------------------------------------------------

Tweet :
Madness is like gravity. All it needs is a little push!!! - Joker%)
by: vishnu revula 
at: 2022-07-16 01:24:31.223

________________________________________________________________________________________
				Logged In as vishnu@gmail.com
----------------------------------------------------------------------------------------

1) Post a Tweet
2) View my Tweets
3) View all Tweets
4) View Tweets of users
5) Change Password
6) Logout
   Enter Your Choice: 3

________________________________________________________________________________________
				Tweets posted by all the users
----------------------------------------------------------------------------------------

Tweet :
“May the Force be with you.” -Star Wars 1977
by: vishnu r  
at: 2022-07-16 01:22:40.354

Tweet :
“Hope. It is the only thing stronger than fear. A little hope is effective. A lot of hope is dangerous.” -The Hunger games
by: vinay r
at: 2022-07-16 01:22:40.364

Tweet :
Madness is like gravity. All it needs is a little push!!! - Joker%)
by: vishnu revula
at: 2022-07-16 01:24:31.223

________________________________________________________________________________________
				Logged In as vishnu@gmail.com
----------------------------------------------------------------------------------------
1) Post a Tweet
2) View my Tweets
3) View all Tweets
4) View Tweets of users
5) Change Password
6) Logout
   Enter Your Choice: 4

________________________________________________________________________________________
				Select user to view tweets posted by them
----------------------------------------------------------------------------------------
1) vishnu0@gmail.com
2) vishnu1@gmail.com
3) vishnu@gmail.com
    Enter Your Choice: 3


Tweets of vishnu@gmail.com

Tweet :
“Hope. It is the only thing stronger than fear. A little hope is effective. A lot of hope is dangerous.” -The Hunger games
by: vinay r
at: 2022-07-16 01:22:40.364

________________________________________________________________________________________
				Logged In as vishnu@gmail.com
----------------------------------------------------------------------------------------
1) Post a Tweet
2) View my Tweets
3) View all Tweets
4) View Tweets of users
5) Change Password
6) Logout
   Enter Your Choice: 5

________________________________________________________________________________________
				Reset Password Form:
----------------------------------------------------------------------------------------
Enter Old Password: vishnu
Enter New Password: vis
Confirm Password: vis

        Password Updated Successfully.

________________________________________________________________________________________
				Logged In as vishnu@gmail.com
----------------------------------------------------------------------------------------
1) Post a Tweet
2) View my Tweets
3) View all Tweets
4) View Tweets of users
5) Change Password
6) Logout
   Enter Your Choice: 6
	                   
        Logged out successfully.

________________________________________________________________________________________
				Welcome to Tweet App
----------------------------------------------------------------------------------------
1) Register
2) Login
3) Forgot Password
4) Exit
Enter Your Choice: 3

________________________________________________________________________________________
				Reset Password Form:
----------------------------------------------------------------------------------------
Enter your Email to Reset Password: vishnu@gmail.com
Enter Date of Birth(Optional) [dd-MM-yyyy]: 14-08-1999

        Invalid Details. Try again from beginning
________________________________________________________________________________________
				Welcome to Tweet App
----------------------------------------------------------------------------------------
1) Register
2) Login
3) Forgot Password
4) Exit

Enter Your Choice: 3

________________________________________________________________________________________
				Reset Password Form:
----------------------------------------------------------------------------------------
Enter your Email to Reset Password: vishnu@gmail.com
Enter Date of Birth(Optional) [dd-MM-yyyy]: 14-09-1999
Enter New Password: vishnu
Confirm Password: vishnu

	Password Updated Successfully.

________________________________________________________________________________________
				Welcome to Tweet App
----------------------------------------------------------------------------------------
1) Register
2) Login
3) Forgot Password
4) Exit

Enter Your Choice: 2

________________________________________________________________________________________
				User Login Form:
----------------------------------------------------------------------------------------
Enter Email: vis
Enter Password: vis

	Incorrect Username or Password

________________________________________________________________________________________
				Welcome to Tweet App
----------------------------------------------------------------------------------------
1) Register
2) Login
3) Forgot Password
4) Exit

Enter Your Choice: 4


	Thank You for Using Tweet App.


Closing reader

Process finished with exit code 0
