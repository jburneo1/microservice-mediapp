package com.starving.Repository;

import com.starving.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamenRepository extends JpaRepository<Examen, Integer> {
}
