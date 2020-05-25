package com.starving.service;

import com.starving.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPacienteService extends ICrud<Paciente> {

    Page<Paciente> listPageable(Pageable pageable);
}
