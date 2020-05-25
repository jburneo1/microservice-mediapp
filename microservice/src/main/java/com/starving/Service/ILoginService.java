package com.starving.Service;

import com.starving.model.Usuario;

public interface ILoginService {

    Usuario verifyNameUser(String usuario) throws Exception;
    int changePassword(String password, String name) throws Exception;
}
