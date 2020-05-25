package com.starving.Service.Impl;

import com.starving.Repository.ILoginRepository;
import com.starving.Service.ILoginService;
import com.starving.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILoginRepository repo;

    @Override
    public int changePassword(String password, String name) throws Exception {
        int rpta = 0;
        try {
            repo.changePassword(password, name);
            rpta = 1;
        } catch (Exception e) {
            rpta = 0;
        }
        return rpta;
    }

    @Override
    public Usuario verifyNameUser(String usuario) throws Exception {
        Usuario us = null;
        try {
            us = repo.verifyNameUser(usuario);
            us = us != null ? us : new Usuario();
        } catch (Exception e) {
            us = new Usuario();
        }
        return us;
    }

}
