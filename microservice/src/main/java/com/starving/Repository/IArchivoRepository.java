package com.starving.Repository;


import com.starving.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArchivoRepository extends JpaRepository<Archivo, Integer> {
}
