
<img align="right" width="250" height="250" src="https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/logo.png">

# **Employees Data Migraton**
![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor) 
![sql_badge](https://img.shields.io/badge/-SQL-blue?style=for-the-badge&logo=appveyor)
![databases](https://img.shields.io/badge/-Databases-red?style=for-the-badge&logo=appveyor)
![threads](https://img.shields.io/badge/-Multithreading-brightgreen?style=for-the-badge&logo=appveyor)
![performance](https://img.shields.io/badge/-Performance-orange?style=for-the-badge&logo=appveyor)


### **Table Of Contents**
  * [**Overview**](#overview)
  * [**Technology**](#technology)
  * [**Observations**](#observations)
  * [**Screenshots**](#screenshots)
      - [Initial Prompt](#initial-prompt)
      - [Initial Count](#initial-count)
      - [Select Employee](#select-employee)
      - [Delete Employee](#delete-employee)
      - [Count](#count)
      - [Select Non-Existing Employee](#select-non-existing-employee)
      - [Exit](#exit)
  * [**Future Work**](#future-work)

## **Overview**
- Reads a CSV file containing employee data of several thousand rows
- Populate a MySQL database running on the local server
- The employee data is validated against multiple validation standards in order to then populate the database
- Each entry of the CSV file stores the following information:
  - Employee ID
  - Title
  - First Name
  - Middle Initial
  - Last Name
  - Gender
  - Email Address
  - Date of Birth
  - Date of Joining the Company
  - Salary
- All invalid or duplicate data is stored in separate CSV files that can be found inside resources directory
- Once the database is populated with CSV entries, the user can then manipulate the database from the command line and perform operations such as 
  - Selecting an employee by ID
  - Deleting an employee by ID
  - Getting a current number of employees in the database
- The process of writing a CSV file to the program and populating the database is measured for performance speed
- The performance of the manipulations performed on the database is also measured and displayed upon completion

## **Technology**
- MySQL
  - As a database
- Threading
  - Allowed for the persistence of data to occur in a significantly faster manner
- Reading/Writing
  - Making use of the BufferedReader in combination with FileReader
- Logging
  - Duplicate and invalid records are stored into an external file so they can be manually reviewed at a later point
- DTO: Data Transfer Object
  - Used to encapsulate the data and reduce the number of calls to the database (Employee Class)
- DAO: Data Access Object
  - Provides CRUD operations without exposing details about the database

## **Observations**

During the development of this project, multiple ways were found to go about writing data to the database once it has been stored inside the DTO. All those ways involve a combination of one or more of the following commands:
- `setAutoCommit`: If a connection is in auto-commit mode, then all its SQL statements will be executed and committed as individual transactions. Otherwise, its SQL statements are grouped into transactions that are terminated by a call to either the method commit
- `executeUpdate`: Executes the given SQL statement and signals the driver with the given flag about whether the auto-generated keys produced by the object should be made available for retrieval
- `addBatch`: Adds the given SQL command to the current list of commands for this object. The commands in this list are executed as a batch by calling the method executeBatch
- `tracker`: counter variable that allows executeBatch to be called only when the batch reaches certain size

The performance of the combination of the above commands for both threaded and non-threaded versions of this program is displayed in the table below from fastest to the slowest method.

![employees times table](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/employees_times_table.png)

It has proven that the most efficient way of writing the data to the database involves switching the autoCommit off, batching the added lines and, in doing so, minimising the number of calls made to the database. This speeds up the performance significantly. Adding threading on top of that further cuts down on the time taken to transfer all the data.

## **Screenshots** 
Example: `Deleting the employee with EmployeeID = 1998`

### Initial Prompt
- When first run - the program will read the CSV file and write it to the database. It will then display the time it took to complete this operation as well as the 
`Start Menu` allowing the user to choose their next course of action:

![initial prompt](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/initial%20prompt.png)

### Initial Count
- In this demo, a CSV file of 65,500 lines (including the header line) is used. The user can check `how many valid entires` have been written to the database before deleting any of them, by choosing option 3:

![count - first time](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/start%20check%20count.png)

- The user can see that this file had no duplicate or invalid values. In case there were any `duplicate or invalid values`, CSV files would be created and the values 
would be written to them - they could be checked in the `resources directory`.

### Select Employee
- User can now choose to `look for an employee` using their employee ID. Here - an employee with the ID of 1998. Upon completion of the operation, the program displays the time (in milliseconds) it took to find the specified employee's details as well the details themselves in order in which they are listed above:

![select - first time](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/select%20an%20employee.png)

### Delete Employee
- Upon completion of an operation, user is yet again prompted with the Start Menu. They can now choose to `delete the employee` with employee ID of 1998. Upon completion of the operation, the program displays the time (in milliseconds) it took to delete the specified employee's details as well the confirmation message: 

![delete](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/delete%20an%20employee.png)

### Count
- User is once again prompted with the Start Menu. They can now `verify` the employee has indeed been removed from the database - in 2 ways. `First` they can check the number of all the employees currently stored in the database and compare it to the number he previously had:

![count - second time](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/check%20count%20after%20deletion.png)

### Select Non-Existing Employee
- `Second` way of ensuring the employee has been deleted is by trying to select the same employee once again:

![select - second time](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/try%20selecting%20the%20deleted%20employee.png)

### Exit
- Now that the user has successfully deleted a user from the database, they can choose to perform more operations or simply `exit the program`. By choosing option 4, the program exits.
![exit](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%205%20-%20Java%20Week%203/DataMigrationProject/program%20screenshots/exit.png)

## **Future Work**
Possible improvments for `Data Migration 2.0`
  - Update employee's details
  - Add a new employee
  - Add a front end
