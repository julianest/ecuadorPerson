package com.ecuadorPrueba.ecuador.controllers;

import com.ecuadorPrueba.ecuador.domains.dtos.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecuadorPrueba.ecuador.domains.services.Impl.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

//    @Autowired
//    private ClienteServiceImpl clienteService;
    private final ClienteServiceImpl clienteService;

    @Autowired
    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<List<ClienteDTO>> crearClientes(@RequestBody List<ClienteDTO> clientesDTO) {
        List<ClienteDTO> nuevosClientes = clientesDTO.stream()
                .map(clienteService::crearCliente)
                .toList();
        return new ResponseEntity<>(nuevosClientes, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscar")
    public ResponseEntity<ClienteDTO> obtenerClientePorIdentificacion(@RequestParam String identificacion) {
        return clienteService.obtenerClientePorIdentificacion(identificacion)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodosLosClientes() {
        List<ClienteDTO> clientes = clienteService.listarTodosLosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizarCliente(
            @PathVariable Long id,
            @RequestBody ClienteDTO clienteDTO) {
        return clienteService.actualizarCliente(id, clienteDTO)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        if (clienteService.eliminarCliente(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<ClienteDTO> cambiarEstadoCliente(
            @PathVariable Long id,
            @RequestParam Boolean nuevoEstado) {
        return clienteService.cambiarEstadoCliente(id, nuevoEstado)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}