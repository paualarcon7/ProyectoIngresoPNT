package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaService {

    @Autowired //el service tiene una dependencia con el repository
    private final ProvinciaRepository provinciaRepository;

    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    public Provincia buscarPorId(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Valor inválido");
        }
        Provincia provincia = provinciaRepository.findById(id).orElse(null);
        return provincia;
    }

    /* public List<Provincia> buscarTodos() {
        return provinciaRepository.findAll();
    }*/
    public Provincia buscarPorNombreExacto(String nombre) {
        return provinciaRepository.findByNombreLike(nombre);
    }

    public List<Provincia> buscarPorNombreInvalido(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("Valor inválido");
        }
        if (nombre.length() < 3) {
            throw new IllegalArgumentException("Valor inválido");
        }
        return provinciaRepository.findByNombre(nombre);
    }

    public Iterable<Provincia> buscarIgnorandoMayusculas(String nombre) {
        return provinciaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Provincia guardar(Provincia provincia) {
        if (provincia == null) {
            throw new IllegalArgumentException("Valor inválido");
        }
        if (provincia.getNombre().length() < 3) {
            throw new IllegalArgumentException("Valor inválido");
        }

        return provinciaRepository.save(provincia);
    }
}
