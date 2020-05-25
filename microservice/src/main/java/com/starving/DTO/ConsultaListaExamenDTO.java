package com.starving.DTO;


import com.starving.model.Consulta;
import com.starving.model.Examen;

import java.util.List;

public class ConsultaListaExamenDTO {

    private Consulta consulta;
    private List<Examen> lstExamen;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Examen> getLstExamen() {
        return lstExamen;
    }

    public void setLstExamen(List<Examen> lstExamen) {
        this.lstExamen = lstExamen;
    }
}
