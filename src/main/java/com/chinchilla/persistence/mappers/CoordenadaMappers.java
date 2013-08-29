/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Coordenada;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface CoordenadaMappers {
    
    Coordenada getCoordenada(Integer id_parcela, Integer orden);

    ArrayList getAllCoordenada();

    Coordenada getFilteredCoordenada();

    int createCoordenada(Coordenada parcela);

    int updateCoordenada(Coordenada parcela);

    int deleteCoordenada(Integer id_parcela, Integer orden);
    
}
