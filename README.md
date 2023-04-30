# AIUB-BLOOD-DONATION-CLUB

<br>

# Table of Contents

- [How to run](#how-to-run)
- [Features💡](#features)
- [User Guide 📄](#user-guide-)
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

# Features💡

1. The application connects donors and recipients and caters to two types of users: donors and recipients.
2. A user can have two different types of accounts - donor and recipient.
3. Recipients can create a post requesting blood, while donors can donate blood in response to a post.
4. Posts contain necessary details such as location, date, time, and the required blood group.
5. Users can view their donation and recipient history.
6. Posts can be open or closed.
7. All posts of a recipient are visible only to that recipient, while open posts are only visible to the owner and donors with a matching blood group.
8. Open posts can be edited for flexibility.
9. Donors can donate blood for a post, and when they do, the post will be closed.
10. Available donors can be viewed by everyone on the platform.
11. The profile of any donor is visible to everyone on the platform.
12. Recipients can see the donor of a post.
13. Donors can see the recipient of a post.
14. The platform is user-friendly and easy to use.
15. The application provides a reliable and efficient platform for blood donation and recipient requests.

<br>
<br>

# **User Guide** 📄

Welcome to our blood donation application! This application allows users to either request blood or donate blood. Let's take a look at how you can use this application.

### **Register/Login**

To start using the application, you need to create an account. If you are a first-time user, please register by providing your details such as your AIUB ID, name, email, password, and blood group. If you have already registered, simply log in using your AIUB ID and password.

### **Home**

After logging in, you will be directed to the home page. From here, you can access all the features of the application.

### **Request Blood**

If you need blood, you can create a post by clicking on the "Request Blood" button. In the post, you need to provide details such as location, date, time, and blood group. Once you create a post, it will appear on your profile, and only you and available donors can view it. You can edit the post or delete it before **closed** if you want.

### **Donate Blood**

If you are a donor, you can view all the available posts on the newsfeed. You can view the details of the post, such as location, date, time, and blood group. If you are eligible to donate blood, you can apply to donate by clicking on the "Donate Blood" button. Once you apply to donate blood, your name will appear in the list of donors for that post, and only the recipient and donors with matching blood groups can view the post.

### **Newsfeed**

The newsfeed displays all the available open posts for donation. Open posts are visible to the owner of the post and donors with matching blood groups. You can view the details of the post, such as location, date, time, blood group, and the number of required bags. Closed posts are not visible on the newsfeed.

### **Profile**

Your profile displays your personal information, donation history, and posts created by you. You can view your received and donated blood history, edit or delete your posts, and view the list of donors who have donated blood for your posts.

### **Logout**

Once you are done using the application, you can log out by clicking on the "Logout" button.

<br>
<br>

# Application Structure

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
        - Getter()
        - Setters()
- **Recipient(User):**
    - Data
        - Total Request
        - Total Received
    - Methods
        - Create Post()
        - Login()
        - Signup()
- **Donor(User):**
    - Data
        - Status
        - Last Donate Date
        - Total Donation
    - Methods
        - Getters()
        - Setters()
        - Login()
        - Signup()
        - Donate Blood()
- **Post:**
    - Data
        - Post ID
        - Author
        - Status
        - Date
        - Time
        - Location
        - Required Blood Group
        - Donor
        - Description
    - Methods
        - Getters()
        - Setters()
        - Add Donor()
        - Edit Post()
        - Delete Post()
        
<br>
<br>

# Java GUI Components

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