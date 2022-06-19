package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.contains;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //Runner de Spring que Junit usa cuando corre el test
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceTest {

    @Autowired
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_conIdExistente_retornaProvincia() {
        Long id = 1L;

        Provincia provincia = provinciaService.buscarPorId(id);

        //palabra reservada assert: la condición debe ser cierta
        assertThat(provincia).isNotNull();
        assertThat(provincia.getId()).isEqualTo(id);
    }

    @Test
    public void buscarPorId_conIdInexistente_retornaNull() {
        Long id = 21L;

        Provincia provincia = provinciaService.buscarPorId(id);
        assertThat(provincia).isNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorId_conIdNull_lanzaExcepcion() {
        try {
            Provincia provincia = provinciaService.buscarPorId(null);
        } catch (Exception err) {
            throw new IllegalArgumentException("id nulo");
        }
    }

    @Test
    public void buscarPorNombre_conStringExacto_retornaProvincia() {
        String nombre = "";
        List<Provincia> provincia = provinciaService.buscarPorNombre(nombre);
        assertThat(provincia).isNotNull();
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void buscarPorNombre_conStringNull_lanzaExcepcion() {
        try {
            provinciaService.buscarPorNombreExacto(null);
        } catch (Exception err) {
            throw new IllegalArgumentException("nombre nulo");
        }
    }
    

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorNombre_conStringInvalido_lanzaExcepcion() {
        try {
            provinciaService.buscarPorNombreExacto("abcde");
        } catch (Exception err) {
            throw new IllegalArgumentException("nombre inválido");
        }
    }
    
   /* @Test
    public void buscarPorNombre_ignorandoMayusMinus_retornaProvincia(){
      //  String nombre = "";
      
        List<Provincia> provincias = provinciaService.buscarIgnorandoMayusculas("bueNos aIrEs");
       // System.out.println(provincias.size());
        assertThat(provincias.c));//.isNotEmpty();
       // assertThat(provincia.size()).is(); //.isNotNull();
       // assertThat(provincia).contains();
    }*/
}
