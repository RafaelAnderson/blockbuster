package com.cibertec.blockbuster.model;

import com.cibertec.blockbuster.model.pk.DetalleAlquilerPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DetalleAlquiler {

    @EmbeddedId
    private DetalleAlquilerPk id;

    private int cantidad;

    public DetalleAlquiler() {
    }

    public DetalleAlquiler(DetalleAlquilerPk id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }
}
