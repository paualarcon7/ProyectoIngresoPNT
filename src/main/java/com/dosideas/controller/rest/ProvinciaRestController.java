package com.dosideas.controller.rest;

import com.dosideas.exception.ProvinciaNoEncontradaException;
import com.dosideas.domain.Provincia;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaRestController {
    
    @Autowired
    private ProvinciaService provinciaService;
    
    @GetMapping("/{id}")
    public Provincia buscarPorId(@PathVariable Long id) throws ProvinciaNoEncontradaException {
        Provincia provincia = provinciaService.buscarPorId(id);
        if (provincia == null) {
            throw new ProvinciaNoEncontradaException("Provincia no encontrada");
        }
        return provincia;
    }
}
