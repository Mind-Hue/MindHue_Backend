package com.mindhue.mindhue.controller;

import com.mindhue.mindhue.model.Reflection;
import com.mindhue.mindhue.service.ReflectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") 
@RequestMapping("/api/v1/reflections")
public class ReflectionController {

    private final ReflectionService service;

    public ReflectionController(ReflectionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Reflection> createReflection(@Valid @RequestBody Reflection reflection) {
        Reflection createdReflection = service.createReflection(reflection);
        return ResponseEntity.ok(createdReflection);
    }

    @GetMapping
    public ResponseEntity<List<Reflection>> getAllReflections() {
        return ResponseEntity.ok(service.getAllReflections());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reflection> getReflectionById(@PathVariable int id) {
        return service.getReflectionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reflection> updateReflection(@PathVariable int id, @Valid @RequestBody Reflection reflection) {
        Reflection updated = service.updateReflection(id, reflection);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReflection(@PathVariable int id) {
        if (service.deleteReflection(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}