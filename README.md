# InfoCompany

## Project description.

***This project demonstrates usage of Java technologies to create web application.***
The application displays the result of the queries: find all employees, create the employee and delete employee by ID.
`Data Access Objects` - a design pattern that defines the data access mechanism.
Dao layer retrieves data from MySQL database tables through requests from the file using JDBC. 
Added `CRUD Concept Application` (Create, Read, Update, Delete), tested on `Mysql`, version 5.1.47.
Data output takes place through the `JavaServer Pages`.
- Servlet "AllEmployees"call reference:
<http://localhost:8080/list>
- Servlet "CreateEmployee"call reference:
<http://localhost:8080/add>
- Servlet "DeleteEmployee"call reference:
<http://localhost:8080/remove>
 ***
## Technologies used in the project:
- `Java core`, jdk 1.8
- `POJO`
- `DAO` (Data Access Object)
- Service Layer between Servlet and DAO 
- `Servlet API`, version 4.0
- `JavaServer Pages API`, version 2.3.1, `HTML`
- Database: `Mysql`, version 5.1.47
- `JDBC` (Java DataBase Connectivity)
- Property package with `CRUD Concept Application` (Create, Read, Delete)
- `Validation API`, version 2.0.1.Final
- `Lombok`, version 1.18.2
- Tools: git, maven
 ***
## Installation instructions:
- Clone repository
- Run mvn **clean install**
- Used database server - **mysql**
- Driver - **com.mysql.jdbc.Driver**
- Url - <jdbc:mysql://localhost:3306/info?useSSL=false&createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8&characterSetResults=utf-8&autoReconnect=true>
- Run the script to create a database