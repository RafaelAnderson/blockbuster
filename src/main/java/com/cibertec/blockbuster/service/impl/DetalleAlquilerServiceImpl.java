package com.cibertec.blockbuster.service.impl;

import com.cibertec.blockbuster.forms.AlquilerForm;
import com.cibertec.blockbuster.model.DetalleAlquiler;
import com.cibertec.blockbuster.model.pk.DetalleAlquilerPk;
import com.cibertec.blockbuster.repository.DetalleAlquilerRepository;
import com.cibertec.blockbuster.service.DetalleAlquilerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DetalleAlquilerServiceImpl implements DetalleAlquilerService {

    private final DetalleAlquilerRepository detalleAlquilerRepository;

    @Override
    public void guardarDetalleAlquiler(AlquilerForm form) {
        DetalleAlquilerPk detalleAlquilerPk = new DetalleAlquilerPk();
        detalleAlquilerPk.setAlquilerId(form.getIdAlquiler());
        detalleAlquilerPk.setPeliculaId(form.getPelicula().getId());

        DetalleAlquiler detalleAlquiler = new DetalleAlquiler();
        detalleAlquiler.setId(detalleAlquilerPk);
        detalleAlquiler.setCantidad(form.getCantidad());

        detalleAlquilerRepository.save(detalleAlquiler);
    }
}
