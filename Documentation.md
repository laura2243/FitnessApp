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
## Database Design
![Database](https://www.planttext.com/api/plantuml/svg/hLN1Ri8m3BttAxnDcgYqQjeafWbL5QTTTjqTXTRGY2QjqdI0W7-V4q89h8LfMxX0_DvpdkEOSQsPqeqeWfiCPrmYL8eBfjQJ1Qu7gn3YQHAdPL6gqTtqzVNbYNxUKoY97-rk0gluSPgqx5cfaCzbotPKPjOtPilIR5gWmQFKNAzX1N4CWuy7MEPSOmZ9CG5n6o5zRPoP3uaBp3YB5AQboawow1m56IiObq4Gx9FX2bNAQwp3JG1muffduGYur3X7PMA-9xskq8_JGT_UwNXdi6Mf5cMZUv3E0vlZQIAtds6TAbvfNagAVpALvamDdeV3q0SrYZd4TuMS3fBhpj1YthajcS2EPC7EbKkL1PKAhjRgebohPghuPxMZN5EZchYIErN_ClmC5affhjwWJtBItJp_43_nv2SnLPtyhabGC5xqjyU_TO2BLgokgGnPFyBultPHhf0zPTeB_URf7Tu4qpYXAS7hd62Q2wJf9gh1ItWEibFl0gRpSP6De1qRi8kYxHPi9u_WTd-u4SzkFGWu4As3S_CT2DyE24ln6nXWkusY3S5iHu5Rn76zsy5eAJrfV9QD7V1csQVjfN5DQGb7FUV4-lN0dkzWZ3AZVv8l)
## Features
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

# Functionalities
**1. User Functionalities**
Regarding authentication:
- register an account (only if the username and email is not already taken)
- login with an existing account

**2. Admin Functionalities:**
Regarding types:

 - add a new exercise type
 - remove a type (only if it is not included in an exercise routine)
 - update an exercise type
 - view all available types

Regarding exercises:
 - add a new exercise
 - remove an exercise 
 - update an exercise 
 - view all available exercises
 

**3. Sending Email of registration**
The Observer pattern consists of the following participants:
- The object that watches the state of another object is called the Observer.
- The object being watched is called the Subject. A subject may have any number of observers. All observers are notified whenever the subject changes state.

The Observer pattern is also known as Publish-Subscribe. The subject is the publisher. It sends out notifications without having to know who its observers are. Any number of observers can subscribe to receive notifications.

For my observer pattern whenever any new user will register, the user will be notified via email. So, the user will have both the roles of Observer and Observable at different times. Based on the requirements of Subject, i used the ApplicationEvent interface that defines the contract methods to be implemented by any concrete subject.
The publisher of the event (registration) is the class that holds the logic for registering a new user. The publisher (observable) constructs the event object and publishes it to anyone who's listening.
To publish the event, the publisher can simply inject the ApplicationEventPublisher and use the publishEvent() API.
The listener (observer) will consume an event of type NewUserEvent, is invoked synchronously and it is responsible with sending the email.

# Endpoints
**User Endpoints**

1. PUT - *updates an user data in database, if it exists and its username and email are not already taken.*
```public  void updateUser( @PathVariable("userId") Integer userId, @RequestBody RegisterDto userEntity)```
2. DELETE - *deletes a user from the database and its account, if it exists.*
```public void deleteUser(@PathVariable("userId") Integer userId)```
3. GET - *finds all the users present in the database and returns them.*
```public List<UserEntity> getUser()```

**Authentication and registration Endpoints**
1. (POST) REGISTER - *registers a new user in the application if the account doesn't exist*
```public ResponseEntity<String> register(@RequestBody RegisterDto registerDto)```
2. (POST) LOGIN - *login of a user that already has an account in the application*
```public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto)```

**Exercise Endpoints**
1. POST - *adds a new exercise in the application if its name is not already taken*
```public ResponseEntity<String> addExercise(@RequestBody ExerciseDto exerciseDto)```
2. GET - *finds all the exercises present in the database and returns them.*
 ```public List<ExerciseEntity> getExercises()```
3. PUT - *updates an exercise's fields, if it exists*
```public void updateExercise(@PathVariable("exerciseId") Integer exerciseId, @RequestBody ExerciseDto exerciseDto) ```
4. DELETE - *deletes an exercise resource, if it exists*
```public void deleteExercise(@PathVariable("exerciseId") Integer exerciseId)```

**Type Endpoints**

1. POST - *adds a new type in the application if its name is not already taken*
 ```public ResponseEntity<String> addType(@RequestBody TypeDto typeDto)```
2. PUT - *updates a type's fields, if it exists.*
``` public void updateType(@PathVariable("typeId") Integer typeId, @RequestBody TypeDto typeDto)```
3. GET - *finds all the types present in the database and returns them.*
```public List<TypeEntity> getType() ```
4. DELETE - *deletes a type resource, if it exists and it is not assigned to any exercise*
```public void deleteType(@PathVariable("typeId") Integer typeId)```

# Unit Testing
For the most part, unit tests are intended to test a small chunk (or unit) of code. That is usually limited to the code within a function or sometimes extends to some helper functions called from that function. If a unit test is testing code that is dependent on another service or resource, like a database or a network resource, the unit test should “mock” and inject that dependency as to have no actual impact on that external resource. It also limits the focus to just that unit being tested

In order to test Service layer components, I mocked the Repository layer components using the Mockito framework. I did't use the database for Unit testing. I used ***Mockito.when()*** methods to create test stubs. 
Therefor, I have implemented JUnit tests for all the methods from **Service layer** and for the classes that contain additional logic, such as **EmailSenderService**.

**Unit Testing User Service Layer**
To achieve low coupling I created an ***UserServiceInterface*** with CRUD methods. After this, I created an UserService implementation class that implements the UserServiceInterface.
***UserTests Class***
I created a mock of UserRepository using ```@Mock``` and create an EmployeeService instance using the mock EmployeeRepository instance. Also, I used the assertTrue() method to assert the conditions using the AssertJ library.
***
**Unit Testing Authentication Service Layer**
To achieve low coupling I created an ***AuthServiceInterface*** with CRUD methods. After this, I created an AuthService implementation class that implements the AuthServiceInterface.
***AuthTests Class***
I created a mock of UserRepository, RoleRepository, JWTGenerator, PasswordEncoder, AuthenticationManager, ApplicationEventPublisher using ```@Mock``` and created an AuthService instance using the mocks instances. Also, I used the assertTrue() method to assert the conditions using the AssertJ library.
***
**Unit Testing Type Service Layer**
To achieve low coupling I created an ***TypeServiceInterface*** with CRUD methods. After this, I created an TypeService implementation class that implements the TypeServiceInterface.
***TypeTests Class***
I created a mock of ExerciseRepository and TypeRepository using ```@Mock``` and created a TypeService instance using the mock TypeRepository and ExerciseRepository instances. Also, I used the assertTrue() method to assert the conditions using the AssertJ library.
***
**Unit Testing Exercise Service Layer**
To achieve low coupling I created an ***ExerciseServiceInterface*** with CRUD methods. After this, I created an ExerciseService implementation class that implements the ExerciseServiceInterface.
***ExerciseTests Class***
I created a mock of ExerciseRepository and TypeRepository using ```@Mock``` and created an ExerciseService instance using the mock TypeRepository and ExerciseRepository instances. Also, I used the assertTrue() method to assert the conditions using the AssertJ library.

***
**Unit Testing Workout Service Layer**
To achieve low coupling I created a ***WorkoutServiceInterface*** with CRUD methods. After this, I created a WorkoutService implementation class that implements the WorkoutServiceInterface.
***WorkoutTests Class***
I created a mock of WorkoutRepository using ```@Mock``` and create an WorkoutService instance using the mock WorkoutRepository instance. Also, I used the assertTrue() method to assert the conditions using the AssertJ library.
***
**EmailTests Class**
For testing the EmailSenderService I used **GreenMail**. GreenMail is an open source, intuitive and easy-to-use test suite of email servers for testing purposes. GreenMail responds like a regular SMTP server but does not deliver any email, which enables it to be used in real life applications and real test cases. Messages can easily be extracted, verified and modified. 
I created a mock of EmailSender using ```@Mock``` and create an Email instance using the mock instance. Also, I used the assertTrue() method to assert the conditions using the AssertJ library.















