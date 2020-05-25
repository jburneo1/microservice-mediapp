package com.starving.Service;

import com.starving.DTO.ConsultaListaExamenDTO;
import com.starving.DTO.ConsultaResumenDTO;
import com.starving.DTO.FiltroConsultaDTO;
import com.starving.model.Consulta;

import java.util.List;

public interface IConsultaService extends ICrud<Consulta> {

    Consulta registrarTransaccional(ConsultaListaExamenDTO dto);

    List<Consulta> buscar(FiltroConsultaDTO filtro);

    List<Consulta> buscarFecha(FiltroConsultaDTO filtro);

    List<ConsultaResumenDTO> listarResumen();

    byte[] generarReporte();

}
