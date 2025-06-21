package com.cibertec.blockbuster.forms;

import com.cibertec.blockbuster.model.Cliente;
import com.cibertec.blockbuster.model.Pelicula;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlquilerForm {
    private Cliente cliente;
    private Pelicula pelicula;
    private int cantidad;
    private long idAlquiler;
}
