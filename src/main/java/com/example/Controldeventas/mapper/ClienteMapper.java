package com.example.Controldeventas.mapper;

import com.example.Controldeventas.domain.ClienteDTO;
import com.example.Controldeventas.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toCliente(ClienteDTO dto){
        return Cliente.builder()
                .idCliente(dto.getIdCLiente())
                .identificacion(dto.getIdentificacion())
                .nombreApellido(dto.getNombreApellido())
                .build();
    }

    public ClienteDTO toClienteDto(Cliente entity){
        return ClienteDTO.builder()
                .idCLiente(entity.getIdCliente())
                .identificacion(entity.getIdentificacion())
                .nombreApellido(entity.getNombreApellido())
                .build();
    }

}
