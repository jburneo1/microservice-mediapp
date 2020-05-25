package com.starving.Exception;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(String mensaje) {
        super(mensaje);
    }
}
