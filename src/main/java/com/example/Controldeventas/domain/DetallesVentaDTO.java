package com.example.Controldeventas.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DetallesVentaDTO {

    private Long idDetalleVenta;

    private ProductoDTO producto;

    private int unidadesVendidas;

    private double valorTotal;

}
