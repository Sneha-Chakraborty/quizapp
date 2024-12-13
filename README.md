# Getting Started

## Overview
Create api endpoints for a quiz app in Spring boot. Using the apis, a user can do the following:-
- Start a new quiz session.
- Get a random multiple choice question from a set of questions in database.
- Submit an answer and
- Get the total questions answered by the user with details on correct and incorrect submission.

## Features

Database Schema:
- Users Table: Stores user details.
- Questions Table: Includes category, difficulty, text, options, and multiple correct answers.
- Sessions Table: Tracks active sessions, start time, and user.
- Logs Table: Captures user responses, correct/incorrect status, and timestamps.

API Endpoints:
- POST /auth/login: Logs in a user and returns a token.
- POST /quiz/start: Starts a new session and returns session details.
- GET /quiz/question: Fetches a random question for the current session.
- POST /quiz/answer: Submits an answer for the current question.
- GET /quiz/summary: Retrieves the summary of the session (total, correct, incorrect).

## Dependencies used

- Spring Web, Spring Data JPA, H2 Database, Spring Boot DevTools as present in pom.xml.


## How to run the Application

- Clone this repository : `https://github.com/Sneha-Chakraborty/quizapp.git`
- Open it in VS Code by typing `code .` in terminal.
- Navigate to the project directory in the VS Code terminal.
- Use code `mvn spring-boot:run` to run the Springboot Application.
- Once the application starts, it will be available on the default port 8080. `http://localhost:8080`
- You can test the application endpoints using Postman: For sending HTTP requests.
- H2 Console: Visit http://localhost:8080/h2-console to view the database.

-----------------------------------------------------------------------------------------------------------