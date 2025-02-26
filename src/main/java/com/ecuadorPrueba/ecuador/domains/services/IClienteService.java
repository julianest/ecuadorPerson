package com.ecuadorPrueba.ecuador.domains.services;

import com.ecuadorPrueba.ecuador.domains.dtos.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    Optional<ClienteDTO> obtenerClientePorId(Long id);

    Optional<ClienteDTO> obtenerClientePorIdentificacion(String identificacion);

    List<ClienteDTO> listarTodosLosClientes();

    Optional<ClienteDTO> actualizarCliente(Long id, ClienteDTO clienteDTO);

    boolean eliminarCliente(Long id);

    Optional<ClienteDTO> cambiarEstadoCliente(Long id, Boolean nuevoEstado);
}