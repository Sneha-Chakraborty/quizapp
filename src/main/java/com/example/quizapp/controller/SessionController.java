package com.example.quizapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.QuizLog;
import com.example.quizapp.service.SessionService;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    // Endpoint to get the user's quiz summary (correct and incorrect submissions)
    @GetMapping("/summary/{sessionId}")
    public ResponseEntity<Map<String, Object>> getQuizSummary(@PathVariable Long sessionId) {
        List<QuizLog> quizLogs = sessionService.getQuizLogsBySessionId(sessionId);
        long correctCount = quizLogs.stream().filter(QuizLog::isCorrect).count();
        long incorrectCount = quizLogs.size() - correctCount;

        return ResponseEntity.ok(Map.of(
                "totalQuestions", quizLogs.size(),
                "correctAnswers", correctCount,
                "incorrectAnswers", incorrectCount,
                "details", quizLogs
        ));
    }
}
