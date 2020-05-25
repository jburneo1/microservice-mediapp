package com.starving.Service;

import java.util.List;

public interface ICrud<T> {

    T registrar(T obj);
    T modificar(T obj);
    List<T> listar();
    T leerPorId(Integer id);
    boolean eliminar(Integer id);
}
