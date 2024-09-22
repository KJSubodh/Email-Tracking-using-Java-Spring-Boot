Email Sending using REST API with Spring Boot


Overview


This project is a comprehensive Spring Boot application designed for sending emails via a REST API. Developed using Spring Boot and Maven, it provides a robust solution for managing email communications. The application accepts POST requests to send emails and supports interaction through tools such as HTTPie, Postman, or cURL.


Features
Email Sending: Easily send emails using the REST API.


Database Integration: Automatically updates a MySQL database with email details, including:


Time Sent: Timestamp of when the email was dispatched.


Delivery Status: Information on whether the email was successfully delivered.


Subject: The subject line of the email.


Spring Boot Starter Dependencies: Utilizes spring-boot-starter-data-jpa for data access, spring-boot-starter-mail for email functionality, and spring-boot-starter-web for building web applications.


Database Connection: Uses mysql-connector-j to connect to MySQL for runtime database operations.


Testing: Includes spring-boot-starter-test for unit and integration testing to ensure code quality.


Getting Started


Clone the Repository : git clone https://github.com/KJSubodh/Email-Sending-using-REST-API-using-Spring-Boot.git


Navigate to the Project Directory: cd Email-Sending-using-REST-API-using-Spring-Boot


Build the Project :mvn clean install


Run the Application :mvn spring-boot:run


Usage
Send POST requests to the API endpoint to send emails. Examples of tools you can use:

HTTPie: Send email requests using HTTPie for a user-friendly command-line interface.


Postman: Use Postman to craft and send requests with a graphical interface.


cURL: Perform API requests using cURL from the command line.


Database


The application integrates with a MySQL database to manage email records. 


The database is automatically updated with:


Time Sent: When the email was sent.


Delivery Status: Whether the email was delivered successfully.


Subject: The subject line of the email.


Dependencies


Spring Boot Starter Data JPA: For working with databases and ORM.


Spring Boot Starter Mail: For email sending capabilities.


Spring Boot Starter Web: For creating web applications.


MySQL Connector/J: For MySQL database connectivity.


Spring Boot Starter Test: For testing the application.

