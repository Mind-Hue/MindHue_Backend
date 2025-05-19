package com.mindhue.mindhue.repository;

import com.mindhue.mindhue.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
}