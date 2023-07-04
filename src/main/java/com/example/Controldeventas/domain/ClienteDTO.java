package com.example.Controldeventas.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDTO {

    private Long idCLiente;

    private String identificacion;

    private String nombreApellido;

}
