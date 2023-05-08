# School-Management-System-Lampnet Test

This is a school management system 

Features: 
1. A microservice application that breaks down all the core module of school management system 
into microservices. 
2. A CRUD services on each of the respective micro services 
3. A RESTFUL API controller implementing only GET/POST requests 
4. A swagger interface for a API documentation 
5. An admin profile for teacher and super admin 
6. A student profile 

Overview 
A school management system can be defined as a platform designed to enable the efficient running of 
your institution through digitization and automation of various academic and administrative operations. 


## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
*Spring Security
*Swagger

## Modules

* Course
* Student 
* Teacher 


## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties] file.  

## Testing with swagger
* After starting the project, open your browser and browse http://localhost:8080/swagger
       

## API Root Endpoint

`https://localhost:8080/


## API  Endpoint

### Teacher

* `POST /register/teacher` : Register teacher
* `GET /login/teacher` : Loin teacher
* `GET /teacher` : Getting teacher with id
* `PUT /update/customer` : Updates logged in teacher
* `DELETE /customer` : Deletes registered teacher wih id


### Student

* `GET /{id}/student` : Gets student with id
* POST /login/student : login student
* `PUT /{id}/updatestudent` : Updates studentinfo
* `DELETE /product/{id}` : Deletes student with id


### Course 

* `GET /course` : Get course
* `POST /cart/add` : Add item to Cart
* `DELETE /{id}/course` : Remove course
