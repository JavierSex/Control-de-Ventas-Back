package com.example.Controldeventas.service;

import com.example.Controldeventas.domain.ProductoDTO;
import com.example.Controldeventas.mapper.ProductoMapper;
import com.example.Controldeventas.model.Producto;
import com.example.Controldeventas.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    public ProductoService(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toProducto(productoDTO);
        producto = productoRepository.save(producto);
        return productoMapper.toProductoDto(producto);
    }

    public List<ProductoDTO> getAllProductos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toProductoDto)
                .collect(Collectors.toList());
    }

    public ProductoDTO getProducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return productoMapper.toProductoDto(producto);
    }

}
