package com.example.Controldeventas.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetallesVenta> detallesVenta;

    public Venta() {
    }

    public Venta(Long idVenta, Date fechaVenta, Cliente cliente) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallesVenta> getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(List<DetallesVenta> detallesVenta) {
        this.detallesVenta = detallesVenta;
    }
}
