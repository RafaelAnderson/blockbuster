package com.cibertec.blockbuster.repository;

import com.cibertec.blockbuster.model.DetalleAlquiler;
import com.cibertec.blockbuster.model.pk.DetalleAlquilerPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleAlquilerRepository extends JpaRepository<DetalleAlquiler, DetalleAlquilerPk> {
}
