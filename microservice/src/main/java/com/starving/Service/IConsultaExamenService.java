package com.starving.Service;

import com.starving.model.ConsultaExamen;

import java.util.List;

public interface IConsultaExamenService {

    List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);
}
