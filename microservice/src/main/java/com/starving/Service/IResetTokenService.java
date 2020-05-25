package com.starving.Service;


import com.starving.model.ResetToken;

public interface IResetTokenService {

    ResetToken findByToken(String token);
    void save(ResetToken token);
    void delete(ResetToken token);
}
