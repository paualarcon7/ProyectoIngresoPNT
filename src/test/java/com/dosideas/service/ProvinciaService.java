package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import static junit.runner.Version.id;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //Runner de Spring que Junit usa cuando corre el test
@SpringBootTest(classes = ApplicationConfig.class)
class ProvinciaService {

    @Autowired //Spring inyecta automáticamente la instancia 
    private ProvinciaService provinciaService;

    public Provincia buscarPorId(Long id) {
        Provincia provincia = new Provincia();
        provincia = provinciaService.buscarPorId(id);
        
        
      
        if (provincia != null){
            
            provincia.setNombre("provincia " + provincia.getId().toString());
            
            return provincia;
        }
        return provincia;
    }
}
