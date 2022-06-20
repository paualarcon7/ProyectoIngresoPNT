package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Spring annotation that indicates that the decorated class is a repository.
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> { //
    //If a value is present, and the value matches the given predicate, return an Optional describing the value, otherwise return an empty Optional.

   // Optional<Provincia> findById(Long id); //To find entity by their ID, we use the EntityManager.find() method and pass the entity class and the entity ID as the parameters.
    //The findById() method call the EntityManager.find() method to find the entity.

    public Provincia findByNombreLike(String nombre);

    public List<Provincia> findByNombre(String nombre);

    //implementa clase iterable con metodos de JPA findBy() para buscar, containing() que contenga String e ignoreCase() ignore mayus y minus
    public Iterable<Provincia> findByNombreContainingIgnoreCase(String nombre);

}
