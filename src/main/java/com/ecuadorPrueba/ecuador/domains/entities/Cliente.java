package com.ecuadorPrueba.ecuador.domains.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "personaId")
public class Cliente extends Persona {

    @Column(name = "cliente_id", nullable = false, unique = true, length = 20)
    private Long clienteId;

    @Column(nullable = false, length = 255)
    private String contraseña;

    @Column(nullable = false)
    private Boolean estado;

    public Cliente(String nombre, String genero, long edad, String identificacion,
                   String direccion, String telefono, Long clienteId,
                   String contraseña, Boolean estado) {
        super(null, nombre, genero, edad, identificacion, direccion, telefono);
        this.clienteId = clienteId;
        this.contraseña = contraseña;
        this.estado = estado;
    }
}