package com.example.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.QuizSession;
import com.example.quizapp.service.AuthService;
import com.example.quizapp.service.SessionService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private SessionService sessionService;

    // Endpoint to start a new quiz session for a user
    @PostMapping("/start-quiz/{userId}")
    public ResponseEntity<QuizSession> startQuiz(@PathVariable Long userId) {
        if (!authService.isUserValid(userId)) { // Example usage
            return ResponseEntity.status(403).build(); // Forbidden if user is invalid
        }
        QuizSession newSession = sessionService.startNewSession(userId);
        return ResponseEntity.ok(newSession);
    }
}
