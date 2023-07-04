package com.example.Controldeventas.controller;

import com.example.Controldeventas.domain.ProductoDTO;
import com.example.Controldeventas.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        return new ResponseEntity<>(productoService.createProducto(productoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        return new ResponseEntity<>(productoService.getAllProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProducto(@PathVariable Long id) {
        return new ResponseEntity<>(productoService.getProducto(id), HttpStatus.OK);
    }

}
