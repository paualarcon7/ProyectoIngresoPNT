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
    
    
    public Provincia buscarPorId(Long id){
        
        Provincia provincia = provinciaRepository.findById(id).orElse(null);
        System.out.println(provincia.getNombre());
        return provincia;
    }
    
    public List<Provincia> buscarTodos() {
        return provinciaRepository.findAll();
    }
    
    public List<Provincia> buscarPorNombre(String nombre){
        return provinciaRepository.findByNombre(nombre);
    }
    
    public Provincia buscarPorNombreExacto(String nombre){
      //  System.out.println(nombre);
        if(nombre == null) throw new IllegalArgumentException("nombre nulo");
        if(nombre.length() < 3) throw new IllegalArgumentException("nombre inválido");
        List<Provincia> provincia =  provinciaRepository.findByNombre(nombre);
        System.out.println(provincia.get(0).getNombre());
        return (Provincia) provincia.get(0);
      //  throw new IllegalArgumentException("nombre nulo");
    }
    
    public List<Provincia> buscarIgnorandoMayusculas(String nombre){
        return provinciaRepository.findByNombreIgnoreCase(nombre);
    }
}
