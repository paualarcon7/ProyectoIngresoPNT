package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaService {
    
    private final ProvinciaRepository provinciaRepository;
    
    
    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }
    
    
    public Provincia buscarPorId(Long id){
        return provinciaRepository.findById(id).orElse(null);
    }
    
    public List<Provincia> buscarTodos() {
        return provinciaRepository.findAll();
    }
    
}
