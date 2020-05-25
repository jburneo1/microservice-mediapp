package com.starving.Service.Impl;

import com.starving.Repository.IMenuRepository;
import com.starving.Service.IMenuService;
import com.starving.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuRepository repo;

    @Override
    public List<Menu> listMenuByUser(String nombre) {
        List<Menu> menus = new ArrayList<>();
        repo.listMenuByUser(nombre).forEach(lstMenu -> {
            Menu m = new Menu();
            m.setIdMenu(Integer.parseInt(String.valueOf(lstMenu[0])));
            m.setIcono(String.valueOf(lstMenu[1]));
            m.setNombre(String.valueOf(lstMenu[2]));
            m.setUrl(String.valueOf(lstMenu[3]));

            menus.add(m);
        });
        return menus;
    }

    @Override
    public Menu registrar(Menu obj) {
        return repo.save(obj);
    }

    @Override
    public Menu modificar(Menu obj) {
        return repo.save(obj);
    }

    @Override
    public List<Menu> listar() {
        return repo.findAll();
    }

    @Override
    public Menu leerPorId(Integer id) {
        Optional<Menu> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Menu();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
