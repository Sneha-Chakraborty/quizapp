package com.example.quizapp.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.User;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.UserRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public DataSeeder(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed sample questions
        questionRepository.saveAll(List.of(
            new Question("Science", "easy", "What is the chemical symbol for water?", List.of("H2O", "O2", "CO2", "HO"), List.of(0)),
            new Question("Math", "medium", "What is 12 * 12?", List.of("144", "121", "112", "124"), List.of(0)),
            new Question("History", "hard", "Who was the first President of the United States?", List.of("George Washington", "Abraham Lincoln", "Thomas Jefferson", "John Adams"), List.of(0))
        ));

        // Seed a sample user
        userRepository.save(new User("test_user", "password123"));
    }
}
