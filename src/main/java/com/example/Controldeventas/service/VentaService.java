package com.example.Controldeventas.service;

import com.example.Controldeventas.domain.VentaDTO;
import com.example.Controldeventas.mapper.VentaMapper;
import com.example.Controldeventas.model.Venta;
import com.example.Controldeventas.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    private final VentaMapper ventaMapper;

    public VentaService(VentaRepository ventaRepository, VentaMapper ventaMapper) {
        this.ventaRepository = ventaRepository;
        this.ventaMapper = ventaMapper;
    }

    public VentaDTO createVenta(VentaDTO ventaDTO){
        Venta venta = ventaMapper.toVenta(ventaDTO);
        venta = ventaRepository.save(venta);
        return ventaMapper.toVentaDto(venta);
    }

    public List<VentaDTO> getAllVentas() {
        return ventaRepository.findAll().stream()
                .map(ventaMapper::toVentaDto)
                .collect(Collectors.toList());
    }
}
