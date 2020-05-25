package com.starving.Service.Impl;

import com.starving.Repository.IResetTokenRepository;
import com.starving.Service.IResetTokenService;
import com.starving.model.ResetToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements IResetTokenService {

    @Autowired
    private IResetTokenRepository repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void save(ResetToken token) {
        repo.save(token);
    }

    @Override
    public void delete(ResetToken token) {
        repo.delete(token);
    }
}
