package com.starving.Service;

import com.starving.model.Archivo;

public interface IArchivoService {

    int guardar(Archivo archivo);
    byte[] leerArchivo(Integer idArchivo);
}
