package com.mindhue.mindhue.service;

import com.mindhue.mindhue.model.Reflection;
import com.mindhue.mindhue.repository.ReflectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReflectionService {

    private final ReflectionRepository repository;

    public ReflectionService(ReflectionRepository repository) {
        this.repository = repository;
    }

    public Reflection createReflection(Reflection reflection) {
        return repository.save(reflection);
    }

    public List<Reflection> getAllReflections() {
        return repository.findAll();
    }

    public Optional<Reflection> getReflectionById(int id) {
        return repository.findById(id);
    }

    public Reflection updateReflection(int id, Reflection updatedReflection) {
        return repository.findById(id).map(reflection -> {
            reflection.setQuestion(updatedReflection.getQuestion());
            reflection.setAnswer(updatedReflection.getAnswer());
            return repository.save(reflection);
        }).orElse(null);
    }

    public boolean deleteReflection(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}