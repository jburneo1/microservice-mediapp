package com.starving.Repository;

import com.starving.model.ConsultaExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IConsultaExamenRepository extends JpaRepository<ConsultaExamen, Integer> {

    @Modifying
    @Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES (:idConsulta, :idExamen)", nativeQuery = true)
    Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idExamen") Integer idExamen);

    @Query("from ConsultaExamen ce where ce.consulta.idConsulta = :idConsulta")
    List<ConsultaExamen> listarExamenesPorConsulta(@Param("idConsulta") Integer idconsulta);

}
