package com.example.Controldeventas.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDTO {

    private Long idProducto;

    private String nombre;

    private Double valorUnitario;

    private Integer unidadesStock;

}
