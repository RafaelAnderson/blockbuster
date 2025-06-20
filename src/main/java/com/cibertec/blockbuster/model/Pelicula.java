package com.cibertec.blockbuster.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String genero;

    private int stock;

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, int stock) {
        this.titulo = titulo;
        this.genero = genero;
        this.stock = stock;
    }

    public Pelicula(Long id, String titulo, String genero, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.stock = stock;
    }
}
