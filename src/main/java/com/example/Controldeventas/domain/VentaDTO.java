package com.example.Controldeventas.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class VentaDTO {

    private Long idVenta;

    private Date fechaVenta;

    private ClienteDTO cliente;

    private List<DetallesVentaDTO> detallesVenta;

}
