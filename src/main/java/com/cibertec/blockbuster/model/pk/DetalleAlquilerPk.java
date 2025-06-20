package com.cibertec.blockbuster.model.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DetalleAlquilerPk {

    private int alquilerId;
    private int peliculaId;

    public DetalleAlquilerPk() {}

    public DetalleAlquilerPk(int alquilerId, int peliculaId) {
        this.alquilerId = alquilerId;
        this.peliculaId = peliculaId;
    }
}
