## 2 Semester Hairdresser Project

## Project Requirements

### Hard Requirements:
* Employees must be able to log in and out of the system.
* It must be possible to create and delete appointments.
* It must be possible to look up appointments and make changes to them.
* Appointments must not conflict - an employee can only serve one customer at a time.
* The appointment must include the treatment and how long the treatment takes.
* The system must store data in a structured and permanent manner.
* Tax authorities require that appointments be kept in the system for 5 years as documentation - an appointment can be canceled but must remain in the system as canceled. After 5 years, appointments should be automatically deleted at appropriate intervals - for example, once a month or once a year. Consider how this can be solved - if possible, construct the solution.

### Soft Requirements:
* The user interface may preferably be graphical.
* Employees' and customers' data should be secured - what can be done in this regard?
* Customers could potentially receive receipts or notifications via email or SMS - how could this be implemented?
* Eventually, customers should be able to book appointments themselves - this could be online and/or via an app. How can the system be designed to make this possible?
* Monica might also like to follow along on her computer and/or phone.

### Educational (Academic) Requirements:
* Agile system development tools must be used, and UML tools should be used in the project.
* The system should primarily be programmed in Java.



## Detailed Method Explanations

### Overview

This section aims to elaborate on the architecture, methods, and functions employed in this project. By dissecting the implementation down to each significant word, we intend to provide a deep understanding of our development choices, promoting a learning environment and fostering professional growth.

### Key Architectural Components

- **Model-View-Controller (MVC) Pattern**: Our application leverages the MVC pattern to separate data access, business logic, and the user interface. This separation enhances modularity, facilitates independent development and testing, and improves maintainability.

- **Data Access Object (DAO) Pattern**: We abstract and encapsulate all access to the data source using the DAO pattern. This approach manages the connection with the data source to obtain and store data, offering a unified interface for data operations.

- **Service Layer**: Surrounding the DAOs with a service layer provides a transactional boundary, encapsulating business logic and transaction management. This layer is where complex business rules and transaction control flow are implemented.

### Method and Function Explanations

#### DAO Layer

- **addCustomer(Customer customer)**: Adds a new customer to the database, illustrating prepared statements' role in preventing SQL injection and ensuring data integrity and security.
  
  - *Prepared Statements*: These are used to execute SQL statements with high efficiency and security, safeguarding against SQL injection.

- **getCustomerById(int id)**: Fetches a customer based on their ID, showcasing efficient data retrieval and robust error handling mechanisms.
  
  - *Error Handling*: Demonstrates the application's capability to manage and respond to database access errors gracefully.

#### Service Layer

- **createNewAppointment(details)**: Manages the creation of new appointments, validating input data, utilizing DAO methods, and enforcing business rules.
  
  - *Business Rules*: This involves applying the core logic and constraints of the application, such as validating appointment times and ensuring compliance with business policies.

#### Utility Classes

- **DatabaseConnection**: Manages database connections centrally, highlighting connection pooling's role in enhancing performance and scalability.
  
  - *Connection Pooling*: Describes the practice of maintaining a pool of database connections that can be reused, minimizing the overhead associated with opening new connections.

#### Logging

- **addLogEntry(Log log)**: Facilitates audit logging by documenting significant actions within the application, which is critical for security, debugging, and compliance.
  
  - *Audit Logging*: Records systematic events crucial for ensuring accountability and traceability in applications.

### Conclusion

Our project is constructed on solid design patterns and industry best practices, aiming for a robust, scalable, and maintainable outcome. The architectural and methodological decisions are tailored to build a secure and efficient application capable of adapting to evolving requirements while ensuring a clear understanding and easy navigation for developers and stakeholders alike.

## SQL 

### Automatically deletion

In our sql database, we have a procedure called "delete_old_data()" this command can be called directly "CALL delete_old_data()" and it will delete any customer that was created 5 years ago, as well as all child objects using the id

this is used in a Mysql event schedule, that runs once a day. 