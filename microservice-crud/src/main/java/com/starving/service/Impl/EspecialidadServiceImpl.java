package com.starving.service.Impl;

import com.starving.model.Especialidad;
import com.starving.repository.IEspecialidadRepository;
import com.starving.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

    @Autowired
    private IEspecialidadRepository repo;

    @Override
    public Especialidad registrar(Especialidad obj) {
        return repo.save(obj);
    }

    @Override
    public Especialidad modificar(Especialidad obj) {
        return repo.save(obj);
    }

    @Override
    public List<Especialidad> listar() {
        return repo.findAll();
    }

    @Override
    public Especialidad leerPorId(Integer id) {
        Optional<Especialidad> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Especialidad();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

}
