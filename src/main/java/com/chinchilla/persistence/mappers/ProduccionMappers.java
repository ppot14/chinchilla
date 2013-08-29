/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Produccion;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface ProduccionMappers {

    Produccion getProduccion(Integer id_produccion);

    ArrayList getAllProduccion();

    Produccion getProduccionPorNombre();

    int createProduccion(Produccion produccion);

    int updateProduccion(Produccion produccion);

    int deleteProduccion(Integer id_produccion);
}
