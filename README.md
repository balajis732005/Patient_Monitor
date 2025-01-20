# Bus-Ticket-Reservation-Application

> The Patient Medicine and Appointment Management System is a full-stack web application designed to simplify healthcare management by allowing patients to register, book appointments with doctors, and manage their prescribed medications. 
> The application was developed at [GUVI](https://www.guvi.in/) as part of the Java Full Stack Developer Course.

# 👉 [Click here](https://drive.google.com/file/d/1dxJSINnWaDsL5d4OVVI40xPnkzlVe9K7/view?usp=sharing) to go through the working demo of this application

# Features

- Patients and Doctor authentication and validation 
- Doctor can provide details like  Name, Email, specialization, password
- Doctors only can prescribe medicines to patients
- Patients can register by giving all the details
- Patients can search for doctor and book their appointment

# Technology used 

- Java
- MySQL
- Spring Boot
- Spring data JPA
- Spring Validation
- RESTful api
- Hibernate
- Swagger
- Lombok
- Maven
- Postman
- GitHub

# Modules

- Login Logout Module
- Patient Module
- Doctor Module
- Appointment Module
- Medication Module

# Lessons Learned

- Gain excessive knowledge on application of Java, MySQL and SpringBoot.
- Gain knowledge on creating RESTful API.
- Got to know how to decode the errors and testing.
- Enjoyed the process of learning and creating the application.


# Overview of Our work

## **Login Module** 
![Login Module](https://github.com/pranav13vishal/Patient-Appointment-Application/blob/33b6627dc71c7ece1134cfd0a3f431faf6b35c1b/assets/auth.png)

## **Patient Module** 
![Swagger Module*](https://github.com/pranav13vishal/Patient-Appointment-Application/blob/33b6627dc71c7ece1134cfd0a3f431faf6b35c1b/assets/patient.png)

## **Doctor Module**
![User Module](https://github.com/pranav13vishal/Patient-Appointment-Application/blob/33b6627dc71c7ece1134cfd0a3f431faf6b35c1b/assets/doctor.png)

## **Appointment Module**
![Admin Module](https://github.com/pranav13vishal/Patient-Appointment-Application/blob/33b6627dc71c7ece1134cfd0a3f431faf6b35c1b/assets/appointment.png)

## **Medication Module** 
![Home Module*](https://github.com/pranav13vishal/Patient-Appointment-Application/blob/33b6627dc71c7ece1134cfd0a3f431faf6b35c1b/assets/medication.png)



# How To Run Our Project In Your Machine

1. Clone our Project into your system
    - Go to the folder location you want to clone
    - Open terminal 
    - Run command ``` git clone https://github.com/pranav13vishal/Patient-Appointment-Application.git```
2. Open your preferred Integrated Development Environment (IDE) such as Spring Tool Suite (STS) or IntelliJ IDEA.
3. Import the cloned project into your IDE:
   - In IntelliJ IDEA, click on "File" in the top menu, then select "Open"
4. Select the project directory where you cloned the repository and click "OK" or "Open" to import the project.
5. You can run this project with MySQL db 
    -Update the username and password as per your local database config.
```
    spring.datasource.url=jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME
    spring.datasource.username=YOUR_DATABASE_USERNAME
    spring.datasource.password=YOUR_DATABASE_PASSWORD
```
6. Build the project and run 
7. To access database
    - For MySQL, you can use ```MySQL Workbench``` as shown in explanation video
8. Open Swagger UI ```http://localhost:8081/swagger-ui/#/``` and execute the end points as in explanation video
    - comment all the clases under the controller
9. To view the thymleaf pages run the application and go to ```http://localhost:8081/``` 
    - comment all the clases under the controllerRestApi       

# THANK YOU EVERYONE FOR VISITING OUR PROJECT




