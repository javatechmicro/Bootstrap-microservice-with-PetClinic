# Bootstrap Microservices project with the Pet Clinic Project Example

This project is aim to understand microservices architecture using Pet Clinic project Example.
# Introduction 
The purpose of this Project to create framework for bootstrap any microservices project based on java  
# Challenges
Some Common challenges have been addressed in this project and some needs to do:
Log management
Service discovery
API gateway
Centralized Configuration
Distributed authentication
Distributed Event
Applications management
Infrastructure management
Continuous deploy

# Tools
Service discovery server
load balance server
configuration server
log management
application management
Swagger
Event broker
Continuous deploy server

# Patterns, Tools and Technologies
Spring Boot, Spring Data, Spring Cloud Eureka, Load Balancing with Ribbon, Declarative REST Clients with Feign, Software Circuit Breakers with Hystrix, Monitoring using Hystrix dashboard, Administrating using Spring admin, Log management with Elasticsearch, Logstash and Kibana (ELK), Server load balancing with Nginx, Infrastructure management with Docker-compose, Security with Spring Security OAuth, Oauth2 with JWT, Aspect Oriented Programing, Distributed events with Kafka, Spring Stream, Maven Multimodule project, Event Sourcing, REST, Web Sockets, Continuous deploy with Jenkins, and everything developed using Java

# Use case
This application will help to create online reminder for the Pet health checkup. Once user will create reminder for Pet health checkup then automatic mail would be triggered in user mail box.

User can create account through user-service
remainder-service will help to create reminder and will send enter through kafka to send email.
Mailservice will keep listening event form Kafka server and will send email to user.
Customer can creat appointment, find the vet specility vet specialists etc
# Setup in your Local system
Install your favorite IDE
Checkout this project and import as Maven project
Start individual service

# Some Services URL
remainder-service
http://localhost:8015/todos (POST method: to add reminder)
 {        "id": 1122,        "caption": "Test 5",        "userEmail": "test5@gmail.com",        "description": "testing to save data",        "createdat": null,        "priority": 1,        "status": "PENDING",        "version": 0,        "valid": true    }
mailservice
http://localhost:8020/emails (Get Mothod:To get all email which needs to listen from the Kafka listener)
user-service
http://localhost:8016/accounts (Get Mothod: to list all accounts)
http://localhost:8016/accounts (Post Mothod: to add accounts)
{"id":233,"password":"1234","name":"abd lindo","email":"abce@gmail.com","version":0}

# Needs to do
Aggregate Services into a Single Swagger
Fix docker issue
Add Junit framework
Deploy on AWS
Create Web UI
Fix Oauth issue
Configure Kibana 
