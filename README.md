

# Önálló laboratórium - CsotthonApp
### Introduction
This project was created for my Project Laboratory course at BME (my university). I am scouting at a Hungarian scout team, where I am also leader. Every scout team usually has place where their events can take palce (in Hungarian this place's name is cserkészotthon and in free translation: scout home). Because this place is not our property, we have to clean it, log when someone opened or closed it and something is out of stock indicate it to someone.

We used to do these things on paper that is why I started to create this app. The backend stores the data on a MySQL database and it runs on Spring Boot framework. The forntend uses the React JS libraries but currently not the cleanest code because I started to learn JavaScript, HTML, CSS and React with this project.

The project now can log the closes and openings, the cleanings and the maintenances but I am working on the authentication, authorization and the refactoring.
### Current status
<img src="imgs/01-home.PNG" width="200"> <img src="imgs/02-log.PNG" width="200"> <img src="imgs/04-cleaning2.PNG" width="200">
## Getting Started

### Installing and running the backend

```
mvn install
```

Then

```
mvn spring-boot:run
```

### Installing and running the frontend

Go to the *src/main/webapp* folder, than:
```
npm install
```

Then

```
npm start
```

## Built With
* [Spring Boot](https://spring.io/projects/spring-boot) 
* [React](https://reactjs.org/) 
## Author

 **Stella Tóth-Baranyi**
