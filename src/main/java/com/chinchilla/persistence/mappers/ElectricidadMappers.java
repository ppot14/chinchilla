/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.Electricidad;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface ElectricidadMappers {

    Electricidad getElectricidad(Integer id_electricidad);

    ArrayList getAllElectricidad();

    Electricidad getElectricidadPorNombre();

    int createElectricidad(Electricidad electricidad);

    int updateElectricidad(Electricidad electricidad);

    int deleteElectricidad(Integer id_electricidad);
}
