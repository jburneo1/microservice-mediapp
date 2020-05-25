package com.starving.Service.Impl;

import com.starving.Repository.IArchivoRepository;
import com.starving.Service.IArchivoService;
import com.starving.model.Archivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArchivoServiceImpl implements IArchivoService {

    @Autowired
    private IArchivoRepository repo;

    @Override
    public int guardar(Archivo archivo) {
        Archivo ar = repo.save(archivo);
        return ar.getIdArchivo() > 0 ? 1 : 0;
    }

    @Override
    public byte[] leerArchivo(Integer idArchivo) {
        Optional<Archivo> op = repo.findById(idArchivo);
        return op.isPresent() ? op.get().getValue() : new byte[0];
    }
}
