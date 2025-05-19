package com.mindhue.mindhue.service;

import com.mindhue.mindhue.model.Questions;
import com.mindhue.mindhue.repository.QuestionsRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    private final QuestionsRepository questionsRepository;

    public QuestionsService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    public Optional<Questions> getQuestionById(int id) {
        return questionsRepository.findById(id);
    }

    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }
}