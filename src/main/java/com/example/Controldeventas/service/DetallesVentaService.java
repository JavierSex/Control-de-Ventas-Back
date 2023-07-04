package com.example.Controldeventas.service;

import com.example.Controldeventas.domain.DetallesVentaDTO;
import com.example.Controldeventas.mapper.DetallesVentaMapper;
import com.example.Controldeventas.model.DetallesVenta;
import com.example.Controldeventas.repository.DetallesVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetallesVentaService {

    private final DetallesVentaRepository detallesVentaRepository;

    private final DetallesVentaMapper detallesVentaMapper;

    public DetallesVentaService(DetallesVentaRepository detallesVentaRepository, DetallesVentaMapper detallesVentaMapper) {
        this.detallesVentaRepository = detallesVentaRepository;
        this.detallesVentaMapper = detallesVentaMapper;
    }

    public DetallesVentaDTO createDetallesVenta(DetallesVentaDTO detallesVentaDTO) {
        DetallesVenta detallesVenta = detallesVentaMapper.toDetallesVenta(detallesVentaDTO);
        detallesVenta = detallesVentaRepository.save(detallesVenta);
        return detallesVentaMapper.toDetallesVentaDto(detallesVenta);
    }

    public List<DetallesVentaDTO> getAllDetallesVenta() {
        return detallesVentaRepository.findAll().stream()
                .map(detallesVentaMapper::toDetallesVentaDto)
                .collect(Collectors.toList());
    }

    public DetallesVentaDTO getDetallesVenta(Long id) {
        return detallesVentaRepository.findById(id)
                .map(detallesVentaMapper::toDetallesVentaDto)
                .orElseThrow(() -> new IllegalArgumentException("Invalid detallesVenta Id:" + id));
    }
}
