package com.mindhue.mindhue.controller;

import com.mindhue.mindhue.model.Reflection;
import com.mindhue.mindhue.service.ReflectionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/reflections")
public class ReflectionController {

    private final ReflectionService service;

    public ReflectionController(ReflectionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createReflection(@Valid @RequestBody Reflection reflection) {
        return service.createReflection(reflection);
    }

    @GetMapping
    public ResponseEntity<Object> getReflectionsByLogId(@RequestParam int logId) {
        return service.getReflectionsByLogId(logId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reflection> getReflectionById(@PathVariable int id) {
        return service.getReflectionById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reflection> updateReflection(@PathVariable int id, @Valid @RequestBody Reflection reflection) {
        return service.updateReflection(id, reflection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReflection(@PathVariable int id) {
        return service.deleteReflection(id);
    }
}