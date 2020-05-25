package com.starving.controller;


import com.starving.exception.ModelNotFoundException;
import com.starving.model.Paciente;
import com.starving.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente> lista = service.listar();
        return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) {
        Paciente pac = service.leerPorId(id);
        if(pac.getIdPaciente() == null) {
            throw new ModelNotFoundException("Id no encontrado" + id);
        }
        return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Paciente>> listPageable(Pageable pageable) {
        Page<Paciente> pacientes = service.listPageable(pageable);
        return new ResponseEntity<Page<Paciente>>(pacientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Paciente paciente) {
        Paciente pac = service.registrar(paciente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
    }

    @PutMapping
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente paciente) {
        Paciente pac = service.modificar(paciente);
        return new ResponseEntity<Paciente>(pac, HttpStatus.OK);
    }

}
