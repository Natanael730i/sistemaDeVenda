package com.example.trabalhocasadecoracaodemo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COMPRA")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany
    private List<Produto> idProduto;
    @OneToOne
    private Usuario idUsuario;
    private Double valorCompra;
}
