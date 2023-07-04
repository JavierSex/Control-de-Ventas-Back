package com.example.Controldeventas.mapper;

import com.example.Controldeventas.domain.DetallesVentaDTO;
import com.example.Controldeventas.model.DetallesVenta;
import org.springframework.stereotype.Component;

@Component
public class DetallesVentaMapper {

    private final ProductoMapper productoMapper;

    public DetallesVentaMapper(ProductoMapper productoMapper) {
        this.productoMapper = productoMapper;
    }

    public DetallesVenta toDetallesVenta(DetallesVentaDTO dto){
        return DetallesVenta.builder()
                .idDetalleVenta(dto.getIdDetalleVenta())
                .producto(productoMapper.toProducto(dto.getProducto()))
                .unidadesVendidas(dto.getUnidadesVendidas())
                .venta(null) //Esta linea puede variar dependiendo de tu lógica de negocio
                .build();
    }

    public DetallesVentaDTO toDetallesVentaDto(DetallesVenta entity){
        return DetallesVentaDTO.builder()
                .idDetalleVenta(entity.getIdDetalleVenta())
                .producto(productoMapper.toProductoDto(entity.getProducto()))
                .unidadesVendidas(entity.getUnidadesVendidas())
                .build();
    }

}
