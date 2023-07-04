package com.example.Controldeventas.controller;

import com.example.Controldeventas.domain.VentaDTO;
import com.example.Controldeventas.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<VentaDTO> createVenta(@RequestBody VentaDTO ventaDTO) {
        return new ResponseEntity<>(ventaService.createVenta(ventaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VentaDTO>> getAllVentas() {
        return new ResponseEntity<>(ventaService.getAllVentas(), HttpStatus.OK);
    }

}
