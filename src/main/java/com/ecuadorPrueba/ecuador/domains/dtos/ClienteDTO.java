package com.ecuadorPrueba.ecuador.domains.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    // Campos heredados de Persona
    private Long id;
    private String identificacion;
    private String nombre;
    private String genero;
    private long edad;
    private String direccion;
    private String telefono;

    // Campos específicos de Cliente
    private String contraseña;
    private Boolean estado;
}
