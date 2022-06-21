package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import static org.assertj.core.api.Assertions.assertThat;
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
        Long id = 22L;

        Provincia provincia = provinciaService.buscarPorId(id);
        assertThat(provincia).isNull();
    } 

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorId_conIdNull_lanzaExcepcion() {
        provinciaService.buscarPorId(null);
    }

    @Test
    public void buscarPorNombre_conStringExacto_retornaProvincia() {
        Provincia provincia = provinciaService.buscarPorNombreExacto("Jujuy");
        assertThat(provincia).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorNombre_conStringNull_lanzaExcepcion() {
        provinciaService.buscarPorNombreExacto(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorNombre_conStringInvalido_lanzaExcepcion() {
        provinciaService.buscarPorNombreExacto("ab");
    }

    @Test
    public void buscarPorNombre_ignorandoMayusMinus_retornaProvincia() {
        Iterable<Provincia> provincias = provinciaService.buscarIgnorandoMayusculas("jU");
        assertThat(provincias).isNotNull();
    }

    @Test
    public void recibeProvincia_porParametro_guardaProvincia() {
        Provincia provincia = new Provincia();
        provincia.setNombre("Tierra del Fuego");
        provincia.setIdPais(1L);
        Provincia provincias = provinciaService.guardar(provincia);
        assertThat(provincias).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void recibeProvincia_conValorNull_lanzaExcepcion() {
        provinciaService.guardar(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void recibeProvincia_conNombreInvalido_lanzaExcepcion() {
        Provincia provincia = new Provincia();
        provincia.setNombre("Ti");
        provinciaService.guardar(provincia);

    }
}
