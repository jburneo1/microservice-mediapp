package com.starving.repository;

import com.starving.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<Medico, Integer> {
}
