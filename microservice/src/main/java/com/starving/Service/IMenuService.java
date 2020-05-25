package com.starving.Service;

import com.starving.model.Menu;

import java.util.List;

public interface IMenuService extends ICrud<Menu> {

    List<Menu> listMenuByUser(String nombre);
}
