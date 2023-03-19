# Fitness and Wellness Application 

## Introduction

The purpose of this fitness app is to provide the user with instructions and examples of one or more types of exercise, physical activity, nutritional programs, or some other fitness topic.
Fitness and Wellness App provides health and fitness tips and guidelines, which help individuals in meeting their health goals. You can also get free workout or exercise ideas that help you to plan your workout routine easily.
The application is designed to keep track of users' workouts, create custom workouts consisting of different types of exercises, and give recommandations to new users based on their height, age and kilograms. 
The Fitness Software provides lots of functions such as data entry of customers, keeping records of all the things about customers' entire journey within the application, and physical fitness which help to provide good quality of service.

The application has two types of users:
1. **Standard user** ( this type of account is made automatically through registration and it has access to standard features )
2. **Admin** ( it has access to all existent accounts and to extended features such as accessing the database of the application and all its users )
## Objectives
- The main objective of the project is to develop software that facilitates the
data storage, data maintenance and its retrieval for the customer in an igneous way.
- To store the record of the customers, the staff that has the privileges to access, modify and delete any record and finally the service.
- Also, only the staff has the privilege to access any database and make the
required changes, if necessary.
- To develop easy-to-use software which handles the customer-staff
relationship in an effective manner.
- To develop a user friendly system that requires minimal user
training. Most of the features and function are similar to those on any windows platform.

## Benefits
One of the most important benefits of using a fitness app is 'motivation'. Notification and reminders from fitness apps keep reminding you about your health goals, thus keeping you motivated.
You may also come across your fitness app various times in a day while using your smartphone. Fitness apps have made our lives easier and enable you to track your activities on a daily basis. Thus, making you stay focused on your activities and overall fitness.

## Functionalities
#### 1.Register
- a new user has the ability to register into the application by filling out a register form where he has to choose a username and a password and also to declare his height, date of birth and kilograms.

#### 2.Login
- an already registered user can login into its account based on the username and the password that he chose earlier.

#### 3. Personalised recommandations
- based on each user characteristics, the application will recommand the user a unique workout, that will fit perfectly for the phisycal form that the user wants to accomplish and for the user's interests taking into account the time that a user wants to spend training, the difficulty of the traning and the categories of muscles that he wants to train.

#### 4. Statistics
- the admin is be able to consult statistics for future development of the sofware as well as for improving workouts that are less used, recommand more workouts that are preferred more or modify different aspects of the application .

#### 5. Create custom workouts
- the user can create its own workout consisting of the available exercises so that its preferrences will be satisfied completely. 

# Security
#### Initialization of Spring Security
In order to add security to my Spring Boot application I used Spring Security Starter pack and I added the security starter dependency in the pom.xml.This will also include the SecurityAutoConfiguration class containing the initial/default security configuration.
I used JWT security which generates a security password each time you add spring security to pom.xml, spring boot generates a password in memory, it does not add it to the database.

#### Configuration
I used Filter Chains for the first configuration of Spring Boot Security. Spring Security maintains a filter chain internally where each of the filters has a particular responsibility and filters are added or removed from the configuration depending on which services are required. The ordering of the filters is important as there are dependencies between them. 
###### Filter Security Chains
The client sends a request to the application, and the container decides which filters and which servlet apply to it based on the path of the request URI. At most, one servlet can handle a single request, but filters form a chain, so they are ordered.
Each filter that we go through, is going to pass through it the HTTP request and the HTTP respone depending which way we traverse the chain.
The request is going to go through all the filter chains until it hits the Servlet request
where it will finally be routed to the controllers from the servlet.
The request will be intercepted before it goes to the controller.

#### Spring Boot Security Role-based Authorization
For role-based authorization with credentials and authorities stored in database, I created the following 2 tables: Users, Roles. 
The users table stores credentials and user details and the roles table stores authorities (rights : User and Admin). The entity relationship between users and roles is many-to-one because a user can have only one role and a role can be assigned to be one or more users. 
The authentication privilage means that a user can actualy use the software, he can log in and perform different actions regerding his account.
The authorization privilage refersto the fact that even though a standard user can actual use the software, there are only certain software part that you he can use having some restrictions compared to an admin which has access to extended features of the application.

#### Password Encoding
For crypting all the passwords in the application, I used BCryptPasswordEncoder. It uses the BCrypt strong hashing function. Bcrypt uses adaptive hash algorithm to store the password.
BCrypt implements OpenBSD-style Blowfish password hashing using the scheme described in "A Future-Adaptable Password Scheme" by Niels Provos and David Mazieres.
This password hashing system tries to thwart off-line password cracking using a computationally-intensive hashing algorithm, based on Bruce Schneier's Blowfish cipher. The work factor of the algorithm is parameterised, so it can be increased as computers get faster.






