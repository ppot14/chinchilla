/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Cultivo;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface CultivoMappers {

    Cultivo getCultivo(Integer id_cultivo);

    ArrayList getAllCultivo();

    Cultivo getCultivoPorNombre();

    int createCultivo(Cultivo cultivo);

    int updateCultivo(Cultivo cultivo);

    int deleteCultivo(Integer id_cultivo);
}
