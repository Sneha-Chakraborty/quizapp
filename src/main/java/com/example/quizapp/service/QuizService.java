package com.example.quizapp.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizLog;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizLogRepository;


@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizLogRepository quizLogRepository;

    public Question getRandomQuestion(String category, String difficulty) {
        List<Question> questions = questionRepository.findAll(); // Filter based on category and difficulty if needed.
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public boolean submitAnswer(QuizSession quizSession, Long questionId, String submittedAnswer) {
        Optional<Question> questionOpt = questionRepository.findById(questionId);
        if (questionOpt.isEmpty()) {
            throw new RuntimeException("Invalid question ID");
        }
        Question question = questionOpt.get();
        int answer = Integer.parseInt(submittedAnswer);  // Parse directly to int
        boolean isCorrect = question.getCorrectAnswers().contains(answer);  // Directly compare with int
        QuizLog log = new QuizLog(questionId, isCorrect, submittedAnswer, quizSession);
        quizLogRepository.save(log);
        return isCorrect;
    }
        

    public List<QuizLog> getQuizLogs(Long quizSessionId) {
        return quizLogRepository.findByQuizSessionId(quizSessionId);
    }
}
