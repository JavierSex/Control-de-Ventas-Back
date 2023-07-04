package com.example.Controldeventas.mapper;

import com.example.Controldeventas.domain.VentaDTO;
import com.example.Controldeventas.model.Venta;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class VentaMapper {

    private final ClienteMapper clienteMapper;
    private final DetallesVentaMapper detallesVentaMapper;

    public VentaMapper(ClienteMapper clienteMapper, DetallesVentaMapper detallesVentaMapper) {
        this.clienteMapper = clienteMapper;
        this.detallesVentaMapper = detallesVentaMapper;
    }

    public Venta toVenta(VentaDTO dto){
        return Venta.builder()
                .idVenta(dto.getIdVenta())
                .fechaVenta(dto.getFechaVenta())
                .cliente(clienteMapper.toCliente(dto.getCliente()))
                .detallesVenta(dto.getDetallesVenta().stream()
                        .map(detallesVentaMapper::toDetallesVenta)
                        .collect(Collectors.toList()))
                .build();
    }

    public VentaDTO toVentaDto(Venta entity){
        return VentaDTO.builder()
                .idVenta(entity.getIdVenta())
                .fechaVenta(entity.getFechaVenta())
                .cliente(clienteMapper.toClienteDto(entity.getCliente()))
                .detallesVenta(entity.getDetallesVenta().stream()
                        .map(detallesVentaMapper::toDetallesVentaDto)
                        .collect(Collectors.toList()))
                .build();
    }

}
