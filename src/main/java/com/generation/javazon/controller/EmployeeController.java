package com.generation.javazon.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javazon.entities.Employee;
import com.generation.javazon.repositories.EmployeeRepository;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    EmployeeRepository repo;

    @GetMapping("/employee")
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Optional<Employee> op = repo.findById(id);

        if (op.isPresent())
            return new ResponseEntity<Employee>(op.get(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Non esistono Employee con id " + id, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employee/{id}")
    public ResponseEntity<?> insert(@RequestBody Employee entity) {
        return new ResponseEntity<Employee>(repo.save(entity), HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Employee entity) {
        Optional<Employee> op = repo.findById(id);
        if (op.isPresent()) {
            entity.setId(id);

            return new ResponseEntity<Employee>(repo.save(entity), HttpStatus.OK);
        } else
            return new ResponseEntity<String>("Non esistono Employee con id " + id,
                    HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Employee> op = repo.findById(id);
        repo.deleteById(id);
        if (op.isPresent()) {

            return new ResponseEntity<String>("", HttpStatus.OK);
        } else
            return new ResponseEntity<String>("No Employee with id " + id, HttpStatus.NOT_FOUND);
    }
}
