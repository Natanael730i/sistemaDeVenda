package com.example.trabalhocasadecoracaodemo.controller;

import com.example.trabalhocasadecoracaodemo.model.Usuario;
import com.example.trabalhocasadecoracaodemo.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/listarTodos")
    public ResponseEntity<List<Usuario>> listarTodos(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(repository.save(usuario));
    }
}
