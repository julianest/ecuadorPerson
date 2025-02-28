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
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Persona {

    @Column(nullable = false, length = 255)
    private String contraseña;

    @Column(nullable = false)
    private Boolean estado;

    public Cliente(String nombre, String genero, long edad, String identificacion,
                   String direccion, String telefono, String contraseña, Boolean estado) {
        super(null, nombre, genero, edad, identificacion, direccion, telefono);
        this.contraseña = contraseña;
        this.estado = estado;
    }
}