package com.dosideas.repository;

import com.dosideas.domain.Pais;
import com.dosideas.domain.Provincia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
    
    Optional<Provincia> findById(Long id);
    
}
