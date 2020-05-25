package com.starving.service.Impl;

import com.starving.repository.IPacienteRepository;
import com.starving.service.IPacienteService;
import com.starving.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository repo;

    @Override
    public Paciente registrar(Paciente pac) {
        return repo.save(pac);
    }

    @Override
    public Paciente modificar(Paciente pac) {
        return repo.save(pac);
    }

    @Override
    public List<Paciente> listar() {
        return repo.findAll();
    }

    @Override
    public Paciente leerPorId(Integer id) {
        Optional<Paciente> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Paciente();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Page<Paciente> listPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
