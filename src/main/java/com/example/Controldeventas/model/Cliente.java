package com.example.Controldeventas.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "identificacion", nullable = false, unique = true)
    private String identificacion;

    @Column(name = "nombre_y_apellido", nullable = false, length = 50)
    private String nombreApellido;

    public Cliente() {
    }

    public Cliente(Long idCliente, String identificacion, String nombreApellido) {
        this.idCliente = idCliente;
        this.identificacion = identificacion;
        this.nombreApellido = nombreApellido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
}
