package com.example.trabalhocasadecoracaodemo.repository;


import com.example.trabalhocasadecoracaodemo.model.Produto;
import com.example.trabalhocasadecoracaodemo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRespository extends JpaRepository<Produto, Integer> {

    public Optional<Produto> findById(Integer id);

}
