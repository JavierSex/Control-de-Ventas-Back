package com.example.Controldeventas.mapper;

import com.example.Controldeventas.domain.ProductoDTO;
import com.example.Controldeventas.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public Producto toProducto(ProductoDTO dto){
        return Producto.builder()
                .idProducto(dto.getIdProducto())
                .nombre(dto.getNombre())
                .valorUnitario(dto.getValorUnitario())
                .unidadesStock(dto.getUnidadesStock())
                .build();
    }

    public ProductoDTO toProductoDto(Producto entity){
        return ProductoDTO.builder()
                .idProducto(entity.getIdProducto())
                .nombre(entity.getNombre())
                .valorUnitario(entity.getValorUnitario())
                .unidadesStock(entity.getUnidadesStock())
                .build();
    }

}
