package com.starving.Controller;

import com.starving.DTO.ConsultaListaExamenDTO;
import com.starving.DTO.ConsultaResumenDTO;
import com.starving.DTO.FiltroConsultaDTO;
import com.starving.Exception.ModelNotFoundException;
import com.starving.Service.IArchivoService;
import com.starving.Service.IConsultaService;
import com.starving.model.Archivo;
import com.starving.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService service;

    @Autowired
    private IArchivoService archivoService;

    @GetMapping
    public ResponseEntity<List<Consulta>> listar(){
        List<Consulta> lista = service.listar();
        return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id){
        Consulta obj = service.leerPorId(id);
        if(obj.getIdConsulta() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody ConsultaListaExamenDTO consultaDTO) {
        Consulta obj = service.registrarTransaccional(consultaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Consulta> modificar(@RequestBody Consulta consulta) {
        Consulta obj = service.modificar(consulta);
        return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Consulta obj = service.leerPorId(id);
        if(obj.getIdConsulta() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @PostMapping("/buscar")
    public ResponseEntity<List<Consulta>> buscar(@RequestBody FiltroConsultaDTO filtro) {
        List<Consulta> consultas = new ArrayList<>();

        if (filtro != null) {
            if (filtro.getFechaConsulta() != null) {
                consultas = service.buscarFecha(filtro);
            } else {
                consultas = service.buscar(filtro);
            }
        }
        return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
    }

    @GetMapping("/listarResumen")
    public ResponseEntity<List<ConsultaResumenDTO>> listarResumen() {
        List<ConsultaResumenDTO> consultas = new ArrayList<>();
        consultas = service.listarResumen();

        return new ResponseEntity<List<ConsultaResumenDTO>>(consultas, HttpStatus.OK);
    }

    @GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> generarReporte() {
        byte[] data = null;
        data = service.generarReporte();
        return new ResponseEntity<byte[]>(data, HttpStatus.OK);
    }

    @PostMapping(value = "/guardarArchivo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Integer> guardarArchivo(@RequestParam("adjunto") MultipartFile file) throws IOException {
        int rpta = 0;
        Archivo archivo = new Archivo();
        archivo.setFiletype(file.getContentType());
        archivo.setFilename(file.getName());
        archivo.setValue(file.getBytes());

        rpta = archivoService.guardar(archivo);

        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }

    @GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {
        byte[] arr = archivoService.leerArchivo(idArchivo);

        return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
    }

}
