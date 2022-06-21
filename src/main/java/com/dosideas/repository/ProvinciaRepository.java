package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Spring annotation that indicates that the decorated class is a repository.
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    Provincia findByNombreLike(String nombre);

    List<Provincia> findByNombre(String nombre);

    //implementa clase iterable con metodos de JPA findBy() para buscar, containing() que contenga String e ignoreCase() ignore mayus y minus
    Iterable<Provincia> findByNombreContainingIgnoreCase(String nombre);

}
