package com.starving.Repository;

import com.starving.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findOneByUsername(String username);
}
