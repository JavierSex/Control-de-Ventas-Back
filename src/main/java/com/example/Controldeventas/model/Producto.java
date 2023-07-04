package com.example.Controldeventas.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    @Column(name = "unidades_stock", nullable = false)
    private Integer unidadesStock;

    public Producto() {
    }

    public Producto(Long idProducto, String nombre, Double valorUnitario, Integer unidadesStock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.unidadesStock = unidadesStock;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getUnidadesStock() {
        return unidadesStock;
    }

    public void setUnidadesStock(Integer unidadesStock) {
        this.unidadesStock = unidadesStock;
    }
}
