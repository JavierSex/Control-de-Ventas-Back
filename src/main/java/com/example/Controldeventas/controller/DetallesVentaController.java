package com.example.Controldeventas.controller;

import com.example.Controldeventas.domain.DetallesVentaDTO;
import com.example.Controldeventas.service.DetallesVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesVenta")
public class DetallesVentaController {

    private final DetallesVentaService detallesVentaService;

    public DetallesVentaController(DetallesVentaService detallesVentaService) {
        this.detallesVentaService = detallesVentaService;
    }

    @PostMapping
    public ResponseEntity<DetallesVentaDTO> createDetallesVenta(@RequestBody DetallesVentaDTO detallesVentaDTO) {
        return new ResponseEntity<>(detallesVentaService.createDetallesVenta(detallesVentaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DetallesVentaDTO>> getAllDetallesVenta() {
        return new ResponseEntity<>(detallesVentaService.getAllDetallesVenta(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesVentaDTO> getDetallesVenta(@PathVariable Long id) {
        return new ResponseEntity<>(detallesVentaService.getDetallesVenta(id), HttpStatus.OK);
    }

}
