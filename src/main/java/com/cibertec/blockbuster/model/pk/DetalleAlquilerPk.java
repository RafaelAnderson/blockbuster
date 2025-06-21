package com.cibertec.blockbuster.model.pk;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DetalleAlquilerPk {

    private long alquilerId;
    private long peliculaId;
}
