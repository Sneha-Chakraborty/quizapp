package com.example.quizapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.service.QuizService;
import com.example.quizapp.service.SessionService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private SessionService sessionService;

    // Endpoint to get a random multiple-choice question
    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion(
        @RequestParam String category,
        @RequestParam String difficulty) {
            Question question = quizService.getRandomQuestion(category, difficulty);
            return ResponseEntity.ok(question);
        }


    // Endpoint to submit an answer
    @PostMapping("/submit-answer/{sessionId}/{questionId}")
    public ResponseEntity<Map<String, Object>> submitAnswer(
            @PathVariable Long sessionId,
            @PathVariable Long questionId,
            @RequestParam String selectedOption) {

        // Fetch the QuizSession using sessionId
        QuizSession quizSession = sessionService.getSessionById(sessionId);

        // Call submitAnswer with the fetched QuizSession
        boolean isCorrect = quizService.submitAnswer(quizSession, questionId, selectedOption);

        return ResponseEntity.ok(Map.of(
                "correct", isCorrect,
                "message", isCorrect ? "Correct answer!" : "Wrong answer!"
        ));
    }

}
