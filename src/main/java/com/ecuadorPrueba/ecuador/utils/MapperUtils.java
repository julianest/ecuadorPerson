package com.ecuadorPrueba.ecuador.utils;

import com.ecuadorPrueba.ecuador.domains.dtos.ClienteDTO;
import com.ecuadorPrueba.ecuador.domains.entities.Cliente;

public class MapperUtils {

    /**
     * Convierte un ClienteDTO a una entidad Cliente
     * @param dto ClienteDTO a convertir
     * @return Entidad Cliente convertida
     */
    public static Cliente convertirDtoACliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        return Cliente.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .genero(dto.getGenero())
                .edad(dto.getEdad())
                .identificacion(dto.getIdentificacion())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .contraseña(dto.getContraseña())
                .estado(dto.getEstado() != null ? dto.getEstado() : true)
                .build();
    }

    /**
     * Convierte una entidad Cliente a ClienteDTO
     * @param entidad Entidad Cliente a convertir
     * @return ClienteDTO convertido
     */
    public static ClienteDTO convertirClienteADto(Cliente entidad) {
        return ClienteDTO.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .genero(entidad.getGenero())
                .edad(entidad.getEdad())
                .identificacion(entidad.getIdentificacion())
                .direccion(entidad.getDireccion())
                .telefono(entidad.getTelefono())
                .contraseña(entidad.getContraseña())
                .estado(entidad.getEstado())
                .build();
    }

    /**
     * Actualiza una entidad Cliente existente con los datos no nulos de un DTO
     * @param cliente Entidad Cliente a actualizar
     * @param dto DTO con los nuevos datos
     */
    public static void actualizarClienteDesdeDTO(Cliente cliente, ClienteDTO dto) {
        if (dto.getNombre() != null) {
            cliente.setNombre(dto.getNombre());
        }
        if (dto.getGenero() != null) {
            cliente.setGenero(dto.getGenero());
        }
        if (dto.getEdad() > 0) {
            cliente.setEdad(dto.getEdad());
        }
        if (dto.getIdentificacion() != null) {
            cliente.setIdentificacion(dto.getIdentificacion());
        }
        if (dto.getDireccion() != null) {
            cliente.setDireccion(dto.getDireccion());
        }
        if (dto.getTelefono() != null) {
            cliente.setTelefono(dto.getTelefono());
        }
        if (dto.getContraseña() != null) {
            cliente.setContraseña(dto.getContraseña());
        }
        if (dto.getEstado() != null) {
            cliente.setEstado(dto.getEstado());
        }
    }
}