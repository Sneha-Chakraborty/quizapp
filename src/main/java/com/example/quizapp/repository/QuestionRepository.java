package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
