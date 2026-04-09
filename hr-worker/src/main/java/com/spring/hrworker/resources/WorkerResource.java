package com.spring.hrworker.resources;

import com.spring.hrworker.entities.Worker;
import com.spring.hrworker.repositories.WorkerRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {


    private final WorkerRepository repository;

    public WorkerResource(WorkerRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        @Nullable Worker worker = repository.findById(id).get();
        return ResponseEntity.ok(worker);
    }
}
