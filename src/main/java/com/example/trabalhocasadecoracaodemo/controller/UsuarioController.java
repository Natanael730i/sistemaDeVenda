package com.example.trabalhocasadecoracaodemo.controller;

import com.example.trabalhocasadecoracaodemo.model.Usuario;
import com.example.trabalhocasadecoracaodemo.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;

    private final PasswordEncoder enconder;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder enconder) {
        this.repository = repository;
        this.enconder = enconder;
    }


    @GetMapping("/listarTodos")
    public ResponseEntity<List<Usuario>> listarTodos(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        usuario.setSenha(enconder.encode(usuario.getSenha()));
        return ResponseEntity.ok(repository.save(usuario));
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String senha){

        Optional<Usuario> optUsuario = repository.findByLogin(login);
        if(optUsuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Usuario usuario = optUsuario.get();
        boolean valid = enconder.matches(senha, usuario.getSenha());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(valid);
    }
}
