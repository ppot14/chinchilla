/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Labor;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface LaborMappers {

    Labor getLabor(Integer id_labor);

    ArrayList getAllLabor();

    Labor getLaborPorNombre();

    int createLabor(Labor labor);

    int updateLabor(Labor labor);

    int deleteLabor(Integer id_labor);
}
