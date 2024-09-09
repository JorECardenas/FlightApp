# FlightApp


## Overview

This app is a tool to find flight offers between 2 different airports using the Amadeus API. The app is composed of 2 separate parts, the frontend that uses react and the backend that is made with spring boot. Both of this apps are containerized using docker.

## Technologies used

### Frontend

- Java
- Spring boot
- Gradle
- swagger-codegen


### Backend

- React
- Typescript
- Material UI
- Tailwind CSS


## Getting started

This app uses the [Amadeus API](https://developers.amadeus.com/), so first you need to make an account here in order to create a test application so you can make API calls.

You can see more of this proccess [here](https://developers.amadeus.com/get-started/get-started-with-self-service-apis-335).

When you have your API key and your API secret you need to create an application.properties file in the backend project.

This file goes in the following path:

```
/src/main/resources/application.properties
```

And you need to add the following information:

```java
spring.application.name=flightapp

api.credential.id=<api id>

api.credential.secret=<api secret>

spring.jackson,serialization.write-dates-as-timestamps=false
```

Then to run the app you need the following requirements:

- docker
- docker-compose



When you have installed the requirements you can run the following command from the main folder of the repo:

```sh
docker compose up --build
```

This will start the containers for the backend and frontend.


## Usage

While the conainers are running you can access the app here:
- Frontend: [localhost:3000](http://localhost:3000)
- Backend: [localhost:8080](http://localhost:8080)

## Known Issues

- Amadeus API: Since Amadeus doesn't have the names of every airport sometimes only the IATA code will be shown.
- Docker: Sometimes when running docker an error may occurr when calling the API