package com.cibertec.blockbuster.service.impl;

import com.cibertec.blockbuster.enums.EstadoAlquiler;
import com.cibertec.blockbuster.forms.AlquilerForm;
import com.cibertec.blockbuster.model.Alquiler;
import com.cibertec.blockbuster.repository.AlquilerRepository;
import com.cibertec.blockbuster.service.AlquilerService;
import com.cibertec.blockbuster.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AlquilerServiceImpl implements AlquilerService {

    private final AlquilerRepository alquilerRepository;

    private final DetalleAlquilerServiceImpl detalleAlquilerServiceImpl;

    @Override
    public void guardarAlquiler(AlquilerForm form) {
        Alquiler alquiler = new Alquiler();
        alquiler.setIdCliente(form.getCliente().getId());
        alquiler.setFecha(LocalDate.now());
        alquiler.setTotal(Constants.PRECIO_ALQUILER * form.getCantidad());
        alquiler.setEstado(EstadoAlquiler.ACTIVO);

        alquilerRepository.save(alquiler);

        form.setIdAlquiler(alquiler.getId());
        detalleAlquilerServiceImpl.guardarDetalleAlquiler(form);
    }
}
