package com.cibertec.blockbuster.model;

import com.cibertec.blockbuster.enums.EstadoAlquiler;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)

    private long idCliente;

    @Column(nullable = false)
    private int total;

    @Enumerated(EnumType.STRING)
    private EstadoAlquiler estado;

    public Alquiler(LocalDate fecha, long idCliente, int total, EstadoAlquiler estado) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.total = total;
        this.estado = estado;
    }
}
