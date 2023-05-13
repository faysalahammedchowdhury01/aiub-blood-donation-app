# AIUB-BLOOD-DONATION-CLUB

<br>

# Table of Contents

- [How to run](#how-to-run)
- [Features](#features)
- [User Guide](#user-guide-)
- [Application Structure](#application-structure)


<br>

# How to run
To download the file, you can either choose to download it manually or follow these steps below to make the process more streamlined and efficient.

1. Open terminal.
2. Clone this repository
   ```sh
   git clone https://github.com/faysalahammedchowdhury01/aiub-blood-donation-club-app.git
   ```
3. Enter the desired directory 
   ```sh
   cd aiub-blood-donation-club-app/
   ```
4. Build  
   ```sh
   javac Start.java
   ```
5. Run  
   ```sh
   java Start
   ```


<br>
<br>

# **💡Features**

- **Two types of users:**
    - Donors
    - Recipients
- **Each user can have at most two accounts:**
    - One donor account
    - One recipient account
- **Recipient features:**
    - After logging in, recipients can see their dashboard.
    - On the dashboard, recipients can see an interface for requesting blood.
    - After making a request, recipients can see their all requests on the "My Requests" page.
    - If a donor has already donated to a request, recipients can see a "Contact Donor" button that redirects them to the donor's profile.
    - Recipients can also find donors by using the "Find Donor" page.
    - Recipients cannot edit or delete any post in which a donor has donated.
    - Every recipient has a profile containing their name, email, total requests made, total received, total pending requests, and more
- **Donor features:**
    - After logging in, donors can see their dashboard.
    - On the dashboard, available donation options are displayed. Donors can only see posts, where the blood group requested, matches their own blood group and they are available.
    - In every post, donors can see a "Recipient" button, which redirects them to the post recipient's profile. Donors can then donate blood to that recipient.
    - After donating blood, donors can see all their donations on the "My Donations" page.
    - Donors can also find a donor for a specific blood request on the "Find Donor" page. This is useful for donors who may also need blood sometimes.
    - Donors cannot see any posts if their status is unavailable.
    - Every donor has a profile containing their AIUB ID, name, email, total donations, status, and more
- **Other features:**
    - **Account creation:**
        - AIUB ID and email must be valid.
        - Password and Confirm Password must be the same.
        - If an existing user tries to sign up, they will be logged in instead if their AIUB ID and password match.

<br>
<br>

# **User Guide** 📄

Welcome to AIUB Blood Donation Club, an application designed to connect donors and recipients for blood donations. In this user guide, we'll take you through the features of the app and how to use them.

## **Getting Started**

To use the application, you need to create an account. If you're a first-time user, click the "Register" button and provide your details such as your name, email, password, AIUB ID, and blood group. If you have already registered, simply log in using your AIUB ID and password.

### **Home**

After logging in, you will be directed to the home page. From here, you can access all the features of the application.

### **Request Blood -** Dashboard(Recipient)

If you need blood, you can create a post by clicking on the "Request Blood" button. In the post, you need to provide details such as location, date, time, and blood group. Once you create a post, it will appear on your profile, and only you and available donors can view it. You can edit the post or delete it before it is closed if you want.

### **Donate Blood**

If you are a donor, you can view all the available posts on the newsfeed. You can view the details of the post, such as location, date, time, and blood group. If you are eligible to donate blood, you can apply to donate by clicking on the "Donate Blood" button. Once you apply to donate blood, your name will appear in the list of donors for that post, and only the recipient and donors with matching blood groups can view the post.

### Dashboard(Donor)

The newsfeed displays all the available open posts for donation. Open posts are visible to the owner of the post and donors with matching blood groups. You can view the details of the post, such as location, date, time, blood group, and the number of required bags. Closed posts are not visible on the newsfeed.

### **Find Donor**

If you cannot find a donor for your request, you can use the "Find Donor" page to search for donors. You can search for donors based on their blood group. This feature is available for both (Donor and Recipient).

### **Contact Donor**

If a donor has already donated to your request, you can see a "Contact Donor" button that redirects you to the donor's profile. From there, you can contact the donor to thank them or request further help.

### **My Requests**

After making a request, recipients can see all their requests on the "My Requests" page. You can view the details of your requests, such as the number of bags required, the date and time of the request, and the status of the request (open or closed).

### **My Donations**

After donating blood, donors can see all their donations on the "My Donations" page. You can view the details of your donations, such as the recipient's name, the number of bags donated, the date and time of the donation, and the status of the donation (accepted or rejected).

### **Logout**

Once you are done using the application, you can log out by clicking on the "Logout" button.

<br>
<br>

# Application Structure:

### Back-end **Classes:**

- **User:**
    - Data
        - AIUB ID
        - Name
        - Email
        - Phone Number
        - Password
        - Blood Group
        - Is Donor
    - Methods
        - Getter(s)
        - Setters()
        - Get Donors()
- **Recipient(User):**
    - Data
    - Methods
        - Create Post()
        - Delete Post()
        - Get My Requests()
        - Login()
        - Sign Up()
- **Donor(User):**
    - Data
        - Status
        - Last Donate Date
    - Methods
        - Getters()
        - Setters()
        - Donate Blood()
        - Get My Donations()
        - Login()
        - Sign Up()
- **Post:**
    - Data
        - Post ID
        - Author
        - Status
        - Date
        - Time
        - Location
        - Required Blood Group
        - Donors AIUB ID
        - Description
    - Methods
        - Getters()
        - Setters()
        - Create Post()
        - Delete Post()
        - Add Donor()
        
<br>
<br>

### Java GUI Components:

- Signup
- Login
- DonorDashboard
- RecipientDashboard
- MyRequests
- MyDonations
- DonorsList
- DonorsProfile
- RecipientsProfile
- EditPost