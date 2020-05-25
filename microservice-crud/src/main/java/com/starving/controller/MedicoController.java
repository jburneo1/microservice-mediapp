package com.starving.controller;


import com.starving.exception.ModelNotFoundException;
import com.starving.model.Medico;
import com.starving.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    public IMedicoService service;

    // @PreAuthorize("@authServiceImpl.hasAccess('listar')")
    @GetMapping
    public ResponseEntity<List<Medico>> listar(){
        List<Medico> lista = service.listar();
        return new ResponseEntity<List<Medico>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> listarPorId(@PathVariable("id") Integer id){
        Medico obj = service.leerPorId(id);
        if(obj.getIdMedico() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Medico>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Medico medico) {
        Medico obj = service.registrar(medico);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medico.getIdMedico()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Medico> modificar(@Valid @RequestBody Medico medico) {
        Medico obj = service.modificar(medico);
        return new ResponseEntity<Medico>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Medico obj = service.leerPorId(id);
        if(obj.getIdMedico() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
