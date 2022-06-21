package com.dosideas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProvinciaNoEncontradaException extends Exception {

    public ProvinciaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
