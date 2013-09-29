/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinchilla.persistence.mappers;

import com.chinchilla.persistence.objects.CostePersonal;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public interface CostePersonalMappers {

    CostePersonal getCostePersonal(Integer id_coste_personal);

    ArrayList getAllCostePersonal();

    CostePersonal getCostePersonalPorNombre();

    int createCostePersonal(CostePersonal coste_personal);

    int updateCostePersonal(CostePersonal coste_personal);

    int deleteCostePersonal(Integer id_coste_personal);
}
