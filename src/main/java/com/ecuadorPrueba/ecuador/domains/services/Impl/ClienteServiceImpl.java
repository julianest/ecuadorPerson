package com.ecuadorPrueba.ecuador.domains.services.Impl;

import com.ecuadorPrueba.ecuador.domains.dtos.ClienteDTO;
import com.ecuadorPrueba.ecuador.domains.entities.Cliente;
import com.ecuadorPrueba.ecuador.domains.repositories.ClienteRepository;
import com.ecuadorPrueba.ecuador.domains.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecuadorPrueba.ecuador.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = MapperUtils.convertirDtoACliente(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return MapperUtils.convertirClienteADto(clienteGuardado);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .map(MapperUtils::convertirClienteADto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> obtenerClientePorIdentificacion(String identificacion) {
        return clienteRepository.findByIdentificacion(identificacion)
                .map(MapperUtils::convertirClienteADto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> listarTodosLosClientes() {
        return clienteRepository.findAll().stream()
                .map(MapperUtils::convertirClienteADto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<ClienteDTO> actualizarCliente(Long id, ClienteDTO clienteDTO) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    MapperUtils.actualizarClienteDesdeDTO(clienteExistente, clienteDTO);
                    Cliente clienteActualizado = clienteRepository.save(clienteExistente);
                    return MapperUtils.convertirClienteADto(clienteActualizado);
                });
    }

    @Override
    @Transactional
    public boolean eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Optional<ClienteDTO> cambiarEstadoCliente(Long id, Boolean nuevoEstado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setEstado(nuevoEstado);
                    return MapperUtils.convertirClienteADto(clienteRepository.save(cliente));
                });
    }

}