package com.example.trabalhocasadecoracaodemo.controller;


import com.example.trabalhocasadecoracaodemo.model.Produto;
import com.example.trabalhocasadecoracaodemo.repository.ProdutoRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoRespository produtoRespository;

    public ProdutoController(ProdutoRespository produtoRespository){
        this.produtoRespository = produtoRespository;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Produto>> listarTodos(){
        return ResponseEntity.ok(produtoRespository.findAll());
    }
    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoRespository.save(produto));
    }
    @GetMapping("/listar{id}")
    public ResponseEntity<Optional<Produto>> listarPorId(@RequestParam Integer id){
        return ResponseEntity.ok(produtoRespository.findById(id));
    }

}
