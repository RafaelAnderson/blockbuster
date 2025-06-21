package com.cibertec.blockbuster.service;

import com.cibertec.blockbuster.forms.AlquilerForm;
import com.cibertec.blockbuster.model.Pelicula;

import java.util.List;

public interface PeliculaService {
    List<Pelicula> listar();

    Pelicula buscarPorId(Long id);

    void actualizarPelicula(AlquilerForm form);
}
