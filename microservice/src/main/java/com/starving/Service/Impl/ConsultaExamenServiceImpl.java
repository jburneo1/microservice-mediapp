package com.starving.Service.Impl;

import com.starving.Repository.IConsultaExamenRepository;
import com.starving.Service.IConsultaExamenService;
import com.starving.model.ConsultaExamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService {

    @Autowired
    private IConsultaExamenRepository repo;

    @Override
    public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
        return repo.listarExamenesPorConsulta(idconsulta);
    }
}
