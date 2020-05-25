package com.starving.service.Impl;


import com.starving.model.Medico;
import com.starving.repository.IMedicoRepository;
import com.starving.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements IMedicoService {

    @Autowired
    private IMedicoRepository repo;

    @Override
    public Medico registrar(Medico obj) {
        return repo.save(obj);
    }

    @Override
    public Medico modificar(Medico obj) {
        return repo.save(obj);
    }

    @Override
    public List<Medico> listar() {
        return repo.findAll();
    }

    @Override
    public Medico leerPorId(Integer id) {
        Optional<Medico> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Medico();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
