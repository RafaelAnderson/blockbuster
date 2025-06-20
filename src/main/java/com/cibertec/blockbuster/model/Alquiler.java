package com.cibertec.blockbuster.model;

import com.cibertec.blockbuster.enums.EstadoAlquiler;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private int total;

    @Enumerated(EnumType.STRING)
    private EstadoAlquiler estado;

    public Alquiler() {
    }

    public Alquiler(LocalDate fecha, Cliente cliente, int total, EstadoAlquiler estado) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
        this.estado = estado;
    }
}
