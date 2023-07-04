package com.example.Controldeventas.repository;

import com.example.Controldeventas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
