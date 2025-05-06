## Title
> **HandMeDowns**

## Team Members
>Husnain Rafique, Brian Granados,  Anthony Lai

## Description 
> The **HandMeDowns** App is a platform designed to facilitate the exchange of books 
within a local community, particularly targeting students. Instead of relying upon money, users can 
trade books with one another. This approach aims to increase reusability of resources, 
especially for students at the end of their semesters when they no longer need their textbooks. 
The goal and motivation behind this project are: to support the local community by making books 
more accessible and promoting sustainable practices through book exchanges.
> In addition to trading, users can also choose to donate books or sell them. If a book is sold,
 a certain percentage of the sale amount will be contributed to local community help initiatives.
>
> 
> HOW TO <
Launch the application here [HandMeDownsApiApplication.java](https://github.com/your-username/handMeDownsAPI/blob/main/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/HandMeDownsApiApplication.java)
 nagivate to http://localhost:8080/home
> All actors are able to create admins, just navigate to Login, Admin, or Providers in order for an option to register.
> Any provider accounts are the user email and password123.



📁 Project Structure

🔧 Core Packages
handMeDownsAPI
- [Provider](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/Provider)
- [ProviderReviews](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/ProviderReviews)
- [ProviderVisitStats](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/ProviderVisitStats)
- [Reports](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/reports)
- [StatLogs](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/statLogs)
- [SysAdmin](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/sysAdmin)
- [Transaction](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/transaction)

👤 User System
- [User Controllers](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/userControllers)
- [User Models](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/userModel)
- [User Repository](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/userRepository)
- [User Review](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/userReview)
- [User Service](handMeDownsAPI/handMeDownsAPI/src/main/java/handMeDownsAPI/example/handMeDownsAPI/userService)
💅 Frontend & Configuration
- [CSS Stylesheet](handMeDownsAPI/handMeDownsAPI/src/main/resources/static/css/styles.css)
- [FTLH Templates](handMeDownsAPI/handMeDownsAPI/src/main/resources/templates)
- [Application Properties](handMeDownsAPI/handMeDownsAPI/src/main/resources/application.properties)
- [pom.xml](handMeDownsAPI/handMeDownsAPI/pom.xml)

## App Functions
1. User (Student/Bookstore/libraries): Husnain Rafique
    1. **Create/modify user profile** - Users can create and update their profiles, including personal information and their book collection.
    2. **View available services** - Users can browse the available books for trade within their local community.
    3. **Subscribe to available services** - Users can subscribe to notifications about new book listings or updates from other users.
    4. **Write reviews for subscribed services** - Users can write reviews and rate their book trading experiences with other users.
    5. **Donate books:** Customers can choose to donate books to the community.
    6. **Sell books:** Customers can sell books, with a percentage of the sale amount going towards community help.
2. Store (provider): Anthony Lai
    1. **Create/modify/remove provider profile** - Providers, such as local libraries or bookstores, can create and update their profiles and their book inventory.
    2. **Create services** - Providers can list the books they have available for trade and manage their inventory.
    3. **View customer statistics** - Providers can view statistics about user interactions and book trades.
    4. **Reply to reviews** - Providers can reply to reviews left by users about their trading experiences.
3. SysAdmin: Brian Granados
    1. **Manage user access** - Admins can manage user accounts and permissions, ensuring the platform remains secure and user-friendly.
    2. **Moderate services** - Admins can review and moderate the book listings and services provided by users and providers.
    3. **Moderate reviews** - Admins can review and moderate user reviews to maintain a positive and respectful community.
    4. **View usage statistics** - Admins can view statistics about platform usage to monitor growth and engagement.


