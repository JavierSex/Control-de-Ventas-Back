package com.example.Controldeventas.service;

import com.example.Controldeventas.domain.ClienteDTO;
import com.example.Controldeventas.mapper.ClienteMapper;
import com.example.Controldeventas.model.Cliente;
import com.example.Controldeventas.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toCliente(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toClienteDto(cliente);
    }

    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toClienteDto)
                .collect(Collectors.toList());
    }
}
