
package com.example.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.QuizLog;

@Repository
public interface QuizLogRepository extends JpaRepository<QuizLog, Long> {
    List<QuizLog> findByQuizSessionId(Long quizSessionId);
}
