package com.example.trabalhocasadecoracaodemo.repository;

import com.example.trabalhocasadecoracaodemo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByLogin(String login);

}
