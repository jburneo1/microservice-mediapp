package com.starving.Repository;

import com.starving.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResetTokenRepository extends JpaRepository<ResetToken, Integer> {

    // from ResetToken where token = :?
    ResetToken findByToken(String token);

}
