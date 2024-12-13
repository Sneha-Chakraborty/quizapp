package com.example.quizapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.model.QuizLog;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.repository.QuizLogRepository;
import com.example.quizapp.repository.QuizSessionRepository;

@Service
public class SessionService {

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private QuizLogRepository quizLogRepository;

    public QuizSession startNewSession(Long userId) {
        QuizSession session = new QuizSession();
        session.setUserId(userId);
        session.setStartTime(LocalDateTime.now());
        session.setLastActivityTime(LocalDateTime.now());
        session.setActive(true);
        return quizSessionRepository.save(session);
    }

    public void endSession(Long sessionId) {
        Optional<QuizSession> sessionOpt = quizSessionRepository.findById(sessionId);
        if (sessionOpt.isEmpty()) {
            throw new RuntimeException("Invalid session ID");
        }
        QuizSession session = sessionOpt.get();
        session.setActive(false);
        quizSessionRepository.save(session);
    }

    public QuizSession getSessionById(Long sessionId) {
        return quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Invalid session ID"));
    }    

    public List<QuizSession> getActiveSessions(Long userId) {
        return quizSessionRepository.findByUserIdAndIsActive(userId, true);
    }

    public List<QuizLog> getQuizLogsBySessionId(Long sessionId) {
        return quizLogRepository.findByQuizSessionId(sessionId);
    }
}
