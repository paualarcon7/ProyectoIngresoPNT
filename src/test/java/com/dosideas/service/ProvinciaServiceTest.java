package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //Runner de Spring que Junit usa cuando corre el test
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceTest {
    

    @Test
    public void buscarPorId_conIdExistente_retornaProvincia() {
        ProvinciaService provinciaService = new ProvinciaService();
        Long id = 1L;

        Provincia provincia = provinciaService.buscarPorId(id);

        //palabra reservada assert: la condición debe ser cierta
        assertNotNull(provincia);
        assertEquals(id, provincia.getId());
        assertThat(provincia).isNull();
  }
}