package com.example.trabalhocasadecoracaodemo.service;

import com.example.trabalhocasadecoracaodemo.data.DetalheUsuarioData;
import com.example.trabalhocasadecoracaodemo.model.Usuario;
import com.example.trabalhocasadecoracaodemo.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public DetalheUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = repository.findByLogin(username);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário [" + username + "] Não encontrado");
        }

        return new DetalheUsuarioData(usuario);
    }
}
