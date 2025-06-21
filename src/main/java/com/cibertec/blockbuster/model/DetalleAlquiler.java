package com.cibertec.blockbuster.model;

import com.cibertec.blockbuster.model.pk.DetalleAlquilerPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_alquiler")
public class DetalleAlquiler {

    @EmbeddedId
    private DetalleAlquilerPk id;

    private int cantidad;
}
