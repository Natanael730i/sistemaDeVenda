package com.example.trabalhocasadecoracaodemo.controller;

import com.example.trabalhocasadecoracaodemo.model.*;
import com.example.trabalhocasadecoracaodemo.repository.CompraRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compra")
public class CompraController {

    private final CompraRepository repository;

    public CompraController(CompraRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Compra>> listarTodos(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Compra> salvar(@RequestBody Compra compra){
        return ResponseEntity.ok(repository.save(compra));
    }
}
