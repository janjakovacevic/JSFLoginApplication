<img align="right" width="450" height="300" src="https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/sparta.jpg">

# **JSF Login App**

![java_ee_badge](https://img.shields.io/badge/-Java%20EE-orange?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor) 
![html_badge](https://img.shields.io/badge/-HTML-blue?style=for-the-badge&logo=appveyor)
![CSS](https://img.shields.io/badge/-CSS-brightgreen?style=for-the-badge&logo=appveyor)
![bootstrap](https://img.shields.io/badge/-Bootstrap-purple?style=for-the-badge&logo=appveyor)
![databases](https://img.shields.io/badge/-Databases-red?style=for-the-badge&logo=appveyor)
![security](https://img.shields.io/badge/-Security-lightgrey?style=for-the-badge&logo=appveyor)
![glassfish](https://img.shields.io/badge/-Glassfish-black?style=for-the-badge&logo=appveyor)

### **Table Of Contents**
  * [**Overview**](#overview)
  * [**Technology**](#technology)
  * [**Screenshots**](#screenshots)
      - [Login Page](#login-page)
      - [Welcome Page](#welcome-page)
      - [Admin Page](#admin-page)
      - [Search Page](#search-page)
      - [Registration Page](#registration-page)
      - [Permissions Page](#permissions-page)
      - [Logout](#logout)
  * [**Future Work**](#future-work)

## **Overview**
- Simple login application with a reasonable way of handling invalid logins
- User details are kept in a database
- Some aspects of the application are restricted
    - e.g. accessing resources folder
- Users may have different level of access (permissions/roles)
- Sections of the website are view-able only by those with an admin role
- An admin is able to add new users to the database and assign them a role
- An admin is able to perform a search
- An admin is able to change level of access as they deem fit

## **Technology**
- Java EE 
    - Provided a vast array of web components 
- Payara 
    - Application platform for Jakarta EE (Java EE) apps (based on Glassfish)
- CDI 
    - Context and Dependency Injection as a standard framework as part of Java EE for creating containers and injecting dependencies (Java Beans)
- JSF 
    - Java Server Faces as a web application framework that uses facelets
    - Allowed for building XHTML webpages, templates, managing validation and navigation as well as communication with Java Beans (CDI)
- JPA 
    - Java Persistence API as a collection of classes and methods to persistently store the data into a database
    - A bridge between object models (Java program) and relational models (database program)
- MySQL 
    - As a database
- Security 
    - Authentication, identity store (for credentials for users) and security context APIs
    - Defined via annotations or constraints in web.xml
    - Provided by Soteria (in Glassfish)
- Bootstrap
    - Open-source HTML, CSS, and JavaScript framework used for styling views

## **Screenshots**

### Login Page
- Upon starting the application, the user will land on the login page were they are then prompted to enter their credentials 
(`username` and `password`) in order to log in. 

![login](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/login.png)

- In case invalid credentials are entered, the user will be notified and 
prompted again. 

![login-invalid-credentials](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/login-invalid-credntials.png)

- The user will also be notified in case one or both fields are left empty.

![login-required](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/login-required.png)

### Welcome Page

- Upon successful login, the user will then land on the welcome page.

![welcome](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/welcome.png)

### Admin Page

- Accessing further pages requires `admin` status. In the case where a user does not have persmissions of an admin, but still
attempt to access the admin page, they will be sent to a 403 Forbidden Error Page.

![403](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/403-forbidden.png)

- If a user is, however, an `admin` and they have appropriate permissions - they will be sent to the Admin Page where they
can choose between 4 options:
- `search` for user
- `registration` of a new user
- manage `permissions`
- `logout`

![admin](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/admin.png)

### Search Page

- By selecting the `search` option from admin page, the `admin` is sent to the search page where they can perform a search in 2 different ways:
    - by `userID`
    - by `username`

![search](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/search.png)

- If an invalid input is encountered or no user with the specified criteria exists, the `admin` is notified.

![search-failure](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/search-failure.png)

- If a user was found, and the search was successful, the `admin` is then sent to the next page that displays the search results including:
    - `userID`
    - `username`
    - `first name`
    - `last name`
    - `role`

![search-success](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/search-success.png)

- Upon performing the search, the `admin` can then choose to:
     - perform another `search`
     - return to the `admin page`
     - `logout`
 
### Registration Page

- By selecting `registration` option from admin page, the `admin` is sent to the registration page where they, as an admin, can register
a new user. They do so by populating all the required fields in the registration form and assigning appropriate permission/role (`ADMIN` or `USER`).

![registration](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/registration.png)

- If invalid input is detected, the `admin` will be notified and prompted to input correct information again.

![registration-failure](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/registration-failure.png)

- If all field inputs are valid, and the registration was successful, the `admin` is then sent to the next page that displays the information of 
the newly registered user.

![registration-success](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/registration-success.png)

- In case when an `admin` tries to create a user with an already existing username, registration won't be allowed. The `admin` will be notified and prompted
to choose a different username.

![registration-duplicate](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/registration-duplicate.png)

- Upon performing the registration, the `admin` can then choose to:
     - perform another `registration`
     - return to the `admin page`
     - `logout`

### Permissions Page

- By selecting the `permissions` option from admin page, the user is sent to the permissions page where they can change access permissions for any user.
User is asked to select the user they want to change the permission for as well as the permission level they would like to assign them.

![permissions](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/permissions.png)

- Upon updating the permission for the selected user, they user is sent to the next page confirming the update was successful.

![permissions-success](https://github.com/janjakovacevic/SpartaGlobalJavaDevCourse/blob/Eng72/12-Labs/01-JSFLoginApp/JSFLoginApplication/program%20screenshots/permission-success.png)

- Upon performing the registration, the `admin` can then choose to:
     - manage another `permission`
     - return to the `admin page`
     - `logout`

### Logout

- When the user chooses to logout, the session ends and they are sent back to the login page.

## **Future Work**
Possible improvments for `JSF Login App 2.0`
 - Add restrictions of type of input allowed in the registration form
 - Allow admin to update the user information
 - Add more search options
 - Create a more user-friendly front end
