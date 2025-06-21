package com.cibertec.blockbuster.service.impl;

import com.cibertec.blockbuster.forms.AlquilerForm;
import com.cibertec.blockbuster.model.Pelicula;
import com.cibertec.blockbuster.repository.PeliculaRepository;
import com.cibertec.blockbuster.service.PeliculaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> listar() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula buscarPorId(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarPelicula(AlquilerForm form) {
        Pelicula pelicula = peliculaRepository.findById(form.getPelicula().getId()).orElse(null);
        if(pelicula != null) {
            pelicula.setStock(pelicula.getStock() - form.getCantidad());
            peliculaRepository.save(pelicula);
        }
    }
}
